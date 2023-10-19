package genericsIntro;

record BaseballPlayer (String name, String position) implements Player {}

public class Main {

    public static void main(String[] args) {

        BaseballTeam phillies = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros = new BaseballTeam("Houston Astros");

        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();
    }

    public static void scoreResult(BaseballTeam team1, int t1Score,
                                   BaseballTeam team2, int t2Score) {

        String msg = team1.setScore(t1Score, t2Score);
        // Just to alter t2 state as well.
        team2.setScore(t2Score, t1Score);
        System.out.printf("%s %s %s%n", team1, msg, team2);
    }
}
