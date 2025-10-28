package com.cyk.easy.pay.gateway.domain.channel.model.entity;

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
 * 支付通道配置表
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_pay_channel_config")
public class PayChannelConfigEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * DB主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户号（普通商户）
     */
    private String mchNo;

    /**
     * 服务商编号（特约商户）
     */
    private String isvNo;

    /**
     * 支付通道编码
     */
    private String channelCode;

    /**
     * 账号类型:1-普通商户 2-服务商 3-特约商户
     */
    private Byte accountType;

    /**
     * 渠道商户号（如支付宝PID、微信MchID）
     */
    private String mchId;

    /**
     * 支付通道配置参数，json字符串
     */
    private String channelParams;

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
