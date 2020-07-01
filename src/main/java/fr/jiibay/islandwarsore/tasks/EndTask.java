package fr.jiibay.islandwarsore.tasks;

import fr.jiibay.islandwarsore.MainIWO;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class EndTask extends BukkitRunnable {

    public static int timer = 30;

    @Override
    public void run() {
        MainIWO.getInstance().getArmorStand().removeArmorStand(new Location(Bukkit.getWorld("world"), 1045, 5, 182));
        MainIWO.getInstance().getArmorStand().removeArmorStand(new Location(Bukkit.getWorld("world"), 1126, 5, 182));

       if (timer == 30){
           Bukkit.broadcastMessage(ChatColor.RED + "Le serveur redémarre dans 30 secondes");
           for (Player player : Bukkit.getOnlinePlayers()){
               player.setGameMode(GameMode.SPECTATOR);
           }
       }

        if (timer == 0){
            Bukkit.getServer().spigot().restart();
            cancel();
        }

        timer--;
    }
}
