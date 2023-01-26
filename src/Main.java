import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Variables for the main class
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        //region "Program Introduction"
        System.out.println("\nFANTASY HOCKEY APPLICATION");
        System.out.println("TEAM ENTRY");
        System.out.println("================================");

        System.out.print("How many teams are in this league?: ");
        int amtOfTeams = input.nextInt();
        Team[] teamList = new Team[amtOfTeams]; //Array to store the team names, user determines how many teams
        input.nextLine(); //Clear scanner or else program errors out
        //endregion

        //region "Add Team names"
        //Loop through the entry of team names. 3 team league = 3 loops.
        for (int i = 0; i < teamList.length; i++) {
            System.out.print("Enter name for team #" + (i+1) + ": ");
            String teamName = input.nextLine();
            //Make sure team name is at least 3 characters long
            while (teamName.length() < 3) {
                System.out.println("Error: Team name must be at least 3 characters long. Please try that again.");
                System.out.print("Enter name for team #" + (i+1) + ": ");
                teamName = input.nextLine();
            }
            teamList[i] = new Team(teamName);
        }
        //endregion

        //region "Add Player Details"
        System.out.println("\nPLAYER ENTRY");
        System.out.println("================================");

        //Nested for loop to loop through adding players to teams. 3 players per team
        for (int i = 0; i < teamList.length; i++) {
            System.out.println("Enter players for " + teamList[i].getTeamName() + ":");
            //Loop through to add name, goals and assists
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter name for player #" + (j+1) + ": ");
                String playerName = input.nextLine();
                //Make sure players name is at least 3 characters long
                while (playerName.length() < 3) {
                    System.out.println("Error: Player name must be at least 3 characters long. Please try that again.");
                    System.out.print("Enter name for player #" + (j+1) + ": ");
                    playerName = input.nextLine();
                }

                //Ask user to input goal totals, ensuring total is above 0
                System.out.print("Enter number of goals for " + playerName + ": ");
                int playerGoals = input.nextInt();
                while (playerGoals < 0) {
                    System.out.println("Error: Goals must be zero or greater. Please try that again.");
                    System.out.print("Enter number of goals for " + playerName + ": ");
                    playerGoals = input.nextInt();
                }

                //Ask user to input assist totals, ensuring total is above 0
                System.out.print("Enter number of assists for " + playerName + ": ");
                int playerAssists = input.nextInt();
                while (playerAssists < 0) {
                    System.out.println("Error: Assists must be zero or greater. Please try that again.");
                    System.out.print("Enter number of assists for " + playerName + ": ");
                    playerAssists = input.nextInt();
                }

                input.nextLine(); //Program doesn't continue unless adding this part to clear scanner data
                //Take all the data entered from above and create a player object, then add to teamList
                Player player = new Player(playerName, playerGoals, playerAssists, teamList[i].getTeamName());
                teamList[i].addPlayer(player);
            }
        }
        //endregion

        //region "Team Stats REPORT"
        System.out.println("REPORT: Stats Per Team");
        System.out.println("================================");

        //Loop through the teamList and print out the values that are now attached to each team
        for (int i = 0; i < teamList.length; i++) {
            System.out.printf("%-20s| %-8s| %-8s| %-12s| %-20s| %-20s", //Format console output cleanly
                    teamList[i].getTeamName(),
                    "G: " + teamList[i].getTeamGoals(),
                    "A: " + teamList[i].getTeamAssists(),
                    "Total: " + teamList[i].getTeamPoints(),
                    "Budget: $" + df.format(teamList[i].getTeamBudget()),
                    "Rating: " + teamList[i].getTeamRating());
            System.out.println();
        }
        //endregion

        //region "Player Stats REPORT"
        System.out.println("REPORT: Stats Per Player");
        System.out.println("================================");

        //Loop through our teamRoster arraylist to get data from above for each player
        for (int i = 0; i < teamList.length; i++) {
            ArrayList<Player> teamRoster = teamList[i].getTeamRoster();
            System.out.println(teamList[i].getTeamName()); //Print the team name once, then players below
            for (int j = 0; j < teamList.length; j++) {
                Player player = teamRoster.get(j);
                System.out.printf("%-25s| %-8s| %-8s| %-12s", //Format our console output cleanly
                        player.getPlayerName(),
                        "G: " + player.getPlayerGoals(),
                        "A: " + player.getPlayerAssists(),
                        "Total: " + player.getPlayerPoints()
                        );
            }
        }
    }
}