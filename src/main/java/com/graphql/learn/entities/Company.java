package com.graphql.learn.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
//import javax.validation.Valid;
//import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Value;
//import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * Database entity object for Company
 * 
 * Name of database table is sysadm_companies
 * 
 * @author Shubham.Solanki
 * @since 2020-01-15
 *
 */

@Entity
@Table(name = "sysadm_companies")
@Data
//@DynamicUpdate
//@DynamicInsert
@JsonInclude(Include.NON_EMPTY)
@EqualsAndHashCode(exclude={ "companyConfigurationRelns" })
@NoArgsConstructor
public class Company extends BaseEntity implements SearchableEntity {

    @Id
    @SequenceGenerator(name = "comapnies_seq", sequenceName = "sysadm_companies_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "comapnies_seq", strategy = GenerationType.SEQUENCE)
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "id") 
    private Integer companyId;

//    @NotBlank
    @Column(name = "name") 
    private String companyName;

//    @NotBlank
    @Column(name = "display_name") 
    private String displayName;

    @Column(name = "industry") 
    private String industry;

    @Column(name = "custom_field1") 
    private String custom1;

    @Column(name = "custom_field2") 
    private String custom2;

    @Column(name = "custom_field3") 
    private String custom3;

    @Column(name = "custom_field4") 
    private String custom4;
    
    @Column(name = "custom_field5")
    private String custom5;

    @Column(name = "salesforce_id") 
    private String salesforceId;
    
    @Column(name = "website_url") 
    private String websiteUrl;

    @Column(name = "partner_gtm_model")
    private String gtmModel;

//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "company_type_id")
//    private CompanyType type;

    @Column(name = "last_reminded_to_update")
    private Long lastRemindedToUpdate;

    @Transient
    @JsonProperty(access = Access.READ_ONLY) 
    private Integer updateReminderStatus;
    
    @Transient
    private String companyType; 

    @JsonProperty(access = Access.READ_ONLY)
    @Column(name="company_type_id", insertable=false, updatable=false)
    private Integer companyTypeId;

//    @OneToMany(mappedBy="company", fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval=true)
//    @JsonIgnore
//    private List<CompanyPartnerRelns> companyPartnerRelns;

//    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval=true)
//    @JsonIgnore
//    private List<CompanyConfigurationRelns> companyConfigurationRelns;

//    @JsonIgnore
//    @OneToMany(mappedBy = "company",cascade=CascadeType.PERSIST, fetch=FetchType.LAZY, orphanRemoval=true)
//    private List<Location> locations;

//    @Transient
//    @Valid
//    private Location location;

//    @Formula("(select distinct cp.partner_id from sysadm_company_partner_relns cp where cp.company_id = id)")
//    private Integer partnerId;

//    @JsonProperty(access=Access.READ_ONLY)
//    @Formula("(select p.name from sysadm_company_partner_relns cp, sysadm_companies p where cp.company_id = id and p.id = cp.partner_id)")
//    private String partnerName;

//    @JsonProperty(access=Access.READ_ONLY)
//    @Formula("(select sc.partner_gtm_model from sysadm_company_partner_relns scpr, sysadm_companies sc where sc.id = scpr.partner_id and scpr.company_id = id)")
    //@Transient
//    private String partnerGtmModel;

    @Column(name = "source")
    private String source;

    @Column(name = "is_disclaimer_acknowledged") 
    private Integer isDisclaimerAcknowledged;
    
//    @Formula("(select sccr.configuration_id from sysadm_configurations sc, sysadm_company_configuration_relns sccr where sc.id = sccr.configuration_id and sccr.company_id = id and sc.type in ('alternate','master'))")
//    private Integer configurationId;
    
//    @Formula("(select sccr.configuration_id from sysadm_configurations sc, sysadm_company_configuration_relns sccr where sc.id = sccr.configuration_id and sccr.company_id = id and sc.type in ('add-on'))")
//    private Integer addonConfigurationId;

//    @Formula("(select sc.name from sysadm_configurations sc, sysadm_company_configuration_relns sccr where sc.id = sccr.configuration_id and sccr.company_id = id and sc.type in ('alternate','master'))")
//    private String configurationName;
    
//    @Formula("(select sc.name from sysadm_configurations sc, sysadm_company_configuration_relns sccr where sc.id = sccr.configuration_id and sccr.company_id = id and sc.type in ('add-on'))")
//    private String addonConfigurationName;

//    @Transient
//    @JsonProperty(access = Access.WRITE_ONLY)
//    @Pattern(regexp = "0|1|false|true", message="must be either 0 or 1 or false or true")
//    private String isDemoAccount;
    
