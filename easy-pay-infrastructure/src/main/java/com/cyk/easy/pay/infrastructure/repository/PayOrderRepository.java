package com.cyk.easy.pay.infrastructure.repository;

import com.cyk.easy.pay.domain.channel.repository.IPayOrderRepository;
import com.cyk.easy.pay.infrastructure.entity.PayOrder;
import com.cyk.easy.pay.infrastructure.mapper.PayOrderMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 支付订单表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-09-24
 */
@Repository
public class PayOrderRepository extends ServiceImpl<PayOrderMapper, PayOrder> implements IPayOrderRepository {

}
