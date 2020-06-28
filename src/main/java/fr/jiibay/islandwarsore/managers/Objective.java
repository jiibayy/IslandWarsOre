package fr.jiibay.islandwarsore.managers;

import fr.jiibay.islandwarsore.MainIWO;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;

public class Objective {

    public void setHealth(){

        if (MainIWO.getInstance().scoreboardMain.getObjective("health") != null){
            MainIWO.getInstance().scoreboardMain.getObjective("health").unregister();
        }
        org.bukkit.scoreboard.Objective health = MainIWO.getInstance().scoreboardMain.registerNewObjective("health", "health");
        health.setDisplayName(ChatColor.RED + "❤");
        health.setDisplaySlot(DisplaySlot.BELOW_NAME);
    }

}
