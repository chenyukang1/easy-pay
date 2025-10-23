package com.cyk.easy.pay.merchant.domain.merch.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 服务商信息表
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_isv_info")
public class IsvInfoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 5748031153254589340L;

    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 服务商号
     */
    private String isvNo;

    /**
     * 服务商名称
     */
    private String isvName;

    /**
     * 服务商简称
     */
    private String isvShortName;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人手机号
     */
    private String contactTel;

    /**
     * 联系人邮箱
     */
    private String contactEmail;

    /**
     * 状态: 0-停用, 1-正常
     */
    private Boolean state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建者用户ID
     */
    private Long createdUid;

    /**
     * 创建者姓名
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;


}
