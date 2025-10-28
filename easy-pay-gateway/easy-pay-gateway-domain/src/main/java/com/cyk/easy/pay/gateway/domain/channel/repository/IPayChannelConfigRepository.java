package com.cyk.easy.pay.gateway.domain.channel.repository;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cyk.easy.pay.gateway.domain.channel.model.entity.PayChannelConfigEntity;

/**
 * @author yukang.chen
 */
public interface IPayChannelConfigRepository extends IService<PayChannelConfigEntity> {

    PayChannelConfigEntity queryByConfigId(Long configId);

}
