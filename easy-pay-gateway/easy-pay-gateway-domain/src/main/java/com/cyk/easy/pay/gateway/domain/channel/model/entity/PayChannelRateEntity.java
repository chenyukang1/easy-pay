package com.cyk.easy.pay.gateway.domain.channel.model.entity;

import java.math.BigDecimal;
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
 * 支付通道费率表
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_pay_channel_rate")
public class PayChannelRateEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * DB主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户号
     */
    private String mchNo;

    /**
     * 支付通道编码
     */
    private String channelCode;

    /**
     * 支付方式编码
     */
    private String wayCode;

    /**
     * 费率
     */
    private BigDecimal rate;

    /**
     * 单笔限额
     */
    private Integer singleLimit;

    /**
     * 日限额
     */
    private Integer dailyLimit;

    /**
     * 状态: 0-停用, 1-启用
     */
    private Byte state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;


}
