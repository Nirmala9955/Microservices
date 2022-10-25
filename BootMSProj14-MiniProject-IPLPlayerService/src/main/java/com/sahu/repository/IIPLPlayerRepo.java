package com.sahu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.model.IPLPlayerInfo;

public interface IIPLPlayerRepo extends JpaRepository<IPLPlayerInfo, Integer> {

}
