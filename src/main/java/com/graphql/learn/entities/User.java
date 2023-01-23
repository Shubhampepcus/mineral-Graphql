package com.graphql.learn.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotBlank;
//import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
//import com.thinkhr.external.api.v2.model.PersonalizationInfo;
//import com.thinkhr.external.api.v2.model.WelcomeInsightStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Database entity object for User
 * 
 * Name of database table is sysadm_users
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="sysadm_users")
//@DynamicUpdate
//@DynamicInsert
@JsonInclude(Include.NON_EMPTY)
//@TypeDef(name = "welcomeInsightStatus", typeClass = DatabaseEnumTypeConverter.class)
public class User extends BaseEntity implements SearchableEntity {
    
    /**
     * 
     * @param userId
     * @param firstName
     * @param userName
     * @param email
     */
    public User(Integer userId, String firstName, String userName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.userName = userName;
        this.email = email;
    }

    /**
     *
     * @param userId
     * @param firstName
     * @param userName
     * @param email
     */
    public User(Integer userId, String firstName, String lastName, String userName, String email, Integer partnerId,  String partnerName, Integer companyId, String companyName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.companyId = companyId;
        this.companyName = companyName;
//        this.partnerId = partnerId;
//        this.partnerName = partnerName;
    }
    
    /**
     * 
     * @param userId
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param companyId
     * @param partnerId
     */
    public User(Integer userId, String firstName, String lastName, String email, String phone, Integer companyId,
            Integer partnerId) {
        super();
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.companyId = companyId;
//        this.partnerId = partnerId;
    }

    /**
     *
     * @param companyDisplayName
     * @param partnerDisplayName
     */
    public User(String companyDisplayName, String partnerDisplayName, String source) {
        super();
//        this.companyDisplayName = companyDisplayName;
//        this.partnerDisplayName = partnerDisplayName;
//        this.source = source;
    }

    /**
     * 
     * @param userId
     * @param firstName
     * @param lastName
     * @param fullName
     * @param userName
     * @param email
     * @param phone
     * @param companyId
     * @param companyName
     * @param partnerId
     * @param partnerName
     * @param roleId
     * @param role
     */
    public User(Integer userId, String firstName, String lastName, String fullName, String userName, String email,
            String phone, Integer companyId, String companyName, Integer partnerId, String partnerName, Integer roleId,
            String role, Long termsAcceptedAt, String roleDisplayName, String department, String jobTitle ) { //, WelcomeInsightStatus welcomeInsightStatus) {
        super();
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.companyId = companyId;
//        this.companyName = companyName;
//        this.partnerId = partnerId;
//        this.partnerName = partnerName;
//        this.roleId = roleId;
//        this.role = role;
        this.termsAcceptedAt = termsAcceptedAt;
//        this.roleDisplayName=roleDisplayName;
        this.department=department;
        this.jobTitle=jobTitle;
//        this.welcomeInsightStatus=welcomeInsightStatus;
    }

    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "sysadm_users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_seq", strategy = GenerationType.SEQUENCE)
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name="id")
    private Integer userId;

//    @NotBlank
//    @Size(max = 50)
    @Column(name="first_name", nullable=false)
    private String firstName;

//    @NotBlank
    @Column(name="last_name")
//    @Size(max = 50)
    private String lastName;
    
//    @Formula("(concat(trim(first_name), ' ',trim(last_name)))")
//    private String fullName;
    
//    @Size(max = 200)
    @Column(name = "username")
    private String userName;

//    @NotBlank
//    @Email
    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;
    
    @Column(name = "cell_phone")
    private String cellPhone;

    @Column(name = "direct_line_phone")
    private String directLinePhone;

//    @Formula("((case when (regexp_replace((COALESCE(nullif(COALESCE(nullif(phone , ''), cell_phone), ''), direct_line_phone)),'[^0-9]+','','g')) = '' then null else (regexp_replace((COALESCE(nullif(COALESCE(nullif(phone , ''), cell_phone), ''), direct_line_phone)),'[^0-9]+','','g')) end)::BIGINT)")
//    private String displayPhoneNumber;

    @JsonIgnore
    @Column(name="encrypted_password")
    private String password;

    @Column(name="salesforce_id")
    private String salesforceId;

    @Column(name="custom_field1")
    private String customField1;

    @Column(name="custom_field2")
    private String customField2;

    @Column(name="custom_field3")
    private String customField3;

    @Column(name="custom_field4")
    private String customField4;
    
//    @Size(max = 256)
    @Column(name = "department")
    private String department;
    
//    @Size(max = 256)
    @Column(name = "job_title")
    private String jobTitle;
    
    @Column(name = "terms_accepted_at")
    private Long termsAcceptedAt;

    @JsonProperty(access = Access.READ_ONLY)
    @Formula("(select cu.company_id from sysadm_company_user_relns cu where cu.user_id = id)")
    private Integer companyId;
    
//    @NotBlank
    @Formula("(select c.name from sysadm_companies c, sysadm_company_user_relns cu where c.id = cu.company_id and cu.user_id = id)")
    private String companyName;

    @Formula("(select c.display_name from sysadm_companies c, sysadm_company_user_relns cu where c.id = cu.company_id and cu.user_id = id)")
    private String companyDisplayName;

//    @JsonProperty(access = Access.READ_ONLY) 
//    @Formula("(select scpr.partner_id from sysadm_company_partner_relns scpr inner join sysadm_company_user_relns scur on scur.company_id = scpr.company_id where scur.user_id = id)")
//    private Integer partnerId;
    
