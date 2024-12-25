package com.kubemachine.engine.api.audit.model;


import com.kubemachine.engine.api.generic.model.base.BasicBaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.Version;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BasicAuditMetadata extends BasicBaseEntity {

    @CreatedBy
    @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID createdByUser;

    @LastModifiedBy
    @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID modifiedByUser;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdDate;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    private Date lastModifiedDate;

    @Version
    private Long version;
}
