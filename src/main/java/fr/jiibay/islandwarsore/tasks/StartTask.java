package fr.jiibay.islandwarsore.tasks;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.PlayerProfile;
import fr.jiibay.islandwarsore.managers.Stat;
import fr.jiibay.islandwarsore.managers.Team;
import fr.jiibay.islandwarsore.utils.Title;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StartTask extends BukkitRunnable {

    public static int timer = 30;

    @Override
    public void run() {


        if (Bukkit.getOnlinePlayers().size() < Bukkit.getMaxPlayers()){
            timer = 30 + 1;
            cancel();
            MainIWO.getInstance().setStat(Stat.LOBBY);
            Bukkit.broadcastMessage(ChatColor.RED + "Pas assez de joueurs le chronmètre reviens à zéro.");
        }

        timer--;
        if (timer == 10 || timer == 9 || timer == 8 || timer == 7 || timer == 6 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1 || timer == 0){
            for (Player players : Bukkit.getOnlinePlayers()){
                Title.sendTitle(players, 20, 70, 10, ChatColor.YELLOW + "La partie commence dans " + ChatColor.RED + timer, null);
            }
        }



        if (timer == 0) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                Title.sendTitle(players, 10, 20, 10, ChatColor.YELLOW + "Que le meilleur gagne !", null);
                players.getInventory().clear();

                PlayerProfile pp = MainIWO.getInstance().playerProfile.get(players.getUniqueId());
                if (pp.getTeam() == Team.NONE) {
                    if (Team.BLUE.getPlNumber() < Team.RED.getPlNumber()) {
                        Team.BLUE.addPlayer(players, pp);
                    } else {
                        Team.RED.addPlayer(players, pp);
                    }

                }
            }

            for (Player players : Bukkit.getOnlinePlayers()){
                PlayerProfile playerProfile = MainIWO.getInstance().playerProfile.get(players.getUniqueId());

                if (playerProfile.getTeam() == Team.RED){
                    players.setBedSpawnLocation();
                }
            }
            MainIWO.getInstance().getArmorStand().createArmorStand(new Location(Bukkit.getWorld("world"), 1045, 5, 182), ChatColor.BLUE + "Coffre bleu");
            MainIWO.getInstance().getArmorStand().createArmorStand(new Location(Bukkit.getWorld("world"), 1126, 5, 182), ChatColor.RED + "Coffre rouge");
            MainIWO.getInstance().setStat(Stat.PLAYING);
            PlayingTask playingTask = new PlayingTask();
            playingTask.runTaskTimer(MainIWO.getInstance(), 10L, 20L);
            cancel();
        }
    }
}
