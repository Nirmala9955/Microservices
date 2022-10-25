package com.sahu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.client.IPLTeamServiceConsumer;
import com.sahu.model.IPLPlayerInfo;
import com.sahu.model.IPLTeamInfo;
import com.sahu.repository.IIPLPlayerRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IPLPlayerMgmtServiceImpl implements IIPLPlayerMgmtService {

	@Autowired
	private IIPLPlayerRepo playerRepo;
	
	@Autowired
	private IPLTeamServiceConsumer consumer;
	
	@Override
	public String registerIPLPlayer(IPLPlayerInfo playerInfo) {
		log.debug("inside registerIPLPlayer(-) method");
		//Consumer MS is consuming Producer MS service through FeignClient
		IPLTeamInfo team = consumer.findIPLTeamById(playerInfo.getTeamInfo().getTeamId()).getBody();
		log.info("Team details is gathered from other IPL_TEAM MS- "+team);
		//Assign team object to player object
		playerInfo.setTeamInfo(team);
		int idVal = playerRepo.save(playerInfo).getPlayerId();
		log.info("Saving player details with generated if value - "+idVal);
		return "Player and his team details saved having the player id - "+idVal;
	}

	@Override
	public List<IPLPlayerInfo> findAllPlayerInfo() {
		log.debug("inside findAllPlayerInfo() method");
		log.info("All player information is gathered");
		return playerRepo.findAll();
	}

}
