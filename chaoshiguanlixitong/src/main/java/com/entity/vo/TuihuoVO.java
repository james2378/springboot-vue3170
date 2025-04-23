package com.entity.vo;

import com.entity.TuihuoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 退货
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tuihuo")
public class TuihuoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
