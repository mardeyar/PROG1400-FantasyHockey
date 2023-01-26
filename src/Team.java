import java.util.ArrayList;
import java.util.Random;

public class Team {

    //region "Team Properties/Attributes"
    //What things make up a hockey team for this program?
    private String teamName;
    private int teamGoals;
    private int teamAssists;
    private int teamPoints;
    private double teamBudget;
    private String teamRating;
    private ArrayList<Player> teamRoster;
    //endregion

    //region "Team Constructors"
    public Team(String teamName) {
        this.teamName = teamName;
        this.teamGoals = 0;
        this.teamAssists = 0;
        this.teamPoints = 0;
        this.teamBudget = new Random().nextDouble() * 100000; //This creates random budget, between $0.00 - $100,000.00
        this.teamRating = "";
        this.teamRoster = new ArrayList<Player>();
    }

    protected void addPlayer(Player player) {
        teamRoster.add(player);
        teamGoals = teamGoals + player.getPlayerGoals();
        teamAssists = teamAssists + player.getPlayerAssists();
        teamPoints = teamPoints + player.getPlayerPoints();
    }
    //endregion

    //region "Team Getters"
    protected String getTeamName() {
        return teamName;
    }

    protected int getTeamGoals() {
        return teamGoals;
    }

    protected int getTeamAssists() {
        return teamAssists;
    }

    protected int getTeamPoints() {
        return teamPoints;
    }

    protected double getTeamBudget() {
        return teamBudget;
    }

    //Logic needed in here to determine team rating
    protected String getTeamRating() {
        if (teamPoints > 20) {
            teamRating = "*** stars";
        } else if (teamPoints >= 10) {
            teamRating = "** stars";
        } else if (teamPoints > 0) {
            teamRating = "* stars";
        } else {
            teamRating = "0 stars";
        }
        return teamRating;
    }

    protected ArrayList<Player> getTeamRoster() {
        return teamRoster;
    }
    //endregion
}