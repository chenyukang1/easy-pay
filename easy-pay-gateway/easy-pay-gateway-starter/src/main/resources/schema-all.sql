-- 支付方式表  pay_way
DROP TABLE IF EXISTS t_pay_way;
CREATE TABLE `t_pay_way`
(
    `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'DB主键',
    `way_code`   VARCHAR(20)  NOT NULL COMMENT '支付方式代码  例如： wxpay_jsapi',
    `way_name`   VARCHAR(20)  NOT NULL COMMENT '支付方式名称',
    `created_at` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unq_way_code` (`way_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付方式表';

-- 支付通道定义表
DROP TABLE IF EXISTS t_pay_channel_info;
CREATE TABLE `t_pay_channel_info`
(
    `id`           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'DB主键',
    `channel_code` VARCHAR(32)  NOT NULL COMMENT '通道代码 全小写  wxpay alipay ',
    `channel_name` VARCHAR(64)  NOT NULL COMMENT '通道名称',
    `provider`     VARCHAR(32)  NOT NULL COMMENT '通道提供商 例如: WECHAT, ALIPAY, UNIONPAY',
    `way_codes`    JSON         NOT NULL COMMENT '支持的支付方式 ["wxpay_jsapi", "wxpay_bar"]',
    `state`        TINYINT(1) NOT NULL DEFAULT 1 COMMENT '状态: 0-停用, 1-启用',
    `remark`       VARCHAR(128)          DEFAULT NULL COMMENT '备注',
    `created_at`   TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`   TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unq_channel_code` (`channel_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付通道定义表';

-- 支付通道配置表（普通商户/服务商）
DROP TABLE IF EXISTS t_pay_channel_config;
CREATE TABLE `t_pay_channel_config`
(
    `id`             BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'DB主键',
    `channel_code`   VARCHAR(20)   NOT NULL COMMENT '支付通道编码',
    `account_type`   TINYINT(6) NOT NULL COMMENT '账号类型:1-普通商户 2-服务商 3-特约商户',
    `mch_no`         VARCHAR(32) NULL COMMENT '商户号（普通商户）',
    `isv_no`         VARCHAR(32) NULL COMMENT '服务商编号（特约商户）',
    `mch_id`         VARCHAR(64)   NOT NULL COMMENT '渠道商户号（如支付宝PID、微信MchID）',
    `channel_params` VARCHAR(4096) NOT NULL COMMENT '支付通道配置参数，json字符串',
    `state`          TINYINT(1) NOT NULL default 1 COMMENT '状态: 0-停用, 1-启用',
    `remark`         VARCHAR(128)           DEFAULT NULL COMMENT '备注',
    `created_at`     TIMESTAMP(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`     TIMESTAMP(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付通道配置表';

-- 商户应用支付通道表 (允许商户下的应用对应多个支付通道配置)
DROP TABLE IF EXISTS t_mch_pay_channel_config;
CREATE TABLE `t_mch_pay_channel_config`
(
    `id`           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'DB主键',
    `mch_no`       VARCHAR(64)  NOT NULL COMMENT '商户号',
    `app_id`       VARCHAR(64)  NOT NULL COMMENT '应用ID',
    `config_id`    BIGINT UNSIGNED  NOT NULL COMMENT '通道配置ID',
    `channel_code` VARCHAR(20)  NOT NULL COMMENT '支付通道代码',
    `state`        TINYINT(1) NOT NULL COMMENT '状态: 0-停用, 1-启用',
    `created_at`   TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`   TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unq_mach_app_config` (`mch_no`,`app_id`, `config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商户支付通道表';

-- 支付通道费率表
DROP TABLE IF EXISTS t_pay_channel_rate;
CREATE TABLE `t_pay_channel_rate`
(
    `id`           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'DB主键',
    `mch_no`       VARCHAR(32) NULL COMMENT '商户号',
    `channel_code` VARCHAR(20)    NOT NULL COMMENT '支付通道编码',
    `way_code`     VARCHAR(20)    NOT NULL COMMENT '支付方式编码',
    `rate`         DECIMAL(20, 6) NOT NULL COMMENT '费率',
    `single_limit` INT(11) NOT NULL COMMENT '单笔限额',
    `daily_limit`  INT(11) NOT NULL COMMENT '日限额',
    `state`        TINYINT(1) NOT NULL default 1 COMMENT '状态: 0-停用, 1-启用',
    `remark`       VARCHAR(128)            DEFAULT NULL COMMENT '备注',
    `created_at`   TIMESTAMP(3)   NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`   TIMESTAMP(3)   NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unq_mch_no_channel_code_way_code` (`mch_no`, `channel_code`, `way_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付通道费率表';

-- 路由规则表 t_routing_rule
DROP TABLE IF EXISTS t_routing_rule;
CREATE TABLE t_routing_rule
(
    `rule_id`     BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '规则ID',
    `rule_name`   VARCHAR(100) NOT NULL COMMENT '规则名称',
    `merchant_id` VARCHAR(64) NULL COMMENT '商户ID',
    `drl_content` TEXT         NOT NULL COMMENT 'DRL 文件内容',
    `status`      TINYINT(1) NOT NULL DEFAULT 1 COMMENT '启用/禁用',
    `created_at`  TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`  TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='路由规则表';

-- 路由记录表 t_routing_record
DROP TABLE IF EXISTS t_routing_record;
CREATE TABLE t_routing_record
(
    `record_id`           BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '记录ID',
    `transaction_id`      VARCHAR(64)  NOT NULL COMMENT '交易ID',
    `merchant_id`         VARCHAR(64)  NOT NULL COMMENT '商户ID',
    `application_id`      VARCHAR(64)  NOT NULL COMMENT '应用ID',
    `rule_id`             BIGINT UNSIGNED NOT NULL COMMENT '规则ID',
    `selected_channel_id` BIGINT UNSIGNED NOT NULL COMMENT '最终通道ID',
    `status`              TINYINT(1) NOT NULL DEFAULT 1 COMMENT '启用/禁用',
    `created_at`          TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`          TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='路由记录表';
