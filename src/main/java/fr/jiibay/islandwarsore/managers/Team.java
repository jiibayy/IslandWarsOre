package fr.jiibay.islandwarsore.managers;

import fr.jiibay.islandwarsore.MainIWO;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public enum Team {

    BLUE(ChatColor.BLUE + "[Bleu]", 5, 0),
    RED(ChatColor.RED + "[Rouge]", 5, 0),
    NONE(   "§", 100,0);

    private ArrayList<UUID> playerlist;
    private final String name;
    private int maxsize;
    private int points;
    private org.bukkit.scoreboard.Team team;

    Team(String name, int maxsize, int points){
        this.points = points;
        this.name = name;
        this.maxsize = maxsize;
        playerlist = new ArrayList<>();
        if(MainIWO.getInstance().scoreboardMain.getTeam(name) != null) MainIWO.getInstance().scoreboardMain.getTeam(name).unregister();
        team = MainIWO.getInstance().scoreboardMain.registerNewTeam(name);
        team.setPrefix(this.getName() + " ");
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points = this.points + points;
    }

    public String getName() {
        return name;
    }

    public int getMaxSize(){
        return maxsize;
    }

    public int getPlNumber(){
        return playerlist.size();
    }

    public void addPlayer(Player p, PlayerProfile pp){
        if(!playerlist.contains(p.getUniqueId())) {
            playerlist.add(p.getUniqueId());
            team.addPlayer(Bukkit.getOfflinePlayer(p.getUniqueId()));
            pp.setTeam(this);
        }
    }

    public void removePlayer(Player p){
        playerlist.remove(p.getUniqueId());
        team.removePlayer(Bukkit.getOfflinePlayer(p.getUniqueId()));
    }

}
