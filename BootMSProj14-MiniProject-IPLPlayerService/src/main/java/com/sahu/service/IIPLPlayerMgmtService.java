package com.sahu.service;

import java.util.List;

import com.sahu.model.IPLPlayerInfo;

public interface IIPLPlayerMgmtService {
	public String registerIPLPlayer(IPLPlayerInfo playerInfo);
	public List<IPLPlayerInfo> findAllPlayerInfo();
}
