package com.collabera.board.repositories;
//package com.collabera.board.repositories;
//
//import com.photonInfotech.citiBankPOC.model.Account;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RestResource;
//
//import java.util.List;
//
///*
//The JPA Based DAL implementation. The DAL should provide necessary query to
//satisfy the operation per the requirement. Note again, while this implementation is using
//JPA, there are other option to implement the DAL.
//*/
//public interface AccountDAL extends JpaRepository<Account, Long> {
//
//    // SAmple of implementation in JPA to allow custom made query
//	@RestResource
//    @Query(value = "SELECT * FROM account b inner JOIN address a ON b.id = a.account_id"
//            + " inner JOIN account_type c ON b.id = c.account_id "
//            + " inner JOIN address_type d ON d.address_id=a.id Where b.enabled = true", nativeQuery = true)
//    List<Account> getAllAccounts();
//
//
//    @Query(value = "SELECT * FROM account b inner JOIN address a ON b.id = a.account_id"
//            + " inner JOIN account_type c ON b.id = c.account_id "
//            + " inner JOIN address_type d ON d.address_id=a.id Where b.enabled = true and b.id=:account_id ", nativeQuery = true)
//    Account getAccount(@Param("account_id") long id);
//    
//    Account findByName(String name);
//
//}
