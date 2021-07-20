package com.nagarro.receiverregistration.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.receiverregistration.entity.ReceiverInfo;


public interface ReceiverInfoDao extends JpaRepository<ReceiverInfo,String>{

}
