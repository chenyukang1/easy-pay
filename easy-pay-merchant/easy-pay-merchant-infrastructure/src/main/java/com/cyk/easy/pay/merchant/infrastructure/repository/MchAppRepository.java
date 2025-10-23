package com.cyk.easy.pay.merchant.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyk.easy.pay.merchant.domain.merch.model.entity.MchAppEntity;
import com.cyk.easy.pay.merchant.domain.merch.repository.IMchAppRepository;
import com.cyk.easy.pay.merchant.infrastructure.mapper.MchAppMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商户应用表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-20
 */
@Service
public class MchAppRepository extends ServiceImpl<MchAppMapper, MchAppEntity> implements IMchAppRepository {

}
