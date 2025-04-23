
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.GongyingshangEntity;
import com.entity.ShangpinEntity;
import com.entity.TuihuoEntity;
import com.entity.YuangongEntity;
import com.entity.view.TuihuoView;
import com.service.*;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 退货
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tuihuo")
public class TuihuoController {
    private static final Logger logger = LoggerFactory.getLogger(TuihuoController.class);

    @Autowired
    private TuihuoService tuihuoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private GongyingshangService gongyingshangService;
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
        PageUtils page = tuihuoService.queryPage(params);

        //字典表数据转换
        List<TuihuoView> list =(List<TuihuoView>)page.getList();
        for(TuihuoView c:list){
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
        TuihuoEntity tuihuo = tuihuoService.selectById(id);
        if(tuihuo !=null){
            //entity转view
            TuihuoView view = new TuihuoView();
            BeanUtils.copyProperties( tuihuo , view );//把实体数据重构到view中

                //级联表
                GongyingshangEntity gongyingshang = gongyingshangService.selectById(tuihuo.getGongyingshangId());
                if(gongyingshang != null){
                    BeanUtils.copyProperties( gongyingshang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGongyingshangId(gongyingshang.getId());
                }
                //级联表
                ShangpinEntity shangpin = shangpinService.selectById(tuihuo.getShangpinId());
                if(shangpin != null){
                    BeanUtils.copyProperties( shangpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangpinId(shangpin.getId());
                }
                //级联表
                YuangongEntity yuangong = yuangongService.selectById(tuihuo.getYuangongId());
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
    public R save(@RequestBody TuihuoEntity tuihuo, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tuihuo:{}",this.getClass().getName(),tuihuo.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            tuihuo.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));



        ShangpinEntity shangpinEntity = shangpinService.selectById(tuihuo.getShangpinId());
        if(shangpinEntity == null)
            return R.error("查不到商品");

        int banlance = shangpinEntity.getShangpinKucunNumber() - tuihuo.getTuihuoNumber();
        if(banlance <0)
            return R.error("退货数量不能大于现有库存数量");
        shangpinEntity.setShangpinKucunNumber(banlance);
        shangpinService.updateById(shangpinEntity);



        tuihuo.setInsertTime(new Date());
            tuihuo.setCreateTime(new Date());
            tuihuoService.insert(tuihuo);
            return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TuihuoEntity tuihuo, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,tuihuo:{}",this.getClass().getName(),tuihuo.toString());

            tuihuoService.updateById(tuihuo);//根据id更新
            return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        tuihuoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<TuihuoEntity> tuihuoList = new ArrayList<>();//上传的东西
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
                            TuihuoEntity tuihuoEntity = new TuihuoEntity();
//                            tuihuoEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            tuihuoEntity.setShangpinId(Integer.valueOf(data.get(0)));   //商品 要改的
//                            tuihuoEntity.setGongyingshangId(Integer.valueOf(data.get(0)));   //供应商 要改的
//                            tuihuoEntity.setTuihuoUuidNumber(data.get(0));                    //退货单号 要改的
//                            tuihuoEntity.setTuihuoNumber(Integer.valueOf(data.get(0)));   //退货数量 要改的
//                            tuihuoEntity.setTuihuoTime(sdf.parse(data.get(0)));          //退货时间 要改的
//                            tuihuoEntity.setTuihuoContent("");//详情和图片
//                            tuihuoEntity.setInsertTime(date);//时间
//                            tuihuoEntity.setCreateTime(date);//时间
                            tuihuoList.add(tuihuoEntity);


                            //把要查询是否重复的字段放入map中
                                //退货单号
                                if(seachFields.containsKey("tuihuoUuidNumber")){
                                    List<String> tuihuoUuidNumber = seachFields.get("tuihuoUuidNumber");
                                    tuihuoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> tuihuoUuidNumber = new ArrayList<>();
                                    tuihuoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("tuihuoUuidNumber",tuihuoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //退货单号
                        List<TuihuoEntity> tuihuoEntities_tuihuoUuidNumber = tuihuoService.selectList(new EntityWrapper<TuihuoEntity>().in("tuihuo_uuid_number", seachFields.get("tuihuoUuidNumber")));
                        if(tuihuoEntities_tuihuoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TuihuoEntity s:tuihuoEntities_tuihuoUuidNumber){
                                repeatFields.add(s.getTuihuoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [退货单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        tuihuoService.insertBatch(tuihuoList);
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
