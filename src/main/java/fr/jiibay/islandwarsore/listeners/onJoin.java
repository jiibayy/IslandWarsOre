package fr.jiibay.islandwarsore.listeners;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.*;
import fr.jiibay.islandwarsore.tasks.*;
import fr.jiibay.islandwarsore.utils.FastBoard;
import fr.jiibay.islandwarsore.utils.Title;
import net.minecraft.server.v1_8_R3.Items;
import org.bukkit.*;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import sun.applet.Main;

import java.util.Random;

public class onJoin implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();
        FastBoard fastBoard = new FastBoard(player);
        PlayerProfile playerProfile = new PlayerProfile(player);
        MainIWO.getInstance().scorboard.put(player.getUniqueId(), fastBoard);

        player.getInventory().clear();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setPlayerListName(playerProfile.getTeam().getName().toLowerCase() + " " + player.getName());
        Title.sendTabTitle(player, ChatColor.GREEN + "Vous jouer sur le mode de jeu IslandWarsOre", ChatColor.YELLOW + "Vous jouer sur le serveur H-Party", ChatColor.AQUA + "Plugin créé par Jiibay", ChatColor.YELLOW + "Serveur mini-jeu",ChatColor.BLUE + "Discord : https://discord.gg/ZxSrq6W", ChatColor.GOLD + "play.h-party.fr");

        Random random = new Random();

        Bukkit.getScheduler().scheduleSyncRepeatingTask(MainIWO.getInstance(),  () -> new DiamondTask().runTask(MainIWO.getInstance()), random.nextInt(1200), random.nextInt(1200));
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MainIWO.getInstance(),  () -> new IronTask().runTask(MainIWO.getInstance()), random.nextInt(1200), random.nextInt(1200));
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MainIWO.getInstance(),  () -> new GoldTask().runTask(MainIWO.getInstance()), random.nextInt(1200), random.nextInt(1200));
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MainIWO.getInstance(),  () -> new EmeraldTask().runTask(MainIWO.getInstance()), random.nextInt(1200), random.nextInt(1200));
        // Quand le joueur join et que c'est en lobby
        if (MainIWO.getInstance().getStat() == Stat.LOBBY) {

            MainIWO.getInstance().getArmorStand().createArmorStand(player.getLocation());
            MainIWO.getInstance().playerProfile.put(player.getUniqueId(), playerProfile);
            MainIWO.getInstance().getScoreboardManager().updateBoard();
            Team.NONE.addPlayer(player, playerProfile);
            player.setGameMode(GameMode.ADVENTURE);

            player.getInventory().setItem(4, new GiveItem().setItemBanner(Material.BANNER, ChatColor.AQUA + "Choisir une équipe", DyeColor.WHITE));
            event.setJoinMessage(ChatColor.GREEN + player.getName() + ChatColor.YELLOW + " a rejoins la partie !");


            if (Bukkit.getOnlinePlayers().size() == Bukkit.getMaxPlayers()) {
                MainIWO.getInstance().setStat(Stat.START);
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GREEN + "La partie vas bienôt commencer !");
                }
                StartTask startTask = new StartTask();
                startTask.runTaskTimer(MainIWO.getInstance(), 10L, 20L);
            }
        }

        // Quand le joueur join et que c'est en status playing ou end
        if (MainIWO.getInstance().getStat() == Stat.PLAYING || MainIWO.getInstance().getStat() == Stat.END){
            player.sendMessage(ChatColor.RED + "La partie a déjà commencer vous êtes en mode specteur !");
        }


    }
}
