package net.roseindia.form;

public class Team {
	private String teamName;
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getPlayerNames() {
		return playerNames;
	}

	public void setPlayerNames(String playerNames) {
		this.playerNames = playerNames;
	}

	public String getPlayersId() {
		return playersId;
	}

	public void setPlayersId(String playersId) {
		this.playersId = playersId;
	}

	public String getPlayersInfo() {
		return playersInfo;
	}

	public void setPlayersInfo(String playersInfo) {
		this.playersInfo = playersInfo;
	}

	private String teamId;
	private String playerNames;
	private String playersId;
	private String playersInfo;
	private boolean playingFlag;
	private String userInputPlayerName;

	public boolean isPlayingFlag() {
		return playingFlag;
	}

	public void setPlayingFlag(boolean playingFlag) {
		this.playingFlag = playingFlag;
	}

	public String getUserInputPlayerName() {
		return userInputPlayerName;
	}

	public void setUserInputPlayerName(String userInputPlayerName) {
		this.userInputPlayerName = userInputPlayerName;
	}

	public Team() {

	}

	public Team(String teamName, String teamId, String playerNames, String playersId, String playersInfo,boolean playingFlag,String userInputPlayerName) {
		this.teamName = teamName;
		this.teamId = teamId;
		this.playerNames = playerNames;
		this.playersId = playersId;
		this.playersInfo = playersInfo;
		this.playingFlag = playingFlag;
		this.userInputPlayerName = userInputPlayerName;
	}

	

}
