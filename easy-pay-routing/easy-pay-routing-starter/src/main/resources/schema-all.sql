-- 支付渠道表 t_payment_channel
DROP TABLE IF EXISTS t_payment_channel;
CREATE TABLE `t_payment_channel`
(
    `channel_id`   BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '渠道ID',
    `channel_code` VARCHAR(20)    NOT NULL COMMENT '渠道代码  例如： wxpay_jsapi',
    `channel_name` VARCHAR(20)    NOT NULL COMMENT '渠道名称',
    `status`       TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '启用/禁用',
    `fee_rate`     DECIMAL(20, 6) NOT NULL COMMENT '手续费率',
    `success_rate` DECIMAL(20, 6) NOT NULL COMMENT '成功率',
    `weight`       INT            NOT NULL COMMENT '权重',
    `limit_amount` DECIMAL(20, 6) NOT NULL COMMENT '单笔限额',
    `created_at`   TIMESTAMP(3)   NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`   TIMESTAMP(3)   NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付渠道表';

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
    `rule_id`             BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '规则ID',
    `selected_channel_id` BIGINT UNSIGNED         NOT NULL COMMENT '最终通道ID',
    `status`              TINYINT(1) DEFAULT 1 NOT NULL COMMENT '启用/禁用',
    `created_at`          TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated_at`          TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='路由记录表';
