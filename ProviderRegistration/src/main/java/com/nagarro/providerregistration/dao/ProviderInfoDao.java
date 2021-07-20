package com.nagarro.providerregistration.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.providerregistration.entity.ProviderInfo;

public interface ProviderInfoDao extends JpaRepository<ProviderInfo,String>{

}
