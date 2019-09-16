package com.collabera.board.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.collabera.board.models.Discussion;
import com.collabera.board.models.DiscussionChannel;

public interface DiscussionChannelRepo extends JpaRepository<DiscussionChannel, Long> {


	@Query(value = "select title from channel c")
	List<Discussion> getAllChannels();

	@Query(value = "select title from channel c where c.title like :searchTitle")
	List<Discussion> getChannelsByName(@Param("searchTitle") String title);



//	@Modifying
//	@Query(value = "insert into Users (name, age, email, status) values (:name, :age, :email, :status)",
//	  nativeQuery = true)
//	void insertUser(@Param("name") String name, @Param("age") Integer age, 
//	  @Param("status") Integer status, @Param("email") String email);
	//TODO add params
	@Modifying
	@Query(value="INSERT INTO channel c "
			+ "(title, content, author_username) "
			+ "values (:title, :author)")
	Discussion addChannel(@Param("title")String title, @Param("author")String author);

	@Modifying
	@Query(value = "UPDATE channel c SET where c.id = :id ")
	Discussion updateChannel(@Param("id") Integer id);
	
	@Modifying
	@Query(value="UPDATE channel c set c.viewable = false where c.id = ?1")
	Discussion deleteChannel(Integer id);

}
