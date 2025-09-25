package com.cyk.easy.pay.infrastructure.repository;

import com.cyk.easy.pay.domain.channel.repository.IPayWayRepository;
import com.cyk.easy.pay.infrastructure.entity.PayWay;
import com.cyk.easy.pay.infrastructure.mapper.PayWayMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 支付方式表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-09-24
 */
@Repository
public class PayWayRepository extends ServiceImpl<PayWayMapper, PayWay> implements IPayWayRepository {

}
