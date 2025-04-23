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
 * 退货
 *
 * @author 
 * @email
 */
@TableName("tuihuo")
public class TuihuoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TuihuoEntity() {

	}

	public TuihuoEntity(T t) {
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
     * 商品
     */
    @TableField(value = "shangpin_id")

    private Integer shangpinId;


    /**
     * 供应商
     */
    @TableField(value = "gongyingshang_id")

    private Integer gongyingshangId;


    /**
     * 退货单号
     */
    @TableField(value = "tuihuo_uuid_number")

    private String tuihuoUuidNumber;


    /**
     * 退货数量
     */
    @TableField(value = "tuihuo_number")

    private Integer tuihuoNumber;


    /**
     * 退货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "tuihuo_time")

    private Date tuihuoTime;


    /**
     * 退货备注
     */
    @TableField(value = "tuihuo_content")

    private String tuihuoContent;


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
	 * 设置：供应商
	 */
    public Integer getGongyingshangId() {
        return gongyingshangId;
    }
    /**
	 * 获取：供应商
	 */

    public void setGongyingshangId(Integer gongyingshangId) {
        this.gongyingshangId = gongyingshangId;
    }
    /**
	 * 设置：退货单号
	 */
    public String getTuihuoUuidNumber() {
        return tuihuoUuidNumber;
    }
    /**
	 * 获取：退货单号
	 */

    public void setTuihuoUuidNumber(String tuihuoUuidNumber) {
        this.tuihuoUuidNumber = tuihuoUuidNumber;
    }
    /**
	 * 设置：退货数量
	 */
    public Integer getTuihuoNumber() {
        return tuihuoNumber;
    }
    /**
	 * 获取：退货数量
	 */

    public void setTuihuoNumber(Integer tuihuoNumber) {
        this.tuihuoNumber = tuihuoNumber;
    }
    /**
	 * 设置：退货时间
	 */
    public Date getTuihuoTime() {
        return tuihuoTime;
    }
    /**
	 * 获取：退货时间
	 */

    public void setTuihuoTime(Date tuihuoTime) {
        this.tuihuoTime = tuihuoTime;
    }
    /**
	 * 设置：退货备注
	 */
    public String getTuihuoContent() {
        return tuihuoContent;
    }
    /**
	 * 获取：退货备注
	 */

    public void setTuihuoContent(String tuihuoContent) {
        this.tuihuoContent = tuihuoContent;
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
        return "Tuihuo{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", shangpinId=" + shangpinId +
            ", gongyingshangId=" + gongyingshangId +
            ", tuihuoUuidNumber=" + tuihuoUuidNumber +
            ", tuihuoNumber=" + tuihuoNumber +
            ", tuihuoTime=" + tuihuoTime +
            ", tuihuoContent=" + tuihuoContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
