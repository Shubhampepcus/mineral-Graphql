package com.graphql.learn.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.graphql.learn.entities.User;


/**
 * User repository for user entity.
 * 
 *  @author Shiva Jain
 *  @since 2020-01-09
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    
    List<User> findAll();
    
    public User findByUserId(Integer userId);

//    public final String isActiveUser = "isActive=true";
//
//    /**
//     * 
//     * @param id
//     * @return
//     */
//    @Query("from User where userId=:id and " + isActiveUser)
//    public User findActiveOne(@Param("id")Integer id);
//    
//    /**
//     * It will get User by userName lookup in all companies not only throne company
//     * 
//     * @param userName
//     * @return
//     */
//    public User findFirstByUserNameAndIsActive(String userName, boolean isActive);
//    
//    /**
//     * 
//     * @param username
//     * @param isActive
//     * 
//     * @return
//     */
//    public User findByUserNameAndIsActive(String username, boolean isActive);
//    
//    /**
//     * 
//     * @param username
//     * @param isActive
//     * 
//     * @return
//     */
//    public List<User> findByUserNameIgnoreCaseAndIsActive(String username, boolean isActive);
//    
//    /**
//     * 
//     * @param userId
//     * @param isActive
//     * @return
//     */
//    public User findByUserIdAndIsActive(Integer userId, boolean isActive);
//    
//    /**
//     * Find a duplicate or a potential duplicate i.e. active or inactive name in DB for a user name that is being created or updated
//     * 
//     * @param username
//     * @return
//     */
//    public List<User> findByUserNameStartingWith(String username);
//    
//    /**
//     * 
//     * @param referenceId
//     * @return
//     */
//    @Query("select new com.thinkhr.external.api.v2.db.entities.User(u.userId, u.firstName, u.userName, u.email) from User u where u.referenceId =:referenceId")
//    public List<User> findByReferenceId(@Param("referenceId") String referenceId);
//    
//    /**
//     * 
//     * @param userIds
//     * @return
//     */
//    public List<User> findByUserIdIn(@Param("userIds") List<Integer> userIds);
//
//    /**
//     * Update isDemoAccount column in the contacts table
//     * 
//     * @param companyIds
//     * @param isDemoAccount
//     */
//    @Query(value = "update sysadm_users su set is_demo_account =:demoAccount from sysadm_company_user_relns scur where su.id = scur.user_id and scur.company_id in (:companyIds) ", nativeQuery = true)
//    @Modifying
//    @Transactional
//    public void updateDemoAccountFlag(@Param("companyIds") List<Integer> companyIds, @Param("demoAccount") boolean demoAccount);
//    
//    /**
//     * Deactivate User
//     * 
//     * @param modifiedBy
//     * @param modifiedOn
//     * @param userId
//     */
//    @Query("update User u set u.isActive=false, u.modifiedBy = :modifiedBy, u.modifiedOn = :modifiedOn, u.userName = concat(u.userName,'__',:partnerId,'_',:companyId,'_inact'),"
//            + " u.email = concat(u.email,'__',:partnerId,'_',:companyId,'_inact') where u.userId = :userId")
//    @Modifying
//    @Transactional
//    public void deactivateUser(@Param("modifiedBy")Integer modifiedBy, @Param("modifiedOn")Long modifiedOn,
//            @Param(value = "userId")Integer userId, @Param(value = "companyId")Integer companyId,
//            @Param(value = "partnerId")Integer partnerId);
//    
//    /**
//     * Activate User
//     * 
//     * @param modifiedBy
//     * @param modifiedOn
//     * @param userId
//     */
//    @Query("UPDATE User u set u.isActive=true, u.modifiedBy = :modifiedBy, u.modifiedOn = :modifiedOn, u.userName = REPLACE(u.userName, CONCAT('__',:partnerId,'_',:companyId,'_inact'), '' ),"
//            + "u.email = REPLACE(u.email, CONCAT('__',:partnerId,'_',:companyId,'_inact'), '' ) where u.userId = :userId")
//    @Modifying
//    @Transactional
//    public void activateUser(@Param("modifiedBy")Integer modifiedBy, @Param("modifiedOn")Long modifiedOn,
//            @Param(value = "userId")Integer userId, @Param(value = "companyId")Integer companyId,
//            @Param(value = "partnerId")Integer partnerId);
//    
//    /**
//     * Activate Duplicate User
//     *
//     * @param modifiedBy
//     * @param modifiedOn
//     * @param userId
//     */
//    @Query("UPDATE User u set u.isActive=true, u.modifiedBy = :modifiedBy, u.modifiedOn = :modifiedOn, u.userName = REPLACE(u.userName, CONCAT('__',:partnerId,'_',:companyId,'_inact'), CONCAT('-COPY-',:userId) ),"
//            + "u.email = REPLACE(u.email, CONCAT('__',:partnerId,'_',:companyId,'_inact'), '' ) where u.userId = :userId")
//    @Modifying
//    @Transactional
//    public void activateDuplicateUser(@Param("modifiedBy") Integer modifiedBy, @Param("modifiedOn") Long modifiedOn,
//            @Param(value = "userId") Integer userId, @Param(value = "companyId") Integer companyId,
//            @Param(value = "partnerId") Integer partnerId);
//
//    /**
//     * @param referenceId
//     * @return
//     */
//    @Query("select distinct u.companyId from User u where u.referenceId=:referenceId")
//    public List<Integer> findDistinctCompanyIdByReferenceId(@Param("referenceId")String referenceId);
//    
//    /**
//     * @param userIds
//     * @param isActive
//     * @return List<User>
//     */
//    public List<User> findByUserIdInAndIsActive(List<Integer> userIds, boolean isActive);
//    
//    /**
//     * Get All Users of a company
//     * @param companyIs
//     * @return
//     */
//    public List<User> findByCompanyId(Integer companyId);
//
//    public List<User> findByCompanyIdAndRole(Integer companyId, String companyAdminRole);
//    
//    /**
//     * validate all active userIds for a company
//     * 
//     * @param parentDocumentId
//     * @param userIds
//     * @return
//     */
//    
//    @Query(value="select c.id from sysadm_users c, sysadm_company_user_relns cu, app_throne_handbooks h where c.id = cu.user_id and h.companyId = cu.company_id "
//            + "and h.id = :parentDocumentId and c.id in (:userIds) and c.is_active = true "
//            + "and not exists (SELECT signer_contact_id from app_throne_signatures where status NOT IN ('ERROR', 'CANCELED') "
//            + "and signature_document_id = :signatureDocumentId and signer_contact_id = c.id)",nativeQuery=true)
//    public List<Integer> findEligibleSigners(@Param("parentDocumentId")Integer parentDocumentId,
//            @Param("userIds")List<Integer> userIds, @Param("signatureDocumentId")Integer signatureDocumentId);
//    
//    /**
//     * Get all users of companies which belong to given configurationIds
//     * @param configurationIds
//     * @return
//     */
//    @Query(value = "select compUser.user.userId from CompanyUserRelns compUser, CompanyConfigurationRelns compConf,ConfigurationSkuRelns confSku where compUser.company.companyId=compConf.company.companyId and confSku.configuration.id = compConf.configuration.configurationId and confSku.sku.key in(:skuKeys)")
//    public List<Integer> findUserIdsBySkuKeyIn(@Param("skuKeys") List<String> skuKeys);
//    
//    /**
//     * Get all users of companies which belong to given hrProdIds
//     * @param hrProdIds
//     * @return
//     */
//    @Query(value = "select cur.user.userId from CompanyUserRelns cur where cur.company.hrProId in(:hrProIds) ")
//    public List<Integer> findUserIdsByHrProIdIn(@Param("hrProIds") List<Integer> hrProIds);
//
//    public List<User> findByCompanyIdAndIsActiveAndRole(Integer companyId, boolean active, String companyAdminRole);
//    
//    /**
//     * 
//     * @param companyIdList
//     */
//    @Transactional
//    @Modifying
//    @Query(value="delete from sysadm_users where id in(:userIds)", nativeQuery=true)
//    public void deleteByIdsIn(@Param("userIds")List<Integer> userIds );
//    
//    /**
//     * Find userId by 
//     * 
//     * @param partnerId
//     * @return userId
//     */
//    @Query(value = "select cur.user.userId from CompanyUserRelns cur where cur.company.companyId = :companyId and cur.user.isPrimary = true")
//    public Integer findPrimaryAdminByCompanyId(@Param("companyId") Integer companyId);
//    
//    /**
//     * Find user by company and role name list
//     * 
//     * @param companyId
//     * @param roles
//     * @return
//     */
//    @Query(value = "select u.userId from User u where u.companyId=:companyId and u.role in(:roles) and " + isActiveUser)
//    public List<Integer> findActiveUserByCompanyIdAndRoles(@Param("companyId") Integer companyId,
//            @Param("roles") List<String> roles);
//    
//    /**
//     *  Get internal users for company
//     * @param companyId
//     * @param type
//     * @return
//     */
//    public List<User> findByCompanyIdAndRoleInAndIsActive(Integer companyId, List<String> roles, Boolean isActive);
//    
//    @Query(value = "select u.userId from User u where u.userId in(:userIds) and " + isActiveUser)
//    public List<Integer> findUserIdByUserIdIn(@Param("userIds")List<Integer> userIds);
//
//    @Query(value = "select cur.user.userId from CompanyUserRelns cur, CompanyPartnerRelns cpr where cur.company.companyId=cpr.company.companyId and cpr.partner.companyId = :partnerId and cur.user.userId in(:userIds)")
//    public List<Integer> findUserIdsByPartnerIdAndUserIdIn(@Param("partnerId") Integer partnerId,
//            @Param("userIds") List<Integer> userIds);
//    
//    /**
//     * Get fullName by userId
//     * 
//     * @param userId
//     * @return
//     */
//    @Query("select u.fullName from User u where u.userId =:userId")
//    public String findFullNameByUserId(@Param("userId") Integer userId);
//    
//    /**
//     * Get All Users of a company
//     * @param companyIs
//     * @return
//     */
//    public List<User> findByCompanyIdIn(List<Integer> companyIds);
//    
//    /**
//     * Get all users IDs by companyId
//     * @param companyId
//     * @return
//     */
//    @Query(value = "select DISTINCT(compUser.user.userId) from CompanyUserRelns compUser where compUser.company.companyId=:companyId")
//    public Set<Integer> findUserIdsByCompanyId(@Param("companyId") Integer companyId);
//
//    /**
//     * Get all users of companies which have modified in last 24 hours and belong to given sku id
//     *
//     * @param skuKey
//     * @return
//     */
//    @Query(value = "select compUser.user.userId from CompanyUserRelns compUser, CompanyConfigurationRelns compConf,ConfigurationSkuRelns confSku where compUser.company.companyId=compConf.company.companyId and confSku.sku.key = :skuKey and compUser.user.userId in(:userIds)")
//    public Set<Integer> findUserIdsBySkuKeyInAndIdsIn(@Param("skuKey") String skuKey,@Param("userIds") List<Integer> userIds);
//    
//    /**
//     * get User Basic Details.
//     *  
//     * @param userId
//     * @return
//     */
//    @Query("Select new com.thinkhr.external.api.v2.db.entities.User(u.userId,u.firstName,u.lastName,u.email, u.phone, u.companyId,u.partnerId) From User u where u.userId=:userId")
//    public User getUserBasicDetails(@Param("userId") Integer userId);
//
//    /**
//     * Get User By username and isActive.
//     * 
//     * @param username
//     * @param isActive
//     * 
//     * @return
//     */
//    @Query("Select new com.thinkhr.external.api.v2.db.entities.User(u.userId, u.firstName, u.userName, u.email) From User u where lower(u.userName)=lower(:username) and u.isActive=:isActive")
//    public User getByUserNameAndIsActive(@Param("username") String username, @Param("isActive") boolean isActive);
//
//    /**
//     * Find a duplicate or a potential duplicate i.e. active or inactive name in DB
//     * for a user name that is being created or updated
//     * 
//     * @param username
//     * @return
//     */
//    @Query(value = "select username\\:\\:varchar from sysadm_users where username = citext(:username) limit 1", nativeQuery = true)
//    public String isUserNameExistsByUserName(@Param("username") String username);
//
//    @Query("Select new com.thinkhr.external.api.v2.db.entities.User(u.userId,u.firstName,u.lastName,u.fullName,u.userName, "
//            + "u.email,u.phone,u.companyId,u.companyName,u.partnerId,u.partnerName, "
//            + "u.roleId,u.role,u.termsAcceptedAt, u.roleDisplayName, u.department, u.jobTitle, u.welcomeInsightStatus) From User u where u.userId=:userId")
//    public User getUserByUserId(@Param("userId") Integer userId);
//
//    /**
//     * Find partner id of user
//     *
//     * @param userName
//     * @return
//     */
//    @Query("select u.partnerId from User u where u.userName =:userName")
//    Optional<Integer> getPartnerIdByUserName(@Param("userName") String userName);
//
//    /**
//     * Get UserId by username
//     * 
//     * @param username
//     * @return
//     */
//    @Query("select u.userId from User u where u.userName =:username and " + isActiveUser)
//    public Integer findUserIdByUsername(@Param("username") String username);
//
//    @Query(value = "select LOWER(username)\\:\\:varchar from sysadm_users where LOWER(username)\\:\\:citext in (:userNames)", nativeQuery = true)
//    public List<String> findUserNamesByUserNameIn(@Param("userNames") List<String> userNames);
//
//    @Query("select u.createdOn from User u where u.userId=:userId and " + isActiveUser)
//    public Long findUserCreationDate(@Param("userId") Integer id);
//
////    @Query("update User u set u.welcomeInsightStatus=:welcomeInsightStatus where u.userId =:userId")
////    @Modifying
////    @Transactional
////    public void updateInsightStatus(@Param("userId") Integer userId, @Param("welcomeInsightStatus") WelcomeInsightStatus welcomeInsightStatus);
//    
////    @Query("update User u set u.welcomeInsightStatus=:welcomeInsightStatus where u.userId in (:userIds)")
////    @Modifying
////    @Transactional
////    public void updateInsightStatus(@Param("userIds") List<Integer> userId, @Param("welcomeInsightStatus") WelcomeInsightStatus welcomeInsightStatus);
//
//    /**
//     * Get Users By emailId and isActive.
//     *
//     * @param emailId
//     * @param isActive
//     *
//     * @return
//     */
//    @Query("Select new com.thinkhr.external.api.v2.db.entities.User(u.userId, u.firstName, u.lastName, u.userName, u.email, u.partnerId, u.partnerName, u.companyId, u.companyName) From User u where lower(u.email)=lower(:email) and u.isActive=:isActive")
//    public List<User> getUsersByEmailIdAndIsActive(@Param("email") String emailId, @Param("isActive") boolean isActive);
//
//    @Query("Select new com.thinkhr.external.api.v2.db.entities.User(u.companyDisplayName, u.partnerDisplayName, u.source) "
//            + "From User u where u.userId=:userid")
//    public User findDisplayNameByUserId(@Param("userid") Integer userid);
//
//    /**
//     * Get username by email and authenticationCode.
//     *
//     * @param email
//     * @param authenticationCode
//     *
//     * @return
//     */    
//    @Query(value = "select u.username\\:\\:varchar " + 
//            "from sysadm_users u " + 
//            "inner join sysadm_company_user_relns cu on u.id = cu.user_id " + 
//            "inner join sysadm_company_partner_relns cp on cu.company_id = cp.company_id " + 
//            "inner join sysadm_companies c on cu.company_id = c.id " + 
//            "inner join sysadm_company_sso_configurations scf on cp.partner_id = scf.company_id " + 
//            "where u.email = :email " + 
//            "and u.is_active = true " + 
//            "and c.is_active = true " + 
//            "and scf.authentication_code = :authenticationCode limit 1", nativeQuery = true)
//    public String getUsernameByEmailAndAuthenticationCode(@Param("email") String email, @Param("authenticationCode") String authenticationCode);
//
//    /**
//     * Find User by Username
//     *
//     * @param userName
//     * @return
//     */
//    List<User> findByUserName(String userName);
//
//    /**
//     * Find Email By User Id
//     *
//     * @param userId
//     * @return
//     */
//    @Query("select u.email from User u where u.userId=:userId")
//    String findEmailByUserId(@Param("userId") Integer userId);
//
//    /**
//     * Find User Ids having the provided email
//     *
//     * @param email
//     * @return
//     */
//    @Query("select u.id from User u where u.email in (:email)")
//    List<Integer> findUserIdsByEmailIn(@Param("email") String email);
}
