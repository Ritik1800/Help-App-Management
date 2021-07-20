package com.nagarro.LoginInfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.LoginInfo.entity.LoginInfo;

public interface LoginInfoDao extends JpaRepository<LoginInfo,String>{

}
