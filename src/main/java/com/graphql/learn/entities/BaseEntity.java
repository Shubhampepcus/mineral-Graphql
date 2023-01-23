package com.graphql.learn.entities;

import static com.graphql.learn.utils.CommonUtil.getNowInMiliseconds;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

/**
 * Entity to handle all the attributes those are common for all entities
 * 
 * @author Shubham.Solanki
 * @since 2020-01-21
 *
 */

@Data
@MappedSuperclass
@JsonInclude(Include.NON_EMPTY)
public class BaseEntity {
    
    @Column(name = "is_active")
    @JsonProperty(access = Access.READ_ONLY)
    private Boolean isActive = true;
    
    @Column(name = "created_by")
    private Integer createdBy;
    
    @Column(name = "created_on")
    private Long createdOn = getNowInMiliseconds();
    
    @Column(name = "modified_by")
    private Integer modifiedBy;
    
    @Column(name = "modified_on")
    private Long modifiedOn;

}