    @JsonProperty(value = "isDemoAccount", access = Access.READ_ONLY)
    @Column(name = "is_demo_account")
    private boolean demoAccount;

    @Transient
    @JsonProperty(access = Access.READ_ONLY)
    private String companySize;
    
//    @Transient
//    private Set<Sku> skus;
    
//    @Transient
//    @Pattern(regexp = "^[a-z0-9]+", message = "Please enter a valid sub-domain")
//    private String domain;
    
    @Column(name = "hr_pro_id")
    private Integer hrProId;
    
//    @Transient
//    @JsonProperty(access = Access.READ_ONLY)
//    @OneToMany(mappedBy = "partnerId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<CustomFields> customFields;
    
//    @JsonProperty(access = Access.READ_ONLY)
//    @Formula("(select concat(u.first_name, ' ',u.last_name) from sysadm_users u where u.id = hr_pro_id)")
//    private String hrProName;
    
//    @Formula("(select u.username from sysadm_users u where u.id = hr_pro_id)")
//    private String hrProUsername;

    @Column(name = "can_create_bcs_elite_documents")
    private Boolean canCreateBcsEliteDocuments;
    
    @Column(name = "account_manager_id") 
    private Integer accountManagerId;
    
    @Transient
    private String accountManager;
    
//    @JsonProperty(access=Access.READ_ONLY)
//    @Formula("(select concat(u.first_name, ' ',u.last_name) from sysadm_users u where u.id = account_manager_id)")
//    private String accountManagerName;
    
    @Column(name = "success_manager_id") 
    private Integer successManagerId;
    
    @Transient
    private String customerSuccessManager;

    @Transient
    private Boolean verifiedAPI;

//    @JsonProperty(access=Access.READ_ONLY)
//    @Formula("(select concat(u.first_name, ' ',u.last_name) from sysadm_users u where u.id = success_manager_id)")
//    private String customerSuccessManagerName;
    
    @Transient
    @JsonProperty(access = Access.READ_ONLY)
    private Integer primaryPartnerAdmin;

    @Transient
    @JsonProperty(access = Access.READ_ONLY)
    private Integer primaryCompanyAdmin;

//    @Column(name = "affiliate_id")
//    @ColumnTransformer(read="(select p.affiliate_id from sysadm_companies c left join sysadm_company_partner_relns rel on c.id = rel.company_id left join sysadm_companies p  on rel.partner_id = p.id where c.id = id)", write="?")
//    private String affiliateId;

//    @JsonProperty(access=Access.READ_ONLY)
//    @Formula("(select a.name from sysadm_company_partner_relns cp, sysadm_companies c, sysadm_affiliates a where c.id = cp.partner_id and cp.company_id = id and c.affiliate_id = a.id)")
//    private String affiliateName;
    
    @Column(name = "created_from")
    private String createdFrom;
    
    
//    @JsonProperty(access=Access.READ_ONLY)
//    @Formula("(SELECT EXISTS (select b.id from sysadm_partner_brandings b,sysadm_company_partner_relns r where b.partner_id = r.partner_id and r.company_id = id))")
//    private boolean hasBranding;
    
    
    @JsonProperty(access = Access.READ_ONLY)
//    @Formula("(SELECT EXISTS (select smp.partner_id from sysadm_migrated_partners smp, sysadm_company_partner_relns scpr where scpr.partner_id = smp.partner_id and smp.is_active=true and scpr.company_id = id))")
//    private boolean isMigrated;
    
//    @JsonProperty(access = Access.READ_ONLY)
//    @Formula("(SELECT EXISTS (select spb.partner_id from sysadm_partner_brandings spb where spb.partner_id = id))")
//    private boolean hasCustomBranding = true;
    
    
//    @JsonProperty(access = Access.READ_ONLY)
//    @Formula("(SELECT EXISTS (select scur.company_id from sysadm_company_user_relns scur, sysadm_users su where scur.user_id =su.id and su.welcome_insight_status in('DELIVERED','VIEWED') and scur.company_id =id))")
//    private boolean isWelcomeInsightDelivered;

