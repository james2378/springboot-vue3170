package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 商品销售
 *
 * @author 
 * @email
 */
@TableName("shangpinxiaoshou")
public class ShangpinxiaoshouEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShangpinxiaoshouEntity() {

	}

	public ShangpinxiaoshouEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 员工
     */
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 会员
     */
    @TableField(value = "huiyuan_id")

    private Integer huiyuanId;


    /**
     * 商品
     */
    @TableField(value = "shangpin_id")

    private Integer shangpinId;


    /**
     * 商品销售单号
     */
    @TableField(value = "shangpinxiaoshou_uuid_number")

    private String shangpinxiaoshouUuidNumber;


    /**
     * 商品销售数量
     */
    @TableField(value = "shangpinxiaoshou_number")

    private Integer shangpinxiaoshouNumber;


    /**
     * 销售金额
     */
    @TableField(value = "shangpinxiaoshou_true_price")

    private Double shangpinxiaoshouTruePrice;


    /**
     * 商品销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "shangpinxiaoshou_time")

    private Date shangpinxiaoshouTime;


    /**
     * 商品销售备注
     */
    @TableField(value = "shangpinxiaoshou_content")

    private String shangpinxiaoshouContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }
    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：会员
	 */
    public Integer getHuiyuanId() {
        return huiyuanId;
    }
    /**
	 * 获取：会员
	 */

    public void setHuiyuanId(Integer huiyuanId) {
        this.huiyuanId = huiyuanId;
    }
    /**
	 * 设置：商品
	 */
    public Integer getShangpinId() {
        return shangpinId;
    }
    /**
	 * 获取：商品
	 */

    public void setShangpinId(Integer shangpinId) {
        this.shangpinId = shangpinId;
    }
    /**
	 * 设置：商品销售单号
	 */
    public String getShangpinxiaoshouUuidNumber() {
        return shangpinxiaoshouUuidNumber;
    }
    /**
	 * 获取：商品销售单号
	 */

    public void setShangpinxiaoshouUuidNumber(String shangpinxiaoshouUuidNumber) {
        this.shangpinxiaoshouUuidNumber = shangpinxiaoshouUuidNumber;
    }
    /**
	 * 设置：商品销售数量
	 */
    public Integer getShangpinxiaoshouNumber() {
        return shangpinxiaoshouNumber;
    }
    /**
	 * 获取：商品销售数量
	 */

    public void setShangpinxiaoshouNumber(Integer shangpinxiaoshouNumber) {
        this.shangpinxiaoshouNumber = shangpinxiaoshouNumber;
    }
    /**
	 * 设置：销售金额
	 */
    public Double getShangpinxiaoshouTruePrice() {
        return shangpinxiaoshouTruePrice;
    }
    /**
	 * 获取：销售金额
	 */

    public void setShangpinxiaoshouTruePrice(Double shangpinxiaoshouTruePrice) {
        this.shangpinxiaoshouTruePrice = shangpinxiaoshouTruePrice;
    }
    /**
	 * 设置：商品销售时间
	 */
    public Date getShangpinxiaoshouTime() {
        return shangpinxiaoshouTime;
    }
    /**
	 * 获取：商品销售时间
	 */

    public void setShangpinxiaoshouTime(Date shangpinxiaoshouTime) {
        this.shangpinxiaoshouTime = shangpinxiaoshouTime;
    }
    /**
	 * 设置：商品销售备注
	 */
    public String getShangpinxiaoshouContent() {
        return shangpinxiaoshouContent;
    }
    /**
	 * 获取：商品销售备注
	 */

    public void setShangpinxiaoshouContent(String shangpinxiaoshouContent) {
        this.shangpinxiaoshouContent = shangpinxiaoshouContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shangpinxiaoshou{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", huiyuanId=" + huiyuanId +
            ", shangpinId=" + shangpinId +
            ", shangpinxiaoshouUuidNumber=" + shangpinxiaoshouUuidNumber +
            ", shangpinxiaoshouNumber=" + shangpinxiaoshouNumber +
            ", shangpinxiaoshouTruePrice=" + shangpinxiaoshouTruePrice +
            ", shangpinxiaoshouTime=" + shangpinxiaoshouTime +
            ", shangpinxiaoshouContent=" + shangpinxiaoshouContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
