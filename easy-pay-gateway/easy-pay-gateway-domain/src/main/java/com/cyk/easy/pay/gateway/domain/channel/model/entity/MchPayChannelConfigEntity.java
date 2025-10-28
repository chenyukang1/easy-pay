package com.cyk.easy.pay.gateway.domain.channel.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商户支付通道表
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_mch_pay_channel_config")
public class MchPayChannelConfigEntity implements Serializable {

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
     * 应用ID
     */
    private String appId;

    /**
     * 通道配置ID
     */
    private Long configId;

    /**
     * 支付通道代码
     */
    private String channelCode;

    /**
     * 状态: 0-停用, 1-启用
     */
    private Byte state;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;


}