    @Column(name = "producer")
    private String producer;

    @Column(name = "reference_id")
    private String referenceId;

    /**
     * Determines whether this company is partner company
     * 
     * @return
     */
    @JsonIgnore
    public boolean isPartnerCompany() {
        return companyTypeId.equals(1) || companyTypeId.equals(3);
    }

//    @PostLoad
//    public void postLoad() {
//        if (null != type) {
//            this.companyType = type.getName(); 
//        }
//        if (!CollectionUtils.isEmpty(this.locations)) {
//            this.companySize = String.valueOf(this.locations.stream().filter(l -> l.getEmployeeCount() != null)
//                    .mapToInt(Location::getEmployeeCount).sum());
//        }
//    }

    /**
     * Returns fields where "SearchSpec" searching acts on.
     * 
     */
    @Override
    @JsonIgnore
    public List<String> getSearchFields() {
        List<String> searchColumns = new ArrayList<String>();
        searchColumns.add("companyName");
        searchColumns.add("displayName");
        return searchColumns;
    }

    @Override
    @JsonIgnore
    public String getNodeName() {
        return "company";
    }

    @Override
    @JsonIgnore
    public String getMultiDataNodeName() {
        return "companies";
    }

    @Override
    @JsonIgnore
    public void clearDefaultValues() {
        
    }
    
    public Company(Integer companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public Company(Integer companyId, String companyName, String source) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.source = source;
    }

    public Company(Integer companyId, String companyName, Integer companyTypeId) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyTypeId = companyTypeId;
    }

    public Company(Integer companyId, String companyName, Integer companyTypeId,Integer partnerId) {
        super();
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyTypeId = companyTypeId;
//        this.partnerId = partnerId;
    }
    
    public Company(Integer companyId, String companyName, Integer companyTypeId, Integer partnerId, String partnerName,
            boolean demoAccount,Integer configurationId,Integer addonConfigurationId) {
        super();
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyTypeId = companyTypeId;
//        this.partnerId = partnerId;
//        this.partnerName = partnerName;
        this.demoAccount = demoAccount;
//        this.configurationId = configurationId;
//        this.addonConfigurationId = addonConfigurationId;
    }
    
    /**
     * Constructor for carrying accountManagerId and successManagerId.
     * 
     * @param accountManagerId
     * @param successManagerId
     */
    public Company(Integer accountManagerId, Integer successManagerId) {
        super();
        this.accountManagerId = accountManagerId;
        this.successManagerId = successManagerId;
    }
    
    public Company(Integer companyId, Integer configurationId, Integer addonConfigurationId) {
        this.companyId = companyId;
//        this.configurationId = configurationId;
//        this.addonConfigurationId = addonConfigurationId;
    }
    
    /**
     * Constructor for carrying companyId and partnerId.
     * 
     * @param partnerId
     */
    public Company(Integer partnerId) {
        super();
//        this.partnerId = partnerId;
    }

    @Override
    public String toString() {
        return "Company [companyId = " + companyId + ",companyName = " + companyName + ",demoAccount = " + demoAccount
                + ",configurationId = ,companyType = " + companyType + "]";
    }

    //public String getPartnerGtmModel() {
    //    Company partner = this.companyPartnerRelns != null ? this.companyPartnerRelns.stream().findFirst().orElse(new CompanyPartnerRelns()).getPartner() : null;
    //    return partner != null ? partner.getGtmModel() : null;
    //}
}
