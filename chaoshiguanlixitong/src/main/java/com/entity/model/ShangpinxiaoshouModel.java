package com.entity.model;

import com.entity.ShangpinxiaoshouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品销售
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShangpinxiaoshouModel implements Serializable {
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
     * 会员
     */
    private Integer huiyuanId;


    /**
     * 商品
     */
    private Integer shangpinId;


    /**
     * 商品销售单号
     */
    private String shangpinxiaoshouUuidNumber;


    /**
     * 商品销售数量
     */
    private Integer shangpinxiaoshouNumber;


    /**
     * 销售金额
     */
    private Double shangpinxiaoshouTruePrice;


    /**
     * 商品销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shangpinxiaoshouTime;


    /**
     * 商品销售备注
     */
    private String shangpinxiaoshouContent;


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
	 * 获取：会员
	 */
    public Integer getHuiyuanId() {
        return huiyuanId;
    }


    /**
	 * 设置：会员
	 */
    public void setHuiyuanId(Integer huiyuanId) {
        this.huiyuanId = huiyuanId;
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
	 * 获取：商品销售单号
	 */
    public String getShangpinxiaoshouUuidNumber() {
        return shangpinxiaoshouUuidNumber;
    }


    /**
	 * 设置：商品销售单号
	 */
    public void setShangpinxiaoshouUuidNumber(String shangpinxiaoshouUuidNumber) {
        this.shangpinxiaoshouUuidNumber = shangpinxiaoshouUuidNumber;
    }
    /**
	 * 获取：商品销售数量
	 */
    public Integer getShangpinxiaoshouNumber() {
        return shangpinxiaoshouNumber;
    }


    /**
	 * 设置：商品销售数量
	 */
    public void setShangpinxiaoshouNumber(Integer shangpinxiaoshouNumber) {
        this.shangpinxiaoshouNumber = shangpinxiaoshouNumber;
    }
    /**
	 * 获取：销售金额
	 */
    public Double getShangpinxiaoshouTruePrice() {
        return shangpinxiaoshouTruePrice;
    }


    /**
	 * 设置：销售金额
	 */
    public void setShangpinxiaoshouTruePrice(Double shangpinxiaoshouTruePrice) {
        this.shangpinxiaoshouTruePrice = shangpinxiaoshouTruePrice;
    }
    /**
	 * 获取：商品销售时间
	 */
    public Date getShangpinxiaoshouTime() {
        return shangpinxiaoshouTime;
    }


    /**
	 * 设置：商品销售时间
	 */
    public void setShangpinxiaoshouTime(Date shangpinxiaoshouTime) {
        this.shangpinxiaoshouTime = shangpinxiaoshouTime;
    }
    /**
	 * 获取：商品销售备注
	 */
    public String getShangpinxiaoshouContent() {
        return shangpinxiaoshouContent;
    }


    /**
	 * 设置：商品销售备注
	 */
    public void setShangpinxiaoshouContent(String shangpinxiaoshouContent) {
        this.shangpinxiaoshouContent = shangpinxiaoshouContent;
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
