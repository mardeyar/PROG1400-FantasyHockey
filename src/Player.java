public class Player {

    //region "Properties"
    //Which properties or attributes would a hockey player have for this program?
    private String playerName;
    private int playerGoals;
    private int playerAssists;
    private int playerPoints;
    private String teamName;
    //endregion

    //region "Player Constructor"
    public Player(String playerName, int playerGoals, int playerAssists, String teamName) {
        this.playerName = playerName;
        this.playerGoals = playerGoals;
        this.playerAssists = playerAssists;
        this.playerPoints = playerGoals + playerAssists;
        this.teamName = teamName;
    }
    //endregion

    //region "Player Getters"
    protected String getPlayerName() {
        return playerName;
    }

    protected int getPlayerGoals() {
        return playerGoals;
    }

    protected int getPlayerAssists() {
        return playerAssists;
    }

    protected int getPlayerPoints() {
        return playerPoints;
    }

    protected String getTeamName() {
        return teamName;
    }
    //endregion
}