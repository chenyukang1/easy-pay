package com.cyk.easy.pay.merchant.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyk.easy.pay.merchant.domain.merch.model.entity.IsvInfoEntity;
import com.cyk.easy.pay.merchant.domain.merch.repository.IIsvInfoRepository;
import com.cyk.easy.pay.merchant.infrastructure.mapper.IsvInfoMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务商信息表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-20
 */
@Service
public class IsvInfoRepository extends ServiceImpl<IsvInfoMapper, IsvInfoEntity> implements IIsvInfoRepository {

}
