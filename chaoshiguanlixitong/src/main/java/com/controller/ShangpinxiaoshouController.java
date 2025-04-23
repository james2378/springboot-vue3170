
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 商品销售
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shangpinxiaoshou")
public class ShangpinxiaoshouController {
    private static final Logger logger = LoggerFactory.getLogger(ShangpinxiaoshouController.class);

    @Autowired
    private ShangpinxiaoshouService shangpinxiaoshouService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private HuiyuanService huiyuanService;
    @Autowired
    private ShangpinService shangpinService;
    @Autowired
    private YuangongService yuangongService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shangpinxiaoshouService.queryPage(params);

        //字典表数据转换
        List<ShangpinxiaoshouView> list =(List<ShangpinxiaoshouView>)page.getList();
        for(ShangpinxiaoshouView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShangpinxiaoshouEntity shangpinxiaoshou = shangpinxiaoshouService.selectById(id);
        if(shangpinxiaoshou !=null){
            //entity转view
            ShangpinxiaoshouView view = new ShangpinxiaoshouView();
            BeanUtils.copyProperties( shangpinxiaoshou , view );//把实体数据重构到view中

                //级联表
                HuiyuanEntity huiyuan = huiyuanService.selectById(shangpinxiaoshou.getHuiyuanId());
                if(huiyuan != null){
                    BeanUtils.copyProperties( huiyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuiyuanId(huiyuan.getId());
                }
                //级联表
                ShangpinEntity shangpin = shangpinService.selectById(shangpinxiaoshou.getShangpinId());
                if(shangpin != null){
                    BeanUtils.copyProperties( shangpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangpinId(shangpin.getId());
                }
                //级联表
                YuangongEntity yuangong = yuangongService.selectById(shangpinxiaoshou.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShangpinxiaoshouEntity shangpinxiaoshou, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shangpinxiaoshou:{}",this.getClass().getName(),shangpinxiaoshou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            shangpinxiaoshou.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));



        ShangpinEntity shangpinEntity = shangpinService.selectById(shangpinxiaoshou.getShangpinId());
        if(shangpinEntity == null)
            return R.error("查不到商品");
        int banlance = shangpinEntity.getShangpinKucunNumber() - shangpinxiaoshou.getShangpinxiaoshouNumber();
        if(banlance <0)
            return R.error("销售数量不能大于现有库存数量");
        shangpinEntity.setShangpinKucunNumber(banlance);
        shangpinService.updateById(shangpinEntity);


        shangpinxiaoshou.setShangpinxiaoshouTruePrice(shangpinxiaoshou.getShangpinxiaoshouNumber()*shangpinEntity.getShangpinNewMoney());
        shangpinxiaoshou.setInsertTime(new Date());
            shangpinxiaoshou.setCreateTime(new Date());
            shangpinxiaoshouService.insert(shangpinxiaoshou);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShangpinxiaoshouEntity shangpinxiaoshou, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shangpinxiaoshou:{}",this.getClass().getName(),shangpinxiaoshou.toString());

        ShangpinEntity shangpinEntity = shangpinService.selectById(shangpinxiaoshou.getShangpinId());
        if(shangpinEntity != null){
            shangpinxiaoshou.setShangpinxiaoshouTruePrice(shangpinxiaoshou.getShangpinxiaoshouNumber()*shangpinEntity.getShangpinNewMoney());
        }
            shangpinxiaoshouService.updateById(shangpinxiaoshou);//根据id更新
            return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shangpinxiaoshouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShangpinxiaoshouEntity> shangpinxiaoshouList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShangpinxiaoshouEntity shangpinxiaoshouEntity = new ShangpinxiaoshouEntity();
//                            shangpinxiaoshouEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            shangpinxiaoshouEntity.setHuiyuanId(Integer.valueOf(data.get(0)));   //会员 要改的
//                            shangpinxiaoshouEntity.setShangpinId(Integer.valueOf(data.get(0)));   //商品 要改的
//                            shangpinxiaoshouEntity.setShangpinxiaoshouUuidNumber(data.get(0));                    //商品销售单号 要改的
//                            shangpinxiaoshouEntity.setShangpinxiaoshouNumber(Integer.valueOf(data.get(0)));   //商品销售数量 要改的
//                            shangpinxiaoshouEntity.setShangpinxiaoshouTruePrice(data.get(0));                    //销售金额 要改的
//                            shangpinxiaoshouEntity.setShangpinxiaoshouTime(sdf.parse(data.get(0)));          //商品销售时间 要改的
//                            shangpinxiaoshouEntity.setShangpinxiaoshouContent("");//详情和图片
//                            shangpinxiaoshouEntity.setInsertTime(date);//时间
//                            shangpinxiaoshouEntity.setCreateTime(date);//时间
                            shangpinxiaoshouList.add(shangpinxiaoshouEntity);


                            //把要查询是否重复的字段放入map中
                                //商品销售单号
                                if(seachFields.containsKey("shangpinxiaoshouUuidNumber")){
                                    List<String> shangpinxiaoshouUuidNumber = seachFields.get("shangpinxiaoshouUuidNumber");
                                    shangpinxiaoshouUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shangpinxiaoshouUuidNumber = new ArrayList<>();
                                    shangpinxiaoshouUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shangpinxiaoshouUuidNumber",shangpinxiaoshouUuidNumber);
                                }
                        }

                        //查询是否重复
                         //商品销售单号
                        List<ShangpinxiaoshouEntity> shangpinxiaoshouEntities_shangpinxiaoshouUuidNumber = shangpinxiaoshouService.selectList(new EntityWrapper<ShangpinxiaoshouEntity>().in("shangpinxiaoshou_uuid_number", seachFields.get("shangpinxiaoshouUuidNumber")));
                        if(shangpinxiaoshouEntities_shangpinxiaoshouUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShangpinxiaoshouEntity s:shangpinxiaoshouEntities_shangpinxiaoshouUuidNumber){
                                repeatFields.add(s.getShangpinxiaoshouUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [商品销售单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shangpinxiaoshouService.insertBatch(shangpinxiaoshouList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
