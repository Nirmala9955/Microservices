package com.sahu.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.model.IPLPlayerInfo;
import com.sahu.service.IIPLPlayerMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/player")
@Slf4j
public class IPLPlayerOperationController {

	@Autowired
	private IIPLPlayerMgmtService playerMgmtService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveIPLPlayer(@RequestBody IPLPlayerInfo playerInfo) {
		log.debug("inside saveIPLPlayer(-) method");
		//Use service
		String resultMsg = playerMgmtService.registerIPLPlayer(playerInfo);
		log.info("Player details are saved with id - "+playerInfo.getPlayerId());
		return ResponseEntity.ok(resultMsg);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<IPLPlayerInfo>> fetchAllPlayersInfo() {
		log.debug("inside fetchAllPlayersInfo() method");
		//user service
		List<IPLPlayerInfo> playerList = playerMgmtService.findAllPlayerInfo();
		log.info("Retrieving All players info.");
		return ResponseEntity.ok(playerList);
	}
	
}
