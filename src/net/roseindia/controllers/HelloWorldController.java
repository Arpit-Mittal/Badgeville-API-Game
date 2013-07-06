package net.roseindia.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.roseindia.form.Team;
import net.roseindia.form.Teams;
import net.roseindia.form.playerUserInformation;
import net.roseindia.form.players;
import net.roseindia.form.winnerPlayer;
import net.roseindia.form.winnerPlayers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.json.JSONException;
import org.json.JSONObject;

@Controller
public class HelloWorldController {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException,
			JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	private static String extractPlayerInformation(String playerId) {
		String playerInfo = "";
		String playerDisplayName[] = null, siteUrl[] = null, userEmail[] = null, pointsAll[] = null;
		String storingPlayerJson = null;
		try {
			JSONObject json = readJsonFromUrl("http://sandbox.badgeville.com/api/berlin/17744f9bf6fd75ea8cb93f005452d27d/players/"
					+ playerId + ".json");
			storingPlayerJson = json.toString();
			playerDisplayName = storingPlayerJson.split("\"display_name\":\"");
			playerInfo += playerDisplayName[1].substring(0,
					playerDisplayName[1].indexOf("\"")) + "|";
			storingPlayerJson = json.toString();
			siteUrl = storingPlayerJson.split("\"site_url\":\"");
			playerInfo += siteUrl[1].substring(0, siteUrl[1].indexOf("\""))
					+ "|";
			storingPlayerJson = json.toString();
			userEmail = storingPlayerJson.split("\"user_email\":\"");
			playerInfo += userEmail[1].substring(0, userEmail[1].indexOf("\""))
					+ "|";
			storingPlayerJson = json.toString();
			pointsAll = storingPlayerJson.split("\"points_all\":");
			playerInfo += pointsAll[1].substring(0, pointsAll[1].indexOf(","));
		} catch (Exception e) {
			System.out.println("Exception Occured" + e);
		}
		return (playerInfo);
	}

	static ArrayList<String> teamNamesAfter = new ArrayList<String>();
	static ArrayList<String> teamIdAfter = new ArrayList<String>();
	static ArrayList<String> playerNames = new ArrayList<String>();
	static ArrayList<String> multiplePlayerIds = new ArrayList<String>();
	static ArrayList<String> multiplePlayerInformation = new ArrayList<String>();

	public static void listingTeamAllSitesIncludingIndividualMembers(
			JSONObject json) {
		String teamNames[];
		String teamId[];
		String multiplePlayer[];
		String players, playersId, playerInformation;
		String multiplePlayerId[];

		int i = 0;
		int numberTeams = 0;
		try {
			teamNames = json.toString().split("\"display_name\":\"");
			teamId = json.toString().split("user_email\":\"");
			for (i = 1; i < teamNames.length; i++) {
				teamNamesAfter.add(numberTeams,
						teamNames[i].substring(0, teamNames[i].indexOf("\"")));
				teamIdAfter.add(numberTeams,
						teamId[i].substring(0, teamId[i].indexOf("@")));
				numberTeams++;
			}
			for (i = 0; i < teamNamesAfter.size(); i++) {
				try {
					JSONObject teamMemberJson = readJsonFromUrl("http://sandbox.badgeville.com/api/berlin/17744f9bf6fd75ea8cb93f005452d27d/teams/"
							+ teamIdAfter.get(i) + "/players.json");
					multiplePlayer = teamMemberJson.toString().split(
							"\"display_name\":\"");
					multiplePlayerId = teamMemberJson.toString().split(
							"\"id\":\"");

					players = "";
					playersId = "";
					playerInformation = "";
					for (int j = 1; j < multiplePlayer.length; j++) {
						if (j != multiplePlayer.length - 1) {
							players += multiplePlayer[j].substring(0,
									multiplePlayer[j].indexOf("\"")) + ",";

						} else {
							players += multiplePlayer[j].substring(0,
									multiplePlayer[j].indexOf("\""));

						}
					}

					for (int k = 1; k < multiplePlayerId.length; k++) {
						if (k != multiplePlayerId.length - 1) {
							playersId += multiplePlayerId[k].substring(0,
									multiplePlayerId[k].indexOf("\"")) + ",";
							playerInformation += extractPlayerInformation(multiplePlayerId[k]
									.substring(0,
											multiplePlayerId[k].indexOf("\"")));
							playerInformation += ",";
						} else {
							playersId += multiplePlayerId[k].substring(0,
									multiplePlayerId[k].indexOf("\""));
							playerInformation += extractPlayerInformation(multiplePlayerId[k]
									.substring(0,
											multiplePlayerId[k].indexOf("\"")));
						}
					}
					playerNames.add(i, players);
					multiplePlayerInformation.add(i, playerInformation);
					multiplePlayerIds.add(i, playersId);
				}

				catch (Exception e) {
					System.out.println("Exception occured in Main:-" + e);
				}
			}

		} catch (Exception e) {
			System.out
					.println("Exception occured in listingTeamAllSitesIncludingIndividualMembers:-"
							+ e);
		}

		System.out
				.println("Player Names:Player Information:PlayersId:-Team Names:TeamId");

		for (i = 0; i < playerNames.size(); i++) {
			System.out.println(playerNames.get(i) + ":");
			System.out.println(multiplePlayerInformation.get(i) + ":");
			System.out.println(multiplePlayerIds.get(i) + ":");
			System.out.println(teamNamesAfter.get(i) + ":");// Team Names
			System.out.println(teamIdAfter.get(i) + ":");
		}
	}

	Teams teamForm = new Teams();
	

	public static void differenceTimeStampRestCalls(long totalTime) {
		long diffMilliSeconds;
		long diffSeconds = totalTime / 1000 % 60;
		long diffMinutes = totalTime / (60 * 1000) % 60;
		long diffHours = totalTime / (60 * 60 * 1000) % 24;
		long diffDays = totalTime / (24 * 60 * 60 * 1000);
		System.out.print("\nTotal Time in ms:-" + totalTime);
		System.out.print("\n");
		System.out.print(diffDays + " days, ");
		System.out.print("\n");
		System.out.print(diffHours + " hours, ");
		System.out.print("\n");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print("\n");
		System.out.print(diffSeconds + " seconds.");
		System.out.print("\n");
		diffMilliSeconds = totalTime
				- ((diffHours * 60 * 60 * 1000) + (diffMinutes * 60 * 1000) + (diffSeconds * 1000));
		System.out.print(diffMilliSeconds + " milliseconds.");

	}

	@RequestMapping("/helloworld")
	public ModelAndView helloWord() {
		teamNamesAfter.clear();
		teamIdAfter.clear();
		playerNames.clear();
		multiplePlayerIds.clear();
		multiplePlayerInformation.clear();
		try {
			long startTime = 0, endTime = 0, totalTime = 0;

			JSONObject json = readJsonFromUrl("http://sandbox.badgeville.com/api/berlin/17744f9bf6fd75ea8cb93f005452d27d/teams.json");
			startTime = System.currentTimeMillis();
			listingTeamAllSitesIncludingIndividualMembers(json);
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			differenceTimeStampRestCalls(totalTime);
			List<Team> teamsInfo = new ArrayList<Team>();
			teamsInfo.clear();
			for (int i = 0; i < playerNames.size(); i++) {
				teamsInfo.add(new Team(teamNamesAfter.get(i), teamIdAfter
						.get(i), playerNames.get(i), multiplePlayerIds.get(i),
						multiplePlayerInformation.get(i), false, "Enter"));
			}

			teamForm.setTeamsInfo(teamsInfo);
			return new ModelAndView("helloworld", "teamForm", teamForm);
		} catch (Exception e) {
			return new ModelAndView("helloworld", "teamForm", teamForm);
		}
	}

	players multiplePlayer = new players();

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("teamForm") Teams teamForm) {
		List<Team> userInfo = teamForm.getTeamsInfo();
		String playerInfo;
		String userEnteredPlayerName = null;
		int startIndex = 0, endIndex = 0;

		List<playerUserInformation> playerInformation = new ArrayList<playerUserInformation>();

		if (null != userInfo && userInfo.size() > 0) {

			for (Team team : userInfo) {
				if (team.isPlayingFlag()) {
					playerInfo = team.getPlayersInfo();
					userEnteredPlayerName = team.getUserInputPlayerName();
					if (!playerInfo.contains(","))// only 1 player
					{
						playerInfo = playerInfo.replace('|', '-');
						String[] splits = playerInfo.split("-");
						playerInformation.add(new playerUserInformation(
								splits[1], splits[2], splits[0]));
						multiplePlayer.setPlayerInfo(playerInformation);
					} else if (playerInfo.contains(","))// Multiple players
					{
						playerInfo = playerInfo.replace('|', '-');
						playerInfo += ",";
						startIndex = playerInfo.indexOf(userEnteredPlayerName);
						playerInfo = playerInfo.substring(startIndex);
						endIndex = playerInfo.indexOf(",");
						playerInfo = playerInfo.substring(0, endIndex);
						String[] splits = playerInfo.split("-");
						playerInformation.add(new playerUserInformation(
								splits[1], splits[2], splits[0]));
						multiplePlayer.setPlayerInfo(playerInformation);
					}

				}

			}
		}
		return new ModelAndView("playerInfo", "multiplePlayer", multiplePlayer);
	}

	ArrayList<String> winnerPlayerNames = new ArrayList<String>();
	ArrayList<String> teamId = new ArrayList<String>();
	ArrayList<String> teamName = new ArrayList<String>();
	ArrayList<String> playerPoints = new ArrayList<String>();
	ArrayList<String> totalTeamPoints = new ArrayList<String>();
	ArrayList<String> playerId = new ArrayList<String>();
	ArrayList<String> winnerStatus = new ArrayList<String>();
	List<winnerPlayer> winnerPlayerInfo = new ArrayList<winnerPlayer>();
	winnerPlayers winnerPlayInfo = new winnerPlayers();

	@RequestMapping(value = "/winner.html", method = RequestMethod.GET)
	public ModelAndView winnerOfTournament() {

		int i = 0, j = 0;
		int count = 0;
		String[] pointsAll = null;
		winnerPlayerNames.clear();
		teamId.clear();
		teamName.clear();
		playerPoints.clear();
		totalTeamPoints.clear();
		playerId.clear();
		winnerStatus.clear();
		winnerPlayerInfo.clear();
		long startTime = 0, endTime = 0, totalTime = 0;
		startTime = System.currentTimeMillis();
		System.out.println("Winner of Tournament");
		for (i = 0; i < playerNames.size(); i++) {
			String[] splitPlayerNames = playerNames.get(i).split(",");
			String[] splitMultiplePlayerIds = multiplePlayerIds.get(i).split(
					",");
			for (j = 0; j < splitPlayerNames.length; j++) {
				winnerPlayerNames.add(count, splitPlayerNames[j]);
				teamName.add(count, teamNamesAfter.get(i));
				teamId.add(count, teamIdAfter.get(i));
				playerId.add(count, splitMultiplePlayerIds[j]);
				count++;
			}
		}

		for (i = 0; i < winnerPlayerNames.size(); i++) {
			try {
				JSONObject json = readJsonFromUrl("http://sandbox.badgeville.com/api/berlin/17744f9bf6fd75ea8cb93f005452d27d/players/"
						+ playerId.get(i) + ".json");
				pointsAll = json.toString().split("\"points_all\":");
				playerPoints.add(i,
						pointsAll[1].substring(0, pointsAll[1].indexOf(",")));
			} catch (Exception e) {
				System.out.println("Exception Occured" + e);
			}

		}

		String storeTeamName1 = null, storeTeamName2 = null;
		int k = 0;
		ArrayList<String> index;
		int storeIndex = 0;
		int sumPlayerPoints = 0;

		for (i = 0; i < teamNamesAfter.size(); i++) {

			sumPlayerPoints = 0;
			index = new ArrayList<String>();
			index.clear();

			storeTeamName1 = teamNamesAfter.get(i);
			for (k = 0; k < teamName.size(); k++) {
				storeTeamName2 = teamName.get(k);
				if (storeTeamName1.contentEquals(storeTeamName2)) {
					index.add(String.valueOf(k));
				}
			}

			for (j = 0; j < index.size(); j++) {
				storeIndex = Integer.parseInt(index.get(j));
				sumPlayerPoints += Integer.parseInt(playerPoints
						.get(storeIndex));
			}
			for (j = 0; j < index.size(); j++) {
				storeIndex = Integer.parseInt(index.get(j));
				totalTeamPoints
						.add(storeIndex, String.valueOf(sumPlayerPoints));
			}

		}

		String maxElement = null;
		winnerStatus.clear();

		// maxElement = Collections.max(totalTeamPoints);

		maxElement = totalTeamPoints.get(0);
		int maxElementIndex = 0;
		for (i = 1; i < totalTeamPoints.size(); i++) {
			if (Integer.parseInt(maxElement) < Integer.parseInt(totalTeamPoints
					.get(i))) {
				maxElement = totalTeamPoints.get(i);
				maxElementIndex = i;
			}
		}

		for (i = 0; i < totalTeamPoints.size(); i++) {
			if (totalTeamPoints.get(maxElementIndex).equalsIgnoreCase(
					totalTeamPoints.get(i))) {
				winnerStatus.add(i, "Winner");
			} else {
				winnerStatus.add(i, "Looser");
			}
		}

		System.out
				.println("Winner Player Names,Team Names,Team Id,Player Ids,Player Points,Total Team Points, Winner Status-");
		for (i = 0; i < winnerPlayerNames.size(); i++) {
			System.out.println(winnerPlayerNames.get(i) + " " + teamName.get(i)
					+ " " + teamId.get(i) + " " + playerId.get(i) + " "
					+ playerPoints.get(i) + " " + totalTeamPoints.get(i) + " "
					+ winnerStatus.get(i));
		}

		for (i = 0; i < winnerPlayerNames.size(); i++) {
			winnerPlayerInfo.add(new winnerPlayer(winnerPlayerNames.get(i),
					teamId.get(i), playerPoints.get(i), teamName.get(i),
					totalTeamPoints.get(i), winnerStatus.get(i)));
		}

		winnerPlayInfo.setWinnerPlayerInfo(winnerPlayerInfo);
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		differenceTimeStampRestCalls(totalTime);

		return new ModelAndView("winnerInfo", "winnerPlayInfo", winnerPlayInfo);

	}
}
