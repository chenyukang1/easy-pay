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
 * 支付通道定义表
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_pay_channel_info")
public class PayChannelInfoEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * DB主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 通道代码 全小写  wxpay alipay 
     */
    private String channelCode;

    /**
     * 通道名称
     */
    private String channelName;

    /**
     * 通道提供商 例如: WECHAT, ALIPAY, UNIONPAY
     */
    private String provider;

    /**
     * 支持的支付方式 ["wxpay_jsapi", "wxpay_bar"]
     */
    private String wayCodes;

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
