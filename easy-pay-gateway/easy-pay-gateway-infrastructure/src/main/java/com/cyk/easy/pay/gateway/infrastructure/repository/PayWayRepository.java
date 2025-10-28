package com.cyk.easy.pay.gateway.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyk.easy.pay.gateway.domain.channel.model.entity.PayWayEntity;
import com.cyk.easy.pay.gateway.domain.channel.repository.IPayWayRepository;
import com.cyk.easy.pay.gateway.infrastructure.mapper.PayWayMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付方式表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-22
 */
@Service
public class PayWayRepository extends ServiceImpl<PayWayMapper, PayWayEntity> implements IPayWayRepository {

}
