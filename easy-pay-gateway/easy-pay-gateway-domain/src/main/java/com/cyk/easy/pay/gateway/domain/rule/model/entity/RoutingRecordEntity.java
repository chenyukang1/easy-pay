package com.cyk.easy.pay.gateway.domain.rule.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 路由记录表
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_routing_record")
public class RoutingRecordEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 记录ID
     */
    @TableId(value = "record_id", type = IdType.AUTO)
    private Long recordId;

    /**
     * 交易ID
     */
    private String transactionId;

    /**
     * 商户ID
     */
    private String merchantId;

    /**
     * 规则ID
     */
    private Long ruleId;

    /**
     * 最终通道ID
     */
    private Long selectedChannelId;

    /**
     * 启用/禁用
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;


}
