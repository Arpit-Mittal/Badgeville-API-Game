package net.roseindia.form;

public class winnerPlayer {
	
	String playerName;
	String teamId;
	String playerPoints;
	String teamName;
	String totalTeamPoints;
	String winnerStatus;
	
	public winnerPlayer(String playerName, String teamId, String playerPoints,
			String teamName, String totalTeamPoints, String winnerStatus)
	{
		this.playerName = playerName;
		this.teamId = teamId;
		this.playerPoints = playerPoints;
		this.teamName = teamName;
		this.totalTeamPoints=totalTeamPoints;
		this.winnerStatus=winnerStatus;
		
	}

	public String getWinnerStatus() {
		return winnerStatus;
	}
	public void setWinnerStatus(String winnerStatus) {
		this.winnerStatus = winnerStatus;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getPlayerPoints() {
		return playerPoints;
	}
	public void setPlayerPoints(String playerPoints) {
		this.playerPoints = playerPoints;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTotalTeamPoints() {
		return totalTeamPoints;
	}

	public void setTotalTeamPoints(String totalTeamPoints) {
		this.totalTeamPoints = totalTeamPoints;
	}
	

}
