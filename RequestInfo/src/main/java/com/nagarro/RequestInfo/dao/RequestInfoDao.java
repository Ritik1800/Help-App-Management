package com.nagarro.RequestInfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.RequestInfo.entity.RequestInfo;

public interface RequestInfoDao extends JpaRepository<RequestInfo,Integer>{

}
