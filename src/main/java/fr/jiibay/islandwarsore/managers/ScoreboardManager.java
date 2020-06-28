package fr.jiibay.islandwarsore.managers;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.tasks.StartTask;
import fr.jiibay.islandwarsore.utils.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

public class ScoreboardManager {

    public void scoreboardLobby(FastBoard board){

        board.updateTitle(ChatColor.BLUE + "§lIslandWarsOre");
        String [] lines = {
                "§w",
                ChatColor.GREEN + "➥ Joueurs : " + ChatColor.AQUA + Bukkit.getOnlinePlayers().size(),
                ChatColor.GREEN + "➥ Chronomètre : " + ChatColor.AQUA + StartTask.timer + "s",
                "§c",
                ChatColor.GREEN + "➥ Status : " + ChatColor.AQUA + MainIWO.getInstance().getStat(),
                ChatColor.GREEN + "➥ Joueurs manquant : " + ChatColor.AQUA + (Bukkit.getMaxPlayers() - Bukkit.getOnlinePlayers().size()),
                "§d",
                ChatColor.GOLD + "play.h-party.fr",
        };

        board.updateLines(lines);
    }

    public void scoreboardStart(FastBoard board){

        board.updateTitle(ChatColor.BLUE + "§lIslandWarsOre");

        int playersPing = ((CraftPlayer) board.getPlayer()).getHandle().ping;

        String [] lines = {
                "§h",
                ChatColor.GREEN + "➥ Joueurs : " + ChatColor.AQUA + Bukkit.getOnlinePlayers().size(),
                ChatColor.GREEN + "➥ Chronomètre : " + ChatColor.AQUA + StartTask.timer + "s",
                "§c",
                ChatColor.GREEN + "➥ Status : " + ChatColor.AQUA + MainIWO.getInstance().getStat(),
                ChatColor.GREEN + "➥ Ping : " + ChatColor.AQUA + playersPing + "ms",
                "§d",
                ChatColor.GOLD + "play.h-party.fr",
        };

        board.updateLines(lines);
    }
    public void scoreboardPlaying(FastBoard board){

        PlayerProfile playerProfile = MainIWO.getInstance().playerProfile.get(board.getPlayer().getUniqueId());
        int playersPing = ((CraftPlayer) board.getPlayer()).getHandle().ping;

        String [] lines = {
                "§h",
                ChatColor.GREEN + "➥ Joueurs : " + ChatColor.AQUA + Bukkit.getOnlinePlayers().size(),
                ChatColor.GREEN + "➥ Chronomètre : " + ChatColor.AQUA + StartTask.timer + "s",
                "§c",
                ChatColor.GREEN + "➥ Status : " + ChatColor.AQUA + MainIWO.getInstance().getStat(),
                ChatColor.GREEN + "➥ Ping : " + ChatColor.AQUA + playersPing + "ms",
                ChatColor.GREEN + "➥ Equipe : " + ChatColor.AQUA + playerProfile.getTeam().getName(),
                ChatColor.GREEN + "➥ Kills : " + ChatColor.AQUA + playerProfile.getKill(),
                ChatColor.GREEN + "➥ Points : " + ChatColor.AQUA + playerProfile.getTeam().getPoints(),
                "§d",
                ChatColor.GOLD + "play.h-party.fr",
        };

        board.updateLines(lines);
    }
    public void scoreboardEnd(FastBoard board){

        String [] lines = {
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
        };

        board.updateLines(lines);
    }



    public void updateBoard(){
        MainIWO.getInstance().getServer().getScheduler().runTaskTimer(MainIWO.getInstance(), () -> {
            for (FastBoard board : MainIWO.getInstance().scorboard.values()) {
                if (MainIWO.getInstance().getStat() == Stat.LOBBY) {
                    scoreboardLobby(board);
                }
                if (MainIWO.getInstance().getStat() == Stat.START) {
                    scoreboardStart(board);
                }
                if (MainIWO.getInstance().getStat() == Stat.PLAYING) {
                    scoreboardPlaying(board);
                }
                if (MainIWO.getInstance().getStat() == Stat.END) {
                    scoreboardEnd(board);
                }
            }
        }, 0, 20);
    }
}
