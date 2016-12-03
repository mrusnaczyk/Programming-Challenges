// @JUDGE_ID: 859464  10194  Java  "Football (aka Soccer)"
package Football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numTournaments = Integer.parseInt(s.nextLine());
		int numTCount = numTournaments - 1;
		try {
			for (int tournament = 0; tournament < numTournaments; tournament++) {
				String tName = s.nextLine();
				int numTeams = Integer.parseInt(s.nextLine());
				HashMap<String, Integer> teamIndex = new HashMap<String, Integer>();
				ArrayList<Team> teams = new ArrayList<Team>();

				for (int team = 0; team < numTeams; team++) {
					String next = s.nextLine();
					teams.add(new Team(next));
					teamIndex.put(next, team);
				}
				int numGames = Integer.parseInt(s.nextLine());
				// Add scoring info
				// team name 1#goals1@goals2#team name 2
				for (int game = 0; game < numGames; game++) {
					String nextGame = s.nextLine();
					String teamOneInfo = nextGame.substring(0, nextGame.indexOf("@"));
					String teamTwoInfo = nextGame.substring(nextGame.indexOf("@") + 1);
					String teamOneName = teamOneInfo.substring(0, teamOneInfo.indexOf("#"));
					String teamTwoName = teamTwoInfo.substring(teamTwoInfo.indexOf("#") + 1);
					int teamOneGoals = Integer.parseInt(teamOneInfo.substring(teamOneInfo.indexOf("#") + 1));
					int teamTwoGoals = Integer.parseInt(teamTwoInfo.substring(0, teamTwoInfo.indexOf("#")));
					Team teamOne = teams.get(teamIndex.get(teamOneName));
					Team teamTwo = teams.get(teamIndex.get(teamTwoName));
					teamOne.addGoalScored(teamOneGoals);
					teamOne.addGoalAgainst(teamTwoGoals);
					teamTwo.addGoalScored(teamTwoGoals);
					teamTwo.addGoalAgainst(teamOneGoals);

					if (teamOneGoals > teamTwoGoals) {
						teamOne.addWin();
						teamTwo.addLoss();
						teamOne.addPoints(3);
					} else if (teamTwoGoals > teamOneGoals) {
						teamTwo.addWin();
						teamOne.addLoss();
						teamTwo.addPoints(3);
					} else {
						teamOne.addTie();
						teamTwo.addTie();
						teamOne.addPoints(1);
						teamTwo.addPoints(1);
					}
					teamOne.addGamePlayed();
					teamTwo.addGamePlayed();

				}
				// Arrays.sort(teams.toArray());
				Collections.sort(teams);

				System.out.println(tName);
				int rank = 1;
				for (Team t : teams) {
					System.out.println(rank + ") " + t.getName() + " " + t.getPoints() + "p, " + t.getGamesPlayed()
							+ "g (" + t.getWins() + "-" + t.getTies() + "-" + t.getLoss() + "), "
							+ (t.getGoalScored() - t.getGoalAgainst()) + "gd (" + t.getGoalScored() + "-"
							+ t.getGoalAgainst() + ")");
					rank++;
				}
				if (numTCount > 0) {
					numTCount--;
					System.out.println();
				}
			}
		} catch (Exception e) {
			s.close();
			System.exit(0);
		}
	}

	// [Team Name, Total Points, Wins, Ties, Losses, Goals scored, Goals
	// against]
	static class Team implements Comparable<Team> {
		private String name;
		private int totalPoints;
		private int numWins;
		private int numTies;
		private int numLosses;
		private int goalsScored;
		private int goalsAgainst;
		private int gamesPlayed;

		public Team(String name) {
			this.name = name;
			totalPoints = 0;
			numWins = 0;
			numTies = 0;
			numLosses = 0;
			goalsScored = 0;
			goalsAgainst = 0;
			gamesPlayed = 0;
		}

		public String getName() {
			return name;
		}

		public void addWin() {
			numWins++;
		}

		public void addTie() {
			numTies++;
		}

		public void addLoss() {
			numLosses++;
		}

		public int getWins() {
			return numWins;
		}

		public int getTies() {
			return numTies;
		}

		public int getLoss() {
			return numLosses;
		}

		public void addGoalScored(int numGoals) {
			goalsScored += numGoals;
		}

		public void addGoalAgainst(int numGoals) {
			goalsAgainst += numGoals;
		}

		public int getGoalScored() {
			return goalsScored;
		}

		public int getGoalAgainst() {
			return goalsAgainst;
		}

		public void addPoints(int numPoints) {
			totalPoints += numPoints;
		}

		public int getPoints() {
			return totalPoints;
		}

		public void addGamePlayed() {
			gamesPlayed++;
		}

		public int getGamesPlayed() {
			return gamesPlayed;
		}

		public int compareTo(Team t) {
			if (getPoints() != t.getPoints()) {
				return t.getPoints() - getPoints();
			}
			if (getWins() != t.getWins()) {
				return t.getWins() - getWins();
			}
			if ((getGoalScored() - getGoalAgainst()) != (t.getGoalScored() - t.getGoalAgainst())) {
				return (t.getGoalScored() - t.getGoalAgainst()) - (getGoalScored() - getGoalAgainst());
			}
			if (getGoalScored() != t.getGoalScored()) {
				return t.getGoalScored() - this.getGoalScored();
			}
			if (getGamesPlayed() != t.getGamesPlayed()) {
				return getGamesPlayed() - t.getGamesPlayed();
			}
			return getName().toLowerCase().compareTo(t.getName().toLowerCase());
		}

	}

}
