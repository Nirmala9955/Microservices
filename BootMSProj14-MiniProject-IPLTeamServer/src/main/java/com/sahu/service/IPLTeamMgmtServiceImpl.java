package com.sahu.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.model.IPLTeamInfo;
import com.sahu.repository.IIPLTeamInfoRepo;

@Service
public class IPLTeamMgmtServiceImpl implements IIPLTeamMgmtService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IIPLTeamInfoRepo teamInfoRepo;
	
	@Override
	public String registerIPLTeam(IPLTeamInfo teamInfo) {
		logger.debug("inside registerIPLTeam(-) method");
		int idVal = teamInfoRepo.save(teamInfo).getTeamId();
		logger.info("IPL Team is registered sucessfully wiht id - "+idVal);
		return "Team is registered with ID - "+idVal;
	}

	@Override
	public IPLTeamInfo findIPLTeamInfo(int teamId) {
		logger.debug("inside findIPLTeamInfo(-) method");
		//return teamInfoRepo.getById(teamId);
		logger.info("Gettinf IPLTeam info by id - "+teamId);
		return teamInfoRepo.getReferenceById(teamId);
	}

	@Override
	public List<IPLTeamInfo> findAllIPLTeamDetails() {
		logger.debug("inside findAllIPLTeamDetails() method");
		logger.info("Getting all IPLTeam details");
		return teamInfoRepo.findAll();
	}

}
