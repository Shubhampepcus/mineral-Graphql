package com.graphql.learn.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.graphql.learn.entities.Company;



/**
 * Company repository for company entity.
 *  
 * @author Shubham.Solanki
 * @since 2020-01-15
 *
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    
    public List<Company> findAll();
    
    public Company findByCompanyId(Integer companyId);
    

    
//    public final String isActiveCompany = "isActive=true";
//    
//    public final String findCompanyIdsBySkuName = "select compConf.company.companyId from CompanyConfigurationRelns compConf,ConfigurationSkuRelns confSku where confSku.configuration.id = compConf.configuration.configurationId and confSku.sku.name ";
//    
//    public final String findCompanyIdsBySkuKey = "select compConf.company.companyId from CompanyConfigurationRelns compConf,ConfigurationSkuRelns confSku where confSku.configuration.id = compConf.configuration.configurationId and compConf.company.type=2 and confSku.sku.key ";
//    
//    public final String requiredFieldInCompany = "sc.industry is null or sl.primary_phone is null or sl.zip is null or sl.city is null or sl.county is null or sl.state is null or sl.employee_count is null or sl.employee_count=0 or sl.name is null";
//    
//    public final String findPartnerIdsBySkuKey = "select compConf.company.companyId from CompanyConfigurationRelns compConf,ConfigurationSkuRelns confSku where confSku.configuration.id = compConf.configuration.configurationId and compConf.company.type=1 and confSku.sku.key ";
//    /**
//     * 
//     * @param companyId
//     * @return
//     */
//    @Query("from Company where companyId =:companyId and " + isActiveCompany)
//    public Company findActiveOne(@Param("companyId") Integer companyId);
//    
//    /**
//     * Repository method
//     * 
//     * @param companyName
//     * @param customField1
//     * @param partnerId
//     * @param isActive
//     * @return
//     */
//    public Company findFirstByCompanyNameAndCustom1AndPartnerIdAndIsActive(
//            String companyName, String customField1, Integer partnerId, boolean isActive);
//    
//    /**
//     * Repository method
//     * 
//     * @param companyName
//     * @param partnerId
//     * @return
//     */
//    public Company findFirstByCompanyNameAndPartnerId(String companyName, Integer partnerId);
//
//    /**
//     * Find broker in DB irrespective of whether it is active or inactive
//     * 
//     * @param companyId
//     * @param brokerStatusToUpdate 
//     * @return
//     */
////    @Query(value="select c from Company c where c.companyId = :companyId and c.isActive = :status")
////    public Company findOneWithStatus(@Param("companyId")Integer companyId, @Param("status")Boolean status);
//
//    /**
//     *  Update lastRemindedToUpdate
//     * @param companyId
//     * @param lastRemindedToUpdate
//     */
////    @Query("update Company c set c.lastRemindedToUpdate=:lastRemindedToUpdate where c.companyId=:companyId")
////    @Modifying
////    @Transactional
////    public void saveLastRemindedToUpdate(@Param("companyId") Integer companyId, @Param("lastRemindedToUpdate") Long lastRemindedToUpdate);
//    
////    @Transactional
////    @Modifying
////    @Query(value="update sysadm_companies c set \"source\" = ?2 from sysadm_company_partner_relns cp where c.id = cp.company_id and cp.partner_id = ?1", nativeQuery=true)
////    public void updateSourceByPartnerId(Integer partnerId, String value);
//    
//    /**
//     * Repository method
//     * 
//     * @param companyName
//     * @param companyType
//     * @param isThroneCompany
//     * @param isActive
//     * @return
//     */
//    public Company findFirstByCompanyNameAndCompanyTypeIdAndIsActive(
//            String companyName, Integer companyTypeId, boolean isActive);
//    
//    /**
//     * Find a potential duplicate i.e. inactive name in DB for a broker company name that is being created or updated
//     * 
//     * @param companyType
//     * @param concat
//     * @return
//     */
//    public Company findFirstByCompanyTypeIdAndCompanyNameStartingWith(Integer companyTypeId, String concat);
//
//    /**
//     * Find a duplicate or a potential duplicate i.e. active or inactive name in DB for a company name that is being created or updated 
//     * 
//     * @param brokerId
//     * @param companyName
//     * @return
//     */
////    public List<Company> findByPartnerIdAndCompanyNameStartingWith(
////            Integer brokerId, String companyName);
//
//    /**
//     * Find a duplicate or a potential duplicate i.e. active or inactive name in DB for a company name that is being created or updated for paychex broker
//     * 
//     * @param custom1
//     * @param brokerId
//     * @param companyName
//     * @return
//     */
//    public List<Company> findByCustom1AndPartnerIdAndCompanyNameStartingWith(
//            String custom1, Integer brokerId, String companyName);
//
//    /**
//     * Find a active company for special partner such as paychex and Oasis in db for import users
//     *
//     * @param custom1
//     * @param brokerId
//     * @param companyName
//     * @return
//     */
//    public Company findFirstByCustom1AndPartnerIdAndIsActiveTrueAndCompanyNameStartingWith(
//            String custom1, Integer brokerId, String companyName);
//
//    /**
//     * @param companyId
//     * @return
//     */
////    @Query("select companyName from Company where companyId =?1")
////    public String findCompanyNameByCompanyId(Integer companyId);
//
//    /**
//     * @param companyId
//     * @return
//     */
//    @Query("select displayName from Company where companyId =?1")
//    public String findDisplayNameByCompanyId(Integer companyId);
//
//    /**
//     * 
//     * @param partnerId
//     * @return
//     */
//    @Query("select c.companyId from Company c where c.partnerId=:partnerId and c.partnerId != c.companyId and c.isActive = true")
//    public List<Integer> findCompaniesByPartnerId(@Param("partnerId")Integer partnerId);
//    
//    /**
//     * 
//     * @param companyName
//     * @param partnerId
//     * @param isActive
//     * @return
//     */
//    @Query("select c from Company c where c.partnerId= :partnerId and upper(trim(c.companyName)) = upper(:companyName) and c.isActive = true")
//    public Company findFirstByCompanyNameAndPartnerIdAndIsActiveTrueIgnoreCase(@Param("companyName")String companyName, @Param("partnerId")Integer partnerId);
//
//    /**
//     * Update isDemoAccount column in the clients table
//     * 
//     * @param partnerId
//     * @param isDemoAccount
//     */
//    @Query(value = "update sysadm_companies sc set is_demo_account = ?2 from sysadm_company_partner_relns scpr where sc.id=scpr.company_id and scpr.partner_id = ?1 ", nativeQuery = true)
//    @Modifying
//    @Transactional
//    public void updateDemoAccountFlag(@Param("companyId") Integer companyId, @Param("demoAccount") boolean demoAccount);
//
//    /**
//     * Count all companies by partnerId
//     * 
//     * @param partnerId
//     * @return
//     */
//    @Query("select count(c.companyId) from Company c where c.partnerId=:partnerId and c.partnerId != c.companyId and c.isActive = :isActive")
//    public Integer countByPartnerIdAndIsActive(@Param("partnerId")Integer partnerId, @Param("isActive")Boolean isActive);
//    
//    @Query("select partnerId from Company where companyId=:id")
//    public Integer findPartnerId(@Param("id") Integer id);
//    
//    /**
//     * Repository method
//     * 
//     * @param companyId
//     * @param partnerId
//     * @return
//     */
//    @Query("select cp.company from CompanyPartnerRelns cp where cp.company.companyId= ?1 and cp.partner.companyId= ?2" )
//    public Company findByCompanyIdAndPartnerId(Integer companyId, Integer partnerId);
//    
//    /**
//     * 
//     * @param partnerId
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,c.companyName,c.companyTypeId,c.partnerId,c.partnerName,c.demoAccount,c.configurationId,c.addonConfigurationId) from Company c where c.partnerId=:partnerId and c.partnerId != c.companyId and c.isActive = true")
//    public List<Company> findAllCompaniesByPartnerId(@Param("partnerId")Integer partnerId);
//    
//    /**
//     * @param companyIds
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,c.companyName,c.companyTypeId,c.partnerId,c.partnerName,c.demoAccount,c.configurationId,c.addonConfigurationId) from Company c where c.partnerId=:partnerId and c.partnerId != c.companyId and c.isActive = true and c.companyId in (:companyIds)")
//    public List<Company> findByCompanyIdInAndPartnerId(@Param("companyIds") List<Integer> companyIds,@Param("partnerId")Integer partnerId);
//
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,trim(c.companyName)) from Company c where c.partnerId=:partnerId and c.partnerId != c.companyId and trim(c.companyName) in (:companyNames)")
//    public List<Company> findByCompanyNameIn(@Param("partnerId") Integer partnerId, @Param("companyNames") List<String> companyNames);
//
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId, c.companyName, c.source) from Company c where c.companyId in (:companyIds)")
//    public List<Company> findByCompanyIdIn(@Param("companyIds")List<Integer> companyIds);
//
//    /**
//     * @param companyNames
//     * @return
//     */
//    @Query("select c.companyId from Company c where companyTypeId !=1 and c.companyName in(:companyNames)")
//    public List<Integer> findCompanyIdByCompanyNameIn(@Param("companyNames") List<String> companyNames);
//    
//    /**
//     * @param companyIds
//     * @return
//     */
//    @Query("select c.companyId from Company c where companyTypeId !=1 and c.companyId in(:companyIds)")
//    public List<Integer> findReCompanyIdByCompanyIdIn(@Param("companyIds") List<Integer> companyIds);
//    
//    /**
//     * 
//     * @param companyIds
//     * @return
//     */
//    @Query("select c.companyId from Company c where c.companyName in (:companyNames) and c.isActive = true")
//    public List<Integer> findCompanyIdsByCompanyNameIn(@Param("companyNames") List<String> companyNames);
//    
//    /**
//     * 
//     * @param companyName
//     * @return
//     */
//    public Company findFirstByCompanyNameAndIsActive(String companyName, boolean isActive);
//    
//    /**
//     * Method use to get companyIds based on sku name
//     * @param skuName
//     * @return
//     */
//    @Query(value = findCompanyIdsBySkuName + " in(:skuNames)")
//    public Set<Integer> findCompanyIdsBySkuNameIn(@Param("skuNames") List<String> skuNames);
//    
//    /**
//     * Method use to get companyIds which not based on given sku name
//     * @param skuName
//     * @return
//     */
//    @Query(value = findCompanyIdsBySkuName + " not in(:skuNames)")
//    public Set<Integer> findCompanyIdsBySkuNameNotIn(@Param("skuNames") List<String> skuNames);
//    
//    /**
//     * 
//     * @param companyIdList
//     */
//    @Transactional
//    @Modifying
//    @Query(value="delete from sysadm_companies where id in(:companyIds)", nativeQuery=true)
//    public void deleteByCompanyIdIn(@Param("companyIds")List<Integer> companyIds);
//    
//    /**
//     * Get All companies by the configuration id (alternate & master) and status
//     * 
//     * @param companyId
//     * @param isActive
//     * @return
//     */
//    public List<Company> findByConfigurationIdAndIsActive(Integer companyId,
//            boolean isActive);
//    
//    
//    /**
//     * Get All companies by the configuration id (add-on) and status
//     * 
//     * @param companyId
//     * @param isActive
//     * @return
//     */
//    public List<Company> findByAddonConfigurationIdAndIsActive(Integer configurationId,
//            boolean isActive);
//    
//    /**
//     * Find partners by affiliateId.
//     * 
//     * @param affiliateId
//     * @param companyTypeId
//     * @param status
//     * @return
//     */
//    public List<Company> findByAffiliateIdAndCompanyTypeIdAndIsActive(String affiliateId, Integer companyTypeId,
//            Boolean status);
//    
//    /**
//     * Find partners by affiliateId and modifiedOn.
//     * 
//     * @param affiliateId
//     * @param modifiedOn
//     * @param companyTypeId
//     * @param status
//     * @return
//     */
//    public List<Company> findByAffiliateIdAndModifiedOnGreaterThanEqualAndCompanyTypeIdAndIsActive(String affiliateId, long modifiedOn,
//            Integer companyTypeId, Boolean status);
//    
//    /**
//     * Find all company ids by Company Type and Active status.
//     * 
//     * @param companyTypeId
//     * @param isActive
//     * @return
//     */
//    @Query("select c.companyId from Company c where c.companyTypeId = :companyTypeId and c.isActive = :isActive")
//    public List<Integer> findCompanyIdsByCompanyTypeIdAndIsActive(@Param("companyTypeId") Integer companyTypeId, @Param("isActive") boolean isActive);
//
//    /**
//     * Find all companies which have any required field as empty or null
//     * Commented original query based on GN-8687
//     * @return
//     */
//    //@Query(value="select sc.id from sysadm_locations sl, sysadm_companies sc where sl.company_id=sc.id and sc.is_active=true and sl.is_primary=true and (" + requiredFieldInCompany+ ")", nativeQuery=true)
//    @Query(value="select scpr.company_id from sysadm_company_partner_relns scpr, sysadm_migrated_partners smp where scpr.company_id in (select sc.id from sysadm_locations sl, sysadm_companies sc where sl.company_id=sc.id and sc.is_active=true and sl.is_primary=true and (" + requiredFieldInCompany+ "))" +
//            " and scpr.partner_id = smp.partner_id and smp.is_active =true", nativeQuery=true)
//    public List<Integer> findEmptyRequiredFieldCompanies();
//    
//    /**
//     * Check if company have any required field empty
//     * 
//     * @param companyId
//     * @return
//     */
//    @Query(value="select sc.id from sysadm_locations sl, sysadm_companies sc where sl.company_id=sc.id and sc.is_active=true and sl.is_primary=true and (" + requiredFieldInCompany+ ") and sc.id =:companyId", nativeQuery=true)
//    public Integer findEmptyAtributeInCompanyData(@Param("companyId") Integer companyId);
//    
//    /**
//     * Find partnerId by the given userId
//     * 
//     * @param userId
//     * @return
//     */
//    @Query(value = "select scpr.partner_id from sysadm_company_partner_relns scpr inner join sysadm_company_user_relns scur on scur.company_id = scpr.company_id where scur.user_id  =:userId", nativeQuery = true)
//    public Integer findPartnerIdByUserId(@Param("userId") Integer userId);
//    
//    @Query("select c.companyId from Company c where c.partnerId=:partnerId and c.partnerId != c.companyId")
//    public List<Integer> findAllCompanyIdByPartnerId(@Param("partnerId")Integer partnerId);
//
//    /**
//     * Method use to get companyIds based on sku name
//     * @param skuName
//     * @return
//     */
//    @Query(value = "select scsr.configuration_id from sysadm_skus ss, " +
//            "sysadm_configuration_sku_relns scsr where scsr.sku_id = ss.id and ss.\"name\" in (:skuNames)", nativeQuery = true)
//    public Set<Integer> findConfigurationIdsBySkuNameIn(@Param("skuNames") List<String> skuNames);
//    
//    /**
//     * Method use to get companyIds based on sku name
//
//     * @param skuName
//     * @return
//     */
//    @Query(value = "select scsr.configuration_id from sysadm_skus ss, " +
//            "sysadm_configuration_sku_relns scsr where scsr.sku_id = ss.id and ss.\"key\" in (:skuKeys)", nativeQuery = true)
//    public Set<Integer> findConfigurationIdsBySkuKeyIn(@Param("skuKeys") List<String> skuKeys);
//    
//    /**
//     * Method use to get configurationIds based on sku name
//
//     * @param skuName
//     * @return
//     */
//    @Query(value = "select scsr.configuration_id from sysadm_skus ss, " +
//            "sysadm_configuration_sku_relns scsr where scsr.sku_id = ss.id and ss.\"name\" not in (:skuNames)", nativeQuery = true)
//    public Set<Integer> findConfigurationIdsBySkuNameNotIn(@Param("skuNames") List<String> skuNames);
//    
//    /**
//     * Get Company Basic detail by companyId and IsActive.
//     * 
//     * @param companyId
//     * @param isActive
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,c.companyName,c.companyTypeId,c.partnerId,c.partnerName,c.demoAccount,c.configurationId,c.addonConfigurationId) from Company c where c.companyId=:companyId and  (:isActive is null or c.isActive = :isActive)")
//    public Company getCompanyBasicDetailByCompanyIdAndIsActive(@Param("companyId") Integer companyId, @Param("isActive") Boolean isActive);
//    
//    /**
//     * Find Company By name,custom1,partnerId,isActive.
//     * 
//     * @param companyName
//     * @param customField1
//     * @param partnerId
//     * @param isActive
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,c.companyName,c.companyTypeId,c.partnerId,c.partnerName,c.demoAccount,c.configurationId,c.addonConfigurationId) from Company c "
//            + "where c.companyName=:companyName and c.custom1=:custom1 and c.partnerId=:partnerId and c.isActive=:isActive")
//    public Company findByCompanyNameAndCustom1AndPartnerIdAndIsActive(@Param("companyName") String companyName,@Param("custom1") String custom1,@Param("partnerId") Integer partnerId,@Param("isActive") boolean isActive);
//    
//    /**
//     * Find Company By name,partnerId.
//     * 
//     * @param companyName
//     * @param partnerId
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,c.companyName,c.companyTypeId,c.partnerId,c.partnerName,c.demoAccount,c.configurationId,c.addonConfigurationId) from Company c "
//            + "where c.companyName=:companyName and c.partnerId=:partnerId")
//    public Company findByCompanyNameAndPartnerId(@Param("companyName") String companyName,@Param("partnerId") Integer partnerId);
//    
//    /**
//     * Method use to get companyIds based on sku key
//     * 
//     * @param skuKeys
//     * @return
//     */
//    @Query(value = findCompanyIdsBySkuKey + " in(:skuKeys)")
//    public Set<Integer> findCompanyIdsBySkuKeyIn(@Param("skuKeys") List<String> skuKeys);
//    
//    /**
//     * Method use to get companyIds based on sku key
//     * 
//     * @param skuKeys
//     * @return
//     */
//    @Query(value = findPartnerIdsBySkuKey + " in(:skuKeys)")
//    public Set<Integer> findPartnerIdsBySkuKeyIn(@Param("skuKeys") List<String> skuKeys);
//
//    /**
//     * Find all company ids by Company Type and Active status.
//     *
//     * @param companyTypeId
//     * @param companyIds
//     * @return
//     */
//    @Query("select c.companyId from Company c where c.companyTypeId = :companyTypeId and c.companyId in(:companyIds)")
//    public Set<Integer> findCompanyIdsByCompanyTypeId(@Param("companyTypeId") Integer companyTypeId, @Param("companyIds") Set<Integer> companyIds);
//    
//    @Query("Select c.addonConfigurationId from Company c where c.companyId=:companyId and "+ isActiveCompany)
//    public Integer getAddonConfigurationIdByCompanyId(@Param("companyId") Integer companyId);
//    
//    /**
//     * Update lastRemindedToUpdate,modifiedOn,modifiedBy
//     * 
//     * @param companyId
//     * @param lastRemindedToUpdate
//     * @param modifiedOn
//     * @param modifiedBy
//     */
//    @Query("update Company c set c.lastRemindedToUpdate=:lastRemindedToUpdate,c.modifiedOn=:modifiedOn,c.modifiedBy=:modifiedBy where c.companyId=:companyId")
//    @Modifying
//    @Transactional
//    public void saveLastRemindedToUpdateAndModifiedOnAndModifiedBy(@Param("companyId") Integer companyId, @Param("lastRemindedToUpdate") Long lastRemindedToUpdate,
//            @Param("modifiedOn") Long modifiedOn,@Param("modifiedBy") Integer modifiedBy);
//    
//    
//    /**
//     * Find Company By Id,partnerId.
//     * 
//     * @param companyName
//     * @param partnerId
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,c.companyName,c.companyTypeId,c.partnerId,c.partnerName,c.demoAccount,c.configurationId,c.addonConfigurationId) from Company c "
//            + "where c.companyId=:companyId and c.partnerId=:partnerId")
//    public Company getByCompanyIdAndPartnerId(@Param("companyId") Integer companyId, @Param("partnerId") Integer partnerId);
//    
//    /**
//     * Find Company By companyName and isActive.
//     * 
//     * @param companyName
//     * @param isActive
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,c.companyName,c.companyTypeId,c.partnerId,c.partnerName,c.demoAccount,c.configurationId,c.addonConfigurationId) from Company c "
//            + "where c.companyName=:companyName and c.isActive=:isActive")
//    public Company getCompanyByCompanyNameAndIsActive(@Param("companyName") String companyName, @Param("isActive") boolean isActive);
//    
//  
//    /**
//     * Find Company By companyName,partnerId.
//     * 
//     * @param companyName
//     * @param partnerId
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,c.companyName,c.companyTypeId,c.partnerId) from Company c "
//            + "where c.companyName=:companyName and c.partnerId=:partnerId")
//    public Company getCompanyByCompanyNameAndPartnerId(@Param("companyName") String companyName, @Param("partnerId") Integer partnerId);
//
//    /**
//     * Get Company SuccessManagerId and AccountManagerId by CompanyId.
//     * 
//     * @param companyId
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.accountManagerId, c.successManagerId) from Company c  "
//            + "where c.companyId=:companyId")
//    public Company getSuccessManagerAndAccountManagerById(@Param("companyId") Integer companyId);
//
//    /**
//     * Find Company By companyId and isActive.
//     * 
//     * @param companyId
//     * @param isActive
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,c.companyName,c.companyTypeId,c.partnerId,c.partnerName,c.demoAccount,c.configurationId,c.addonConfigurationId) from Company c "
//            + "where c.companyId=:companyId and c.isActive=:isActive")
//    public Company getCompanyByCompanyIdAndIsActive(@Param("companyId") Integer companyId,
//            @Param("isActive") boolean isActive);
//
//    /**
//     * is company exists by companyId and isActive.
//     * 
//     * @param companyId
//     * @param isActive
//     * @return
//     */
//    public boolean existsCompanyByCompanyIdAndIsActive(Integer companyId, boolean isActive);
//
//    /**
//     * Get Company partnerId by CompanyId.
//     * 
//     * @param companyId
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.partnerId) from Company c  "
//            + "where c.companyId=:companyId")
//    public Company getPartnerIdByCompanyId(@Param("companyId") Integer companyId);
//
//    /**
//     * Find Company Name By companyId.
//     * 
//     * @param companyId
//     * @return
//     */
//    @Query("select companyName from Company c where c.companyId=:companyId")
//    public String getCompanyNameByCompanyId(@Param("companyId") Integer companyId);
//
//    /**
//     * Find userId, companyId, companyName, partnerid for migrated partners with certain roles
//     *
//     * @return
//     */
//    @Query(value = "select distinct user_company_table.id as userId, user_company_table.company_id as companyId, sc.name as companyName, smp.partner_id as partnerId from" +
//            " (select su.id, scur.company_id from sysadm_users su, sysadm_company_user_relns scur" +
//            " where su.id = scur.user_id" +
//            " and scur.role_id in (select id from sysadm_roles sr where sr.display_name in ('Client Admin', 'Partner Admin', 'System Administrator', 'Genesis Admin', 'Partner AR Admin', 'Client AR Admin', 'Paychex Master', 'Paychex Regular', 'Paychex RE', 'HR Pro', 'Frontline Coordinator', 'Genesis Employee', 'Independent Contractor', 'Content Author'))" +
//            " )user_company_table, sysadm_companies sc, sysadm_company_partner_relns scpr, sysadm_migrated_partners smp where" +
//            " user_company_table.company_id = sc.id and sc.id = scpr.company_id and scpr.partner_id = smp.partner_id and smp.is_active=true and sc.source in ('MHR','THR') and smp.migration_date > round(extract(epoch from current_timestamp - interval '24 hours'))" +
//            " union " +
//            " select distinct user_company_table.id as userId, user_company_table.company_id as companyId, sc.name as companyName, scpr.partner_id as partnerId from" +
//            " (select su.id, scur.company_id from sysadm_users su, sysadm_company_user_relns scur" +
//            " where su.id = scur.user_id" +
//            " and scur.role_id in (select id from sysadm_roles sr where sr.display_name in ('Client Admin', 'Partner Admin', 'System Administrator', 'Genesis Admin', 'Partner AR Admin', 'Client AR Admin', 'Paychex Master', 'Paychex Regular', 'Paychex RE', 'HR Pro', 'Frontline Coordinator', 'Genesis Employee', 'Independent Contractor', 'Content Author'))" +
//            " )user_company_table, sysadm_companies sc, sysadm_company_partner_relns scpr where" +
//            " user_company_table.company_id = sc.id and sc.id = scpr.company_id and sc.source in ('MHR','THR') and scpr.partner_id in (8148,1647620)", nativeQuery = true)
//    public List<Object[]> getUserIdCompanyIdCompanyNamePartnerId();
//
//    /**
//     * Find Company(id,name,typeId) By companyId.
//     * 
//     * @param companyId
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,c.companyName,c.companyTypeId) from Company c "
//            + "where c.companyId=:companyId")
//    public Company getCompanyByCompanyId(@Param("companyId") Integer companyId);
//
//    @Query("select companyId, companyTypeId from Company where companyId=:companyId")
//    public List<Object[]> getCompanyTypeIdByCompanyId(@Param("companyId") Integer companyId);
//
//    @Query(value = "SELECT EXISTS (select scur.company_id from sysadm_company_user_relns scur, sysadm_users su where scur.user_id =su.id and su.welcome_insight_status in('DELIVERED','VIEWED') and scur.company_id=:companyId)", nativeQuery = true)
//    public Boolean findWelcomeInsightsDelivered(@Param("companyId") Integer companyId);
//
//    @Query(value="select distinct cp.partner_id from sysadm_company_partner_relns cp where cp.company_id=:companyId", nativeQuery = true)
//    public Integer findPartnerIdByCompanyId(@Param("companyId") Integer companyId);
//
//
//    /**
//     * Method to get configurationId, addonConfigurationId and companyId
//     * 
//     * @param companyId
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,c.configurationId,c.addonConfigurationId) from Company c "
//            + "where c.companyId=:companyId and c.isActive=true")
//    public Company getCompanyById(@Param("companyId") Integer companyId);
//    
//    /**
//     * Find CompanyIds By companyNames and partnerId.
//     * 
//     * @param companyName
//     * @param partnerId
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,trim(c.companyName)) from Company c "
//            + "where trim(c.companyName) in (:companyNames) and c.partnerId=:partnerId")
//    public List<Company> getCompanyByCompanyNamesAndPartnerId(@Param("companyNames") List<String> companyNames, @Param("partnerId") Integer partnerId);
//
//
//    /**
//     * Set hrProId value empty
//     *
//     * @param hrProId
//     * @return
//     */
//    @Modifying
//    @Transactional
//    @Query(value = "update Company c set c.hrProId = null where c.hrProId=:hrProId)")
//    public void setCompanyHrProIdAsEmpty(@Param("hrProId") Integer hrProId);
//    
//    /**
//     * Find Company By UserId.
//     *
//     * @param companyName
//     * @param partnerId
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.Company(c.companyId,c.configurationId,c.addonConfigurationId) from Company c, CompanyUserRelns cur "
//            + "where c.companyId = cur.company.companyId and c.isActive=true and cur.user.userId =:userId")
//    public Company getCompanyByUserId(@Param("userId") Integer userId);
//   
//    /**
//     * Get all the previous migrated partner
//     * 
//     * @param migrationDate
//     * @return
//     */
//    @Query(value = "select smp.partner_id from sysadm_companies sc, sysadm_migrated_partners smp where sc.id = smp.partner_id and sc.company_type_id =1 and smp.migration_date <=:migrationDate "
//            + "and smp.is_active = true order by smp.partner_id desc", nativeQuery = true)
//    public List<Integer> findPreviousMigratedPartner(@Param("migrationDate") Long migrationDate);
//    
//    /**
//     * Find all companyIds by sku
//     * 
//     * @return
//     */
//    @Query(value="select distinct cp.company_id " + 
//                "from sysadm_company_partner_relns cp " + 
//                "inner join sysadm_company_configuration_relns cc on cp.company_id = cc.company_id " + 
//                "inner join sysadm_configuration_sku_relns cs on cc.configuration_id = cs.configuration_id " + 
//                "inner join sysadm_skus s on cs.sku_id = s.id " + 
//                "where cp.partner_id = :partnerId and s.key = :skuKey and cp.company_id not in (:companyIds)", nativeQuery=true)
//    public List<Integer> findCompanyIdsBySku(
//            @Param("partnerId") Integer partnerId,
//            @Param("skuKey") String skuKey,
//            @Param("companyIds") List<Integer> companyIds);
//
//    @Query("select sum(employeeCount) from Location where companyId =:companyId and " + isActiveCompany)
//    public int findEmployeeCount(@Param("companyId") Integer companyId);
}
