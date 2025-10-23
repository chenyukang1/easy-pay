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
 * 商户信息表
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_mch_info")
public class MchInfoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 965057291695141193L;

    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户ID
     */
    private Long mchId;

    /**
     * 商户号
     */
    private String mchNo;

    /**
     * 商户名称
     */
    private String mchName;

    /**
     * 商户简称
     */
    private String mchShortName;

    /**
     * 类型: 1-普通商户, 2-特约商户(服务商模式)
     */
    private Byte type;

    /**
     * 服务商号
     */
    private String isvNo;

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
     * 商户状态: 0-停用, 1-正常
     */
    private Byte state;

    /**
     * 商户备注
     */
    private String remark;

    /**
     * 初始用户ID（创建商户时，允许商户登录的用户）
     */
    private Long initUserId;

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
