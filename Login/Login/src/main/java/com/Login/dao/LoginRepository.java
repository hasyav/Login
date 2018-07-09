package com.Login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Login.entity.User;

public interface LoginRepository extends JpaRepository<User, String> {


}
