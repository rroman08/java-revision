package genericsIntro;

import java.util.ArrayList;
import java.util.List;

public class SportsTeam {

    private String teamName;
    private List<Player> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public SportsTeam(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(Player player) {

        if (!teamMembers.contains(player)) {
            teamMembers.add(player);
        }
    }

    public void listTeamMembers() {
        System.out.print(teamName + " Roster: ");
        System.out.println(teamMembers);
    }

    public int ranking() {
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore) {

        String msg = "lost to";
        if(ourScore > theirScore) {
            totalWins++;
            msg = "beat";
        } else if (ourScore == theirScore) {
            totalTies++;
            msg = "tied";
        } else {
            totalLosses++;
        }

        return msg;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
