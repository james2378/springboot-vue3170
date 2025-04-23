package com.entity.model;

import com.entity.JinhuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 进货
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JinhuoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 商品
     */
    private Integer shangpinId;


    /**
     * 供应商
     */
    private Integer gongyingshangId;


    /**
     * 进货单号
     */
    private String jinhuoUuidNumber;


    /**
     * 进货数量
     */
    private Integer jinhuoNumber;


    /**
     * 进货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jinhuoTime;


    /**
     * 进货备注
     */
    private String jinhuoContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：商品
	 */
    public Integer getShangpinId() {
        return shangpinId;
    }


    /**
	 * 设置：商品
	 */
    public void setShangpinId(Integer shangpinId) {
        this.shangpinId = shangpinId;
    }
    /**
	 * 获取：供应商
	 */
    public Integer getGongyingshangId() {
        return gongyingshangId;
    }


    /**
	 * 设置：供应商
	 */
    public void setGongyingshangId(Integer gongyingshangId) {
        this.gongyingshangId = gongyingshangId;
    }
    /**
	 * 获取：进货单号
	 */
    public String getJinhuoUuidNumber() {
        return jinhuoUuidNumber;
    }


    /**
	 * 设置：进货单号
	 */
    public void setJinhuoUuidNumber(String jinhuoUuidNumber) {
        this.jinhuoUuidNumber = jinhuoUuidNumber;
    }
    /**
	 * 获取：进货数量
	 */
    public Integer getJinhuoNumber() {
        return jinhuoNumber;
    }


    /**
	 * 设置：进货数量
	 */
    public void setJinhuoNumber(Integer jinhuoNumber) {
        this.jinhuoNumber = jinhuoNumber;
    }
    /**
	 * 获取：进货时间
	 */
    public Date getJinhuoTime() {
        return jinhuoTime;
    }


    /**
	 * 设置：进货时间
	 */
    public void setJinhuoTime(Date jinhuoTime) {
        this.jinhuoTime = jinhuoTime;
    }
    /**
	 * 获取：进货备注
	 */
    public String getJinhuoContent() {
        return jinhuoContent;
    }


    /**
	 * 设置：进货备注
	 */
    public void setJinhuoContent(String jinhuoContent) {
        this.jinhuoContent = jinhuoContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
