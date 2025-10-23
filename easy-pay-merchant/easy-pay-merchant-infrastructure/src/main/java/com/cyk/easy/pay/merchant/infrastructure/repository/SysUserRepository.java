package com.cyk.easy.pay.merchant.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyk.easy.pay.merchant.domain.merch.model.entity.SysUserEntity;
import com.cyk.easy.pay.merchant.domain.merch.repository.ISysUserRepository;
import com.cyk.easy.pay.merchant.infrastructure.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-20
 */
@Service
public class SysUserRepository extends ServiceImpl<SysUserMapper, SysUserEntity> implements ISysUserRepository {

}
