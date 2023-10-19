package genericsIntro;

interface Player {

    String name();
}

record FootballPlayer (String name, String position) implements Player {}

record RugbyPlayer (String name, String position) implements Player {}

public class MainBetter {

    public static void main(String[] args) {

        SportsTeam phillies1 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros1 = new SportsTeam("Houston Astros");

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies1.addTeamMember(harper);
        phillies1.addTeamMember(marsh);
        phillies1.listTeamMembers();

        // FOOTBALL TEAM:
        SportsTeam afc = new SportsTeam("Arsenal London");
        var raya = new FootballPlayer("David Raya", "Goalkeeper");
        afc.addTeamMember(raya);
        afc.listTeamMembers();

        System.out.println("=".repeat(30));

        // USE THE GENERIC TEAM:
        GenericTeam<FootballPlayer> bayern = new GenericTeam<>("Bayern Munich");
        GenericTeam<FootballPlayer> bvb = new GenericTeam<>("Borussia Dortmund");

        scoreResult(bayern, 3, bvb, 5);
        var kane = new FootballPlayer("Harry Kane", "Forward");
        var mueller = new FootballPlayer("Thomas Müller", "Forward");
        var musiala = new FootballPlayer("Jamal Musiala", "Forward");
        FootballPlayer[] players = {kane, mueller,musiala};

        for (var player : players) {
            bayern.addTeamMember(player);
        }

        bayern.listTeamMembers();
        var reus = new FootballPlayer("Marco Reus", "Midfielder");
        bvb.addTeamMember(reus);

    }

    public static void scoreResult(GenericTeam team1, int t1Score,
                                   GenericTeam team2, int t2Score) {

        String msg = team1.setScore(t1Score, t2Score);
        // Just to alter t2 state as well.
        team2.setScore(t2Score, t1Score);
        System.out.printf("%s %s %s%n", team1, msg, team2);
    }
}
