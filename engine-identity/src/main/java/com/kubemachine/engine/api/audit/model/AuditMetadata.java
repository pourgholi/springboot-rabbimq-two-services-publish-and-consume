package com.kubemachine.engine.api.audit.model;


import com.kubemachine.engine.api.generic.model.base.BaseEntity;
import com.kubemachine.engine.api.project.model.Project;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class AuditMetadata extends BaseEntity {

    @CreatedBy
    private UUID createdByUser;

    @LastModifiedBy
    private UUID modifiedByUser;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdDate;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    private Date lastModifiedDate;

    @Version
    private Long version;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @NotNull
    private Project project;
}
