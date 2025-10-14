package com.cyk.easy.pay.routing.infrastructure.repository;

import com.cyk.easy.pay.routing.domain.rule.model.entity.RoutingRecordEntity;
import com.cyk.easy.pay.routing.infrastructure.mapper.RoutingRecordMapper;
import com.cyk.easy.pay.routing.infrastructure.delete_delete.IRoutingRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 路由记录表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-09-28
 */
@Repository
public class RoutingRecordRepository extends ServiceImpl<RoutingRecordMapper, RoutingRecordEntity> implements IRoutingRecordRepository {

}
