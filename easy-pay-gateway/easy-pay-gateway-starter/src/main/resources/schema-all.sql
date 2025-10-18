-- 支付方式表  pay_way
DROP TABLE IF EXISTS t_pay_way;
CREATE TABLE `t_pay_way`
(
    `way_code`   VARCHAR(20)  NOT NULL COMMENT '支付方式代码  例如： wxpay_jsapi',
    `way_name`   VARCHAR(20)  NOT NULL COMMENT '支付方式名称',
    `created_at` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`way_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付方式表';

-- 支付接口定义表
DROP TABLE IF EXISTS t_pay_interface_define;
CREATE TABLE `t_pay_interface_define`
(
    `if_code`           VARCHAR(20)  NOT NULL COMMENT '接口代码 全小写  wxpay alipay ',
    `if_name`           VARCHAR(20)  NOT NULL COMMENT '接口名称',
    `is_mch_mode`       TINYINT(6) NOT NULL DEFAULT 1 COMMENT '是否支持普通商户模式: 0-不支持, 1-支持',
    `is_isv_mode`       TINYINT(6) NOT NULL DEFAULT 1 COMMENT '是否支持服务商子商户模式: 0-不支持, 1-支持',
    `config_page_type`  TINYINT(6) NOT NULL DEFAULT 1 COMMENT '支付参数配置页面类型:1-JSON渲染,2-自定义',
    `isv_params`        VARCHAR(4096)         DEFAULT NULL COMMENT 'ISV接口配置定义描述,json字符串',
    `isvsub_mch_params` VARCHAR(4096)         DEFAULT NULL COMMENT '特约商户接口配置定义描述,json字符串',
    `normal_mch_params` VARCHAR(4096)         DEFAULT NULL COMMENT '普通商户接口配置定义描述,json字符串',
    `way_codes`         JSON         NOT NULL COMMENT '支持的支付方式 ["wxpay_jsapi", "wxpay_bar"]',
    `icon`              VARCHAR(256)          DEFAULT NULL COMMENT '页面展示：卡片-图标',
    `bg_color`          VARCHAR(20)           DEFAULT NULL COMMENT '页面展示：卡片-背景色',
    `state`             TINYINT(6) NOT NULL DEFAULT 1 COMMENT '状态: 0-停用, 1-启用',
    `remark`            VARCHAR(128)          DEFAULT NULL COMMENT '备注',
    `created_at`        TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`        TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`if_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付接口定义表';

-- 支付接口配置参数表
DROP TABLE IF EXISTS t_pay_interface_config;
CREATE TABLE `t_pay_interface_config`
(
    `id`          BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `info_type`   TINYINT(6) NOT NULL COMMENT '账号类型:1-服务商 2-商户 3-商户应用',
    `info_id`     VARCHAR(64)   NOT NULL COMMENT '服务商号/商户号/应用ID',
    `if_code`     VARCHAR(20)   NOT NULL COMMENT '支付接口代码',
    `if_params`   VARCHAR(4096) NOT NULL COMMENT '接口配置参数,json字符串',
    `if_rate`     DECIMAL(20, 6)         DEFAULT NULL COMMENT '支付接口费率',
    `state`       TINYINT(1) NOT NULL default 1 COMMENT '状态: 0-停用, 1-启用',
    `remark`      VARCHAR(128)           DEFAULT NULL COMMENT '备注',
    `created_uid` BIGINT(20) COMMENT '创建者用户ID',
    `created_by`  VARCHAR(64) COMMENT '创建者姓名',
    `created_at`  TIMESTAMP(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_uid` BIGINT(20) COMMENT '更新者用户ID',
    `updated_by`  VARCHAR(64) COMMENT '更新者姓名',
    `updated_at`  TIMESTAMP(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `Uni_InfoType_InfoId_IfCode` (`info_type`, `info_id`, `if_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付接口配置参数表';

-- 商户支付通道表 (允许商户 支付方式 对应多个支付接口的配置)
DROP TABLE IF EXISTS t_mch_pay_channel;
CREATE TABLE `t_mch_pay_channel`
(
    `id`          BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `mch_no`      VARCHAR(64)    NOT NULL COMMENT '商户号',
    `app_id`      VARCHAR(64)    NOT NULL COMMENT '应用ID',
    `if_code`     VARCHAR(20)    NOT NULL COMMENT '支付接口',
    `way_code`    VARCHAR(20)    NOT NULL COMMENT '支付方式',
    `rate`        DECIMAL(20, 6) NOT NULL COMMENT '支付方式费率',
    `risk_config` JSON                    DEFAULT NULL COMMENT '风控数据',
    `state`       TINYINT(6) NOT NULL COMMENT '状态: 0-停用, 1-启用',
    `created_at`  TIMESTAMP(3)   NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`  TIMESTAMP(3)   NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `Uni_AppId_WayCode` (`app_id`,`if_code`, `way_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商户支付通道表';

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
