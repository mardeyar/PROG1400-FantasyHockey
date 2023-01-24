import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Variables for the main class
        Team[] teamList = new Team[3];
        Scanner input = new Scanner(System.in);

        //region "Program Introduction"
        System.out.println("\nFANTASY HOCKEY APPLICATION");
        System.out.println("TEAM ENTRY");
        System.out.println("================================");
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
            for (int a = 0; a < 3; a++) {
                System.out.print("Enter name for player #" + (a+1) + ": ");
                String playerName = input.nextLine();
                //Make sure players name is at least 3 characters long
                while (playerName.length() < 3) {
                    System.out.println("Error: Player name must be at least 3 characters long. Please try that again.");
                    System.out.print("Enter name for player #" + (a+1) + ": ");
                    playerName = input.nextLine();
                }

                //Ask user to input goal totals, ensuring total is above 0
                System.out.print("Enter number of goals for " + playerName + ": ");
                int goals = input.nextInt();
                while (goals < 0) {
                    System.out.println("Error: Goals must be zero or greater. Please try that again.");
                    System.out.print("Enter number of goals for " + playerName + ": ");
                    goals = input.nextInt();
                }

                //Ask user to input assist totals, ensuring total is above 0
                System.out.print("Enter number of assists for " + playerName + ": ");
                int assists = input.nextInt();
                while (assists < 0) {
                    System.out.println("Error: Assists must be zero or greater. Please try that again.");
                    System.out.print("Enter number of assists for " + playerName + ": ");
                    assists = input.nextInt();
                }

                input.nextLine(); //Program doesn't continue unless adding this part to clear scanner
                //Take all the data entered from above and create a player object, then add to teamList
                Player player = new Player(playerName, goals, assists, teamList[i].getTeamName());
                teamList[i].addPlayer(player);
            }
        }
        //endregion
    }
}