package com.cyk.easy.pay.gateway.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyk.easy.pay.gateway.domain.channel.model.entity.MchPayChannelConfigEntity;
import com.cyk.easy.pay.gateway.domain.channel.repository.IMchPayChannelConfigRepository;
import com.cyk.easy.pay.gateway.infrastructure.mapper.MchPayChannelConfigMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商户支付通道表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-22
 */
@Service
public class MchPayChannelConfigRepository extends ServiceImpl<MchPayChannelConfigMapper, MchPayChannelConfigEntity> implements IMchPayChannelConfigRepository {

}
