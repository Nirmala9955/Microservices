package com.sahu.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "IPL_PLAYER_INFO")
public class IPLPlayerInfo {
	@Id
	@GeneratedValue
	private Integer playerId;
	@Column(length = 20)
	private String playerName;
	@Column(length = 20)
	private String role;
	private Integer jersyNo;
	@ManyToOne(targetEntity = IPLTeamInfo.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id", referencedColumnName = "teamId")
	private IPLTeamInfo teamInfo;
}
