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
 * 商户支付渠道表
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_merchant_payment_channel")
public class MerchantPaymentChannelEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 渠道ID
     */
    @TableId(value = "application_channel_id", type = IdType.AUTO)
    private Long applicationChannelId;

    /**
     * 商户ID
     */
    private String merchantId;

    /**
     * 应用ID
     */
    private String applicationId;

    /**
     * 渠道ID
     */
    private Long channelId;

    /**
     * 启用/禁用
     */
    private Boolean status;

    /**
     * 手续费率
     */
    private BigDecimal feeRate;

    /**
     * 单笔限额
     */
    private BigDecimal limitAmount;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    public PaymentChannelDTO toPaymentChannelDTO(PaymentChannelEntity entity) {
        PaymentChannelDTO dto = new PaymentChannelDTO();
        dto.setMerchantId(this.merchantId);
        dto.setApplicationId(this.applicationId);
        dto.setChannelId(this.channelId);
        dto.setChannelName(entity.getChannelName());
        dto.setChannelCode(entity.getChannelCode());
        dto.setStatus(this.status);
        dto.setFeeRate(this.feeRate);
        dto.setSuccessRate(entity.getSuccessRate());
        dto.setLimitAmount(this.limitAmount);
        dto.setWeight(entity.getWeight());
        return dto;
    }

}
