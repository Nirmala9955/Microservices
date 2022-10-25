package com.sahu.service;

import java.util.List;

import com.sahu.model.IPLTeamInfo;

public interface IIPLTeamMgmtService {
	public String registerIPLTeam(IPLTeamInfo teamInfo);
	public IPLTeamInfo findIPLTeamInfo(int teamId);
	public List<IPLTeamInfo> findAllIPLTeamDetails();
}
