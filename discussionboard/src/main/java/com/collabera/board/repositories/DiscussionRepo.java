package com.collabera.board.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.collabera.board.models.Discussion;

public interface DiscussionRepo extends JpaRepository<Discussion, Long> {


	@Query(value = "select d.title from discussion d")
	List<Discussion> getAllDiscussions();

	@Query(value = "select title from discussion d where d.title like :searchTitle")
	List<Discussion> getDiscussionsByName(@Param("searchTitle") String title);



//	@Modifying
//	@Query(value = "insert into Users (name, age, email, status) values (:name, :age, :email, :status)",
//	  nativeQuery = true)
//	void insertUser(@Param("name") String name, @Param("age") Integer age, 
//	  @Param("status") Integer status, @Param("email") String email);
	//TODO add params
	@Modifying
	@Query(value="INSERT INTO discussion "
			+ "(title, content, author_username, channel_category_id) "
			+ "values (:title, :siteContent, :author, :channelId)")
	Discussion addDiscussion(@Param("title")String title, 
			@Param("siteContent") String siteContent, 
			@Param("author")String author, 
			@Param("channelId")Integer channelId);

	@Modifying
	@Query(value = "UPDATE discussion d SET where d.id = :id ")
	Discussion updateDiscussion(@Param("id") Integer id);
	
	@Modifying
	@Query(value="UPDATE discussion d set d.viewable = false where d.id = ?1")
	Discussion deleteDiscussion(Integer id);
	
	

}
