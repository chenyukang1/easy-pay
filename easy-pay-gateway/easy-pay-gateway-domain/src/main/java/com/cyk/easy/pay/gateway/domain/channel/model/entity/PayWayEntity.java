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
 * 支付方式表
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_pay_way")
public class PayWayEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * DB主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 支付方式代码  例如： wxpay_jsapi
     */
    private String wayCode;

    /**
     * 支付方式名称
     */
    private String wayName;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;


}
