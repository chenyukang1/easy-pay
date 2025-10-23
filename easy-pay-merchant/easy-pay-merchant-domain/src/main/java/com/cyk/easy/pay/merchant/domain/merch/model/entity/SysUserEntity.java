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
 * 系统用户表
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_sys_user")
public class SysUserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 8453215628980103478L;

    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 系统用户ID
     */
    private Long sysUserId;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 性别 0-未知, 1-男, 2-女
     */
    private Byte sex;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 员工编号
     */
    private String userNo;

    /**
     * 是否超管（超管拥有全部权限） 0-否 1-是
     */
    private Byte isAdmin;

    /**
     * 状态 0-停用 1-启用
     */
    private Byte state;

    /**
     * 所属系统： MGR-运营平台, MCH-商户中心
     */
    private String sysType;

    /**
     * 所属商户ID / 0(平台)
     */
    private String belongInfoId;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;


}