//    @JsonProperty(access = Access.READ_ONLY)
//    @Formula("(select c.name from sysadm_companies c,sysadm_company_partner_relns cp,sysadm_company_user_relns cu where c.id = cp.partner_id and cp.company_id = cu.company_id and cu.user_id = id)")
//    private String partnerName;

//    @Formula("(select c.display_name from sysadm_companies c,sysadm_company_partner_relns cp,sysadm_company_user_relns cu where c.id = cp.partner_id and cp.company_id = cu.company_id and cu.user_id = id)")
//    private String partnerDisplayName;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    @JsonIgnore
    private List<CompanyUserRelns> companyUserRelns;
    
    @Transient
//    @JsonIgnore
    private Company company;
    
    @Formula("(select cu.role_id from sysadm_company_user_relns cu where cu.user_id = id)")
//    @JsonProperty("roleId")
    private Integer roleId;
    
//    @Formula("(select r.internal_name from sysadm_roles r, sysadm_company_user_relns cu where cu.user_id = id and r.id = cu.role_id)")
//    private String role;
   
    @Transient
    @JsonProperty(access = Access.WRITE_ONLY)
//    @Pattern(regexp = "0|1|false|true", message="must be either 0 or 1 or false or true")
    private String isDemoAccount;
    
    @JsonProperty(value = "isDemoAccount", access = Access.READ_ONLY)
    @Column(name = "is_demo_account")
    private boolean demoAccount;
    
    @Column(name = "is_primary")
    private Boolean isPrimary;
    
//    @Formula("(select c.source from sysadm_companies c, sysadm_company_user_relns scur where c.id = scur.company_id and scur.user_id = id)")
//    @JsonProperty(access = Access.READ_ONLY)
//    private String source;
    
    @Column(name = "reference_id")
    private String referenceId;

//    @Formula("(select case when exists (select odb.id from biographies odb where odb.active = true and odb.user_id = id) then true else false end)")
//    private Boolean isDedicatedHRPro;

    @Transient
    @JsonProperty(access = Access.WRITE_ONLY)
    private String companyCustomField;
    
//    @Transient
//    @JsonProperty(access = Access.READ_ONLY)
//    private List<PersonalizationInfo> personalizationInfo;
    
    @Transient
    private Boolean canEditUser;

    @Transient
    private Boolean isExternalUser;

//    @Formula("(select r.display_name from sysadm_roles r, sysadm_company_user_relns cu where cu.user_id = id and r.id = cu.role_id)")
//    private String roleDisplayName;
    
    @Column(name = "created_from")
    private String createdFrom;
    
//    @Formula("(select cu.location_id from sysadm_company_user_relns cu where cu.user_id = id)")
//    private Integer locationId;
    
    @Column(name = "hr_advisor_signature")
    private String hrAdvisorSignature;
    
//    @Formula("(select l.name from sysadm_locations l, sysadm_company_user_relns cu where cu.location_id=l.id and  cu.user_id = id)")
//    private String locationName;
    
    @Transient
    private Boolean courseCompletionEmails;
    
    @Transient
    private Boolean certificateGenerationEmails;
    
    @Transient
    private String roleType;
    
    
    @JsonProperty(access = Access.READ_ONLY)
//    @Formula("(SELECT EXISTS (select scur.user_id from sysadm_migrated_partners smp , sysadm_company_partner_relns scpr , sysadm_company_user_relns scur where smp.partner_id = scpr.partner_id and scpr.company_id =scur.company_id  and scur.user_id = id))")
//    private boolean isMigrated;
    
//    @Column(name = "welcome_insight_status")
//    @Type(type = "welcomeInsightStatus")
//    @Enumerated(EnumType.STRING)
//    private WelcomeInsightStatus welcomeInsightStatus;

    @Column(name = "last_signin_at")
    private Integer lastSignInAt;

    @PostLoad
    public void postLoad() {
        if (!CollectionUtils.isEmpty(this.companyUserRelns)) {
            this.companyUserRelns.forEach(uclr -> {
                if (uclr.getUser() != null && this.userId.equals(uclr.getUser().getUserId())) {
                    this.setCompany(uclr.getCompany());
                }
            });
        }
    }

    @Override
    @JsonIgnore
    public List<String> getSearchFields() {
        List<String> searchColumns = new ArrayList<String>();
        searchColumns.add("userId");
        searchColumns.add("userName");
        searchColumns.add("jobTitle");
        searchColumns.add("phone");
        searchColumns.add("fullName");
        searchColumns.add("email");
        searchColumns.add("cellPhone");
        searchColumns.add("directLinePhone");
        searchColumns.add("referenceId");
        return searchColumns;
    }

    /**
     * Get additional search fields column.
     */
    @Override
    @JsonIgnore
    public List<String> getAdditionalSearchFields() {
        List<String> additionalSearchColumns = new ArrayList<String>();
        additionalSearchColumns.add("companyName");
        return additionalSearchColumns;
    }

    @Override
    @JsonIgnore
    public String getNodeName() {
        return "user";
    }

    @Override
    @JsonIgnore
    public String getMultiDataNodeName() {
        return "users";
    }
    
    @Override
    @JsonIgnore
    public void clearDefaultValues() {
        
    }
    
    @Override
    public String defaultSort() {
        return "-userId";
    }
    
    @Override
    public String toString() {
        return "User [userId = " + userId + ",fullName = ,email = " + email + ",companyName = "
                    ;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Company getCompany() {
        return company;
    }
//
    public void setCompany(Company company) {
        this.company = company;
    }
}
