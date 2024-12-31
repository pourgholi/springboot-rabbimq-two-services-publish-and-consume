package com.kubemachine.engine.api.generic;

import com.kubemachine.engine.api.generic.multitenancy.filter.ActiveProjectFromProjectMembershipId;
import com.kubemachine.engine.api.generic.tenantfilter.aop.aspect.specification.ProjectSpecification;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

@Aspect
@Transactional
@Component
@RequiredArgsConstructor
public class FilterByActiveProjectIdAspect {

    private final ActiveProjectFromProjectMembershipId activeProjectFromProjectMembershipId;

    @Pointcut("execution(*  com.kubemachine.engine.api.identity.repository.*.findAll(org.springframework.data.domain.Pageable))")
    public void findAllWithPageableParam() {
    }


    @Around("findAllWithPageableParam()")
    public Object filterByProjectIdThroughProjectMembershipIdAndPageable(final ProceedingJoinPoint pjp) throws Throwable {
        Object target = pjp.getThis();
        Method method = target.getClass().getMethod("findAll", Specification.class, Pageable.class);
        return method.invoke(target, ProjectSpecification.fromProjectId(activeProjectFromProjectMembershipId.getActiveProjectFromActiveProjectMemberAttributeInToken().getId().toString()), pjp.getArgs()[0]);
    }
}
