package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {

	    @Query("select u from Users u where LOWER(u.email) = LOWER(:email)")
	    Users findByEmail(@Param("email") String email) ;

}
