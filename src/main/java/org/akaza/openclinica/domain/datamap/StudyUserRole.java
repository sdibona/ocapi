package org.akaza.openclinica.domain.datamap;
// Generated Jul 31, 2013 2:03:33 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * StudyUserRole generated by hbm2java
 */
@Entity
@Table(name = "study_user_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class StudyUserRole implements CompositeIdDomainObject {

    private StudyUserRoleId id;

    public StudyUserRole() {
    }

    public StudyUserRole(StudyUserRoleId id) {
        this.id = id;
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "roleName", column = @Column(name = "role_name", length = 40)),
            @AttributeOverride(name = "studyId", column = @Column(name = "study_id")),
            @AttributeOverride(name = "statusId", column = @Column(name = "status_id")),
            @AttributeOverride(name = "ownerId", column = @Column(name = "owner_id")),
            @AttributeOverride(name = "dateCreated", column = @Column(name = "date_created", length = 4)),
            @AttributeOverride(name = "dateUpdated", column = @Column(name = "date_updated", length = 4)),
            @AttributeOverride(name = "updateId", column = @Column(name = "update_id")),
            @AttributeOverride(name = "userName", column = @Column(name = "user_name", length = 40)) })
    public StudyUserRoleId getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (StudyUserRoleId) id;
    }


}