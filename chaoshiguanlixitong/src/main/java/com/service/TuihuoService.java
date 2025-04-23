package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuihuoEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 退货 服务类
 */
public interface TuihuoService extends IService<TuihuoEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}