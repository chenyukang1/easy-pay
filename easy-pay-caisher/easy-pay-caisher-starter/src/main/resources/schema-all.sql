CREATE TABLE payment_consult_record
(
    id               BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    consult_id       VARCHAR(64)    NOT NULL UNIQUE COMMENT '支付咨询ID',
    order_id         VARCHAR(64)    NOT NULL COMMENT '订单号',
    merchant_id      VARCHAR(64)    NOT NULL COMMENT '商户号',
    user_id          VARCHAR(64)    NOT NULL COMMENT '用户ID',
    currency         VARCHAR(8)     NOT NULL COMMENT '币种',
    amount           DECIMAL(18, 2) NOT NULL COMMENT '金额',
    pay_methods_json JSON COMMENT '支付方式结果快照',
    result_status    ENUM('SUCCESS', 'FAIL', 'PARTIAL_FAIL') DEFAULT 'SUCCESS',
    created_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at       DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB COMMENT='支付咨询记录表';
