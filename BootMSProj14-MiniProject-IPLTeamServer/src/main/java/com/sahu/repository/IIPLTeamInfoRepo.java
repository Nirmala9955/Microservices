package com.sahu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.model.IPLTeamInfo;

public interface IIPLTeamInfoRepo extends JpaRepository<IPLTeamInfo, Integer> {

}
