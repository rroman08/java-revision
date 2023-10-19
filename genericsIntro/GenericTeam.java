package genericsIntro;

import java.util.ArrayList;
import java.util.List;

public class GenericTeam<T extends Player> {

    private String teamName;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public GenericTeam(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(T t) {

        if (!teamMembers.contains(t)) {
            teamMembers.add(t);
        }
    }

    public void listTeamMembers() {
        System.out.println(teamName + " Roster: ");
        for (T t : teamMembers) {
            System.out.println(t.name());
        }
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
