package com.cyk.easy.pay.routing.domain.channel.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentChannelDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 支付渠道表
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_payment_channel")
public class PaymentChannelEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 渠道ID
     */
    @TableId(value = "channel_id", type = IdType.AUTO)
    private Long channelId;

    /**
     * 渠道代码  例如： wxpay_jsapi
     */
    private String channelCode;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 启用/禁用
     */
    private Boolean status;

    /**
     * 手续费率
     */
    private BigDecimal feeRate;

    /**
     * 成功率
     */
    private BigDecimal successRate;

    /**
     * 单笔限额
     */
    private BigDecimal limitAmount;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    public PaymentChannelDTO toPaymentChannelDTO() {
        PaymentChannelDTO dto = new PaymentChannelDTO();
        dto.setChannelId(this.channelId);
        dto.setChannelCode(this.channelCode);
        dto.setChannelName(this.channelName);
        dto.setStatus(this.status);
        dto.setFeeRate(this.feeRate);
        dto.setSuccessRate(this.successRate);
        dto.setLimitAmount(this.limitAmount);
        dto.setWeight(this.weight);
        return dto;
    }

}
