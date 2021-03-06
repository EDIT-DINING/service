package com.editdining.service.repository;

import com.editdining.service.dto.ServiceDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.editdining.service.entity.QServiceMasterEntity.serviceMasterEntity;
import static com.editdining.service.entity.QServicePriceEntity.servicePriceEntity;
import static com.editdining.service.entity.QMemberEntity.memberEntity;


@Repository
@RequiredArgsConstructor
public class ServiceMasterRepositorySupport {
    private final JPAQueryFactory queryFactory;


    /*
    * 2-2. 서비스 리스트
    * -> join이 필요해 querydsl로
    * */
    public List<ServiceDto.Response> findByCategory(int category, Integer edit_type, int offset, int limit){
        return queryFactory
                .select(Projections.fields(ServiceDto.Response.class,
                        serviceMasterEntity.service_id,
                        serviceMasterEntity.edit_type,
                        serviceMasterEntity.thumbnail,
                        serviceMasterEntity.category,
                        serviceMasterEntity.title,
                        serviceMasterEntity.description,
                        servicePriceEntity.price,
                        memberEntity.name))
                .from(serviceMasterEntity)
                // 가격
                .join(servicePriceEntity)
                    .on(servicePriceEntity.price_id
                            .eq(JPAExpressions.select(servicePriceEntity.price_id.min())
                                                .from(servicePriceEntity)
                                                .where(serviceMasterEntity.service_id.eq(servicePriceEntity.service_id))))
                // 회원
                .join(memberEntity)
                    .on(memberEntity.member_id.eq(serviceMasterEntity.member_id))
                .groupBy()
                .where(serviceMasterEntity.category.eq(category), eqEditType(edit_type))
                .offset(offset)
                .limit(limit)
                .fetch();
    }

    // null 처리
    private BooleanExpression eqEditType(Integer edit_type) {
        if (edit_type == null) {
            return null;
        }
        return serviceMasterEntity.edit_type.eq(edit_type);
    }

}