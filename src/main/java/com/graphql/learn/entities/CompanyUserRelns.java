package com.graphql.learn.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

/**
 * 
 * Database entity object for CompanyUserRelns
 * 
 * Name of database table is sysadm_company_user_relns
 * 
 * @author Shubham.Solanki
 * @since 2020-01-13
 *
 */

@Entity
@Table(name = "sysadm_company_user_relns")
@JsonInclude(Include.NON_EMPTY) 
public class CompanyUserRelns extends BaseEntity {
    
    @Id
    @SequenceGenerator(name = "company_user_relns_seq", sequenceName = "sysadm_company_user_relns_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "company_user_relns_seq", strategy = GenerationType.SEQUENCE)
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "id") 
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "user_id") 
    private User user;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @ManyToOne
    @JoinColumn(name = "company_id") 
    private Company company;
    
//    @ManyToOne
//    @JoinColumn(name = "location_id") 
//    private Location location;
    
    @Column(name = "role_id")
    private Integer roleId;
    
    @Override
    public String toString() {
        return "CompanyUserRelns [id=" + id + ", user="
                + user + ", company=" + company + "]";
    }

    

}
