package com.kubemachine.engine.api.generic.tenantfilter.aop.aspect.specification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public class ProjectSpecification {

    public static <T> Specification<T> fromProjectId(String projectId) {
        log.info("ProjectId: " + projectId);
        return (e, cq, cb) -> cb.like(cb.upper(e.get("project").get("id").as(String.class)), projectId.toUpperCase());
    }

//    public static <T> Specification<T> fromProjectIdAndId(String projectId, Object id) {
//        log.info("ProjectId: " + projectId);
//        return (e, cq, cb) -> cb.and(cb.like(cb.upper(e.get("project").get("id").as(String.class)), projectId.toUpperCase()), cb.equal(e.get("id"), id));
//    }
//
//    public static <T> Specification<T> fromProjectIdAndIsPublicDeliveryConfigurationSetup(String projectId, Object id) {
//        log.info("ProjectId: " + projectId);
//        return (r, cq, cb) ->
//                cb.or(
//                        cb.and(
//                                cb.like(cb.upper(r.get("project").get("id").as(String.class)), projectId.toUpperCase()),
//                                cb.equal(r.get("id"), id)
//                        ),
//                        cb.and(
//                                cb.equal(r.get("isPublicCatalogEntry"), true),
//                                cb.equal(r.get("id"), id)
//                        )
//                );
//    }
}
