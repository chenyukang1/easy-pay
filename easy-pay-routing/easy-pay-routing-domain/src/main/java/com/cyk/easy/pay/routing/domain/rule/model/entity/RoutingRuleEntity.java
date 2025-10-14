package com.cyk.easy.pay.routing.domain.rule.model.entity;

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
 * 路由规则表
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_routing_rule")
public class RoutingRuleEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 规则ID
     */
    @TableId(value = "rule_id", type = IdType.AUTO)
    private Long ruleId;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 商户ID
     */
    private String merchantId;

    /**
     * DRL 文件内容
     */
    private String drlContent;

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
