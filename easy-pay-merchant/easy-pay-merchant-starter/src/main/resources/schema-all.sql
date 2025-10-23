-- 系统用户表
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`
(
    `id`             BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `sys_user_id`    BIGINT UNSIGNED NOT NULL COMMENT '系统用户ID',
    `username`       VARCHAR(32)  NOT NULL COMMENT '登录用户名',
    `real_name`      VARCHAR(32)  NOT NULL COMMENT '真实姓名',
    `phone_number`   VARCHAR(32)  NOT NULL COMMENT '手机号',
    `sex`            TINYINT(6) NOT NULL DEFAULT 0 COMMENT '性别 0-未知, 1-男, 2-女',
    `avatar_url`     VARCHAR(128) COMMENT '头像地址',
    `user_no`        VARCHAR(32) COMMENT '员工编号',
    `is_admin`       TINYINT(6) NOT NULL DEFAULT 0 COMMENT '是否超管（超管拥有全部权限） 0-否 1-是',
    `state`          TINYINT(6) NOT NULL DEFAULT 0 COMMENT '状态 0-停用 1-启用',
    `sys_type`       VARCHAR(8)   NOT NULL COMMENT '所属系统： MGR-运营平台, MCH-商户中心',
    `belong_info_id` VARCHAR(64)  NOT NULL DEFAULT '0' COMMENT '所属商户ID / 0(平台)',
    `created_at`     TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`     TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`sys_user_id`),
    UNIQUE KEY (`sys_type`,`username`),
    UNIQUE KEY (`sys_type`,`phone_number`),
    UNIQUE KEY (`sys_type`, `user_no`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';

-- 商户信息表
DROP TABLE IF EXISTS t_mch_info;
CREATE TABLE `t_mch_info`
(
    `id`             BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `mch_id`         BIGINT UNSIGNED  NOT NULL COMMENT '商户id（分片键）',
    `mch_no`         VARCHAR(64)  NOT NULL COMMENT '商户号，对外标识',
    `mch_name`       VARCHAR(64)  NOT NULL COMMENT '商户名称',
    `mch_short_name` VARCHAR(32)  NOT NULL COMMENT '商户简称',
    `type`           TINYINT(6) NOT NULL DEFAULT 1 COMMENT '类型: 1-普通商户, 2-特约商户(服务商模式)',
    `isv_no`         VARCHAR(64) COMMENT '服务商号',
    `contact_name`   VARCHAR(32) COMMENT '联系人姓名',
    `contact_tel`    VARCHAR(32) COMMENT '联系人手机号',
    `contact_email`  VARCHAR(32) COMMENT '联系人邮箱',
    `state`          TINYINT(1) NOT NULL DEFAULT 1 COMMENT '商户状态: 0-停用, 1-正常',
    `remark`         VARCHAR(128) COMMENT '商户备注',
    `init_user_id`   BIGINT(20) DEFAULT NULL COMMENT '初始用户ID（创建商户时，允许商户登录的用户）',
    `created_uid`    BIGINT(20) COMMENT '创建者用户ID',
    `created_by`     VARCHAR(64) COMMENT '创建者姓名',
    `created_at`     TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`     TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_mch_id` (`mch_id`),
    UNIQUE KEY `uk_mch_no` (`mch_no`),
    UNIQUE KEY `uk_mch_name` (`mch_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商户信息表';

-- 商户应用表
DROP TABLE IF EXISTS t_mch_app;
CREATE TABLE `t_mch_app`
(
    `id`          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `mch_no`      VARCHAR(64)  NOT NULL COMMENT '商户号',
    `app_id`      varchar(64)  NOT NULL COMMENT '应用ID',
    `app_name`    varchar(64)  NOT NULL DEFAULT '' COMMENT '应用名称',
    `state`       TINYINT(1) NOT NULL DEFAULT 1 COMMENT '应用状态: 0-停用, 1-正常',
    `app_secret`  VARCHAR(128) NOT NULL COMMENT '应用私钥',
    `remark`      varchar(128)          DEFAULT NULL COMMENT '备注',
    `created_uid` BIGINT(20) COMMENT '创建者用户ID',
    `created_by`  VARCHAR(64) COMMENT '创建者姓名',
    `created_at`  TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`  TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_app_id` (`app_id`),
    UNIQUE KEY `uk_mch_app_name` (`mch_no`, `app_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商户应用表';

-- 服务商信息表
DROP TABLE IF EXISTS t_isv_info;
CREATE TABLE `t_isv_info`
(
    `id`             BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `isv_no`         VARCHAR(64)  NOT NULL COMMENT '服务商号',
    `isv_name`       VARCHAR(64)  NOT NULL COMMENT '服务商名称',
    `isv_short_name` VARCHAR(32)  NOT NULL COMMENT '服务商简称',
    `contact_name`   VARCHAR(32) COMMENT '联系人姓名',
    `contact_tel`    VARCHAR(32) COMMENT '联系人手机号',
    `contact_email`  VARCHAR(32) COMMENT '联系人邮箱',
    `state`          TINYINT(1) NOT NULL DEFAULT 1 COMMENT '状态: 0-停用, 1-正常',
    `remark`         VARCHAR(128)          DEFAULT NULL COMMENT '备注',
    `created_uid`    BIGINT(20) COMMENT '创建者用户ID',
    `created_by`     VARCHAR(64) COMMENT '创建者姓名',
    `created_at`     TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`     TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`isv_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='服务商信息表';