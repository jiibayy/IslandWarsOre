package fr.jiibay.islandwarsore;

import fr.jiibay.islandwarsore.listeners.*;
import fr.jiibay.islandwarsore.managers.*;
import fr.jiibay.islandwarsore.utils.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Villager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainIWO extends JavaPlugin {

    public static MainIWO instance;
    public Scoreboard scoreboardMain;
    public ScoreboardManager scoreboardManager = new ScoreboardManager();
    public HashMap<UUID, PlayerProfile> playerProfile = new HashMap<UUID, PlayerProfile>();
    public Map<UUID, FastBoard> scorboard = new HashMap<>();
    public ArmorStand armorStand = new ArmorStand();
    public Stat stat;

    @Override
    public void onEnable() {
        instance = this;
        scoreboardMain = Bukkit.getScoreboardManager().getMainScoreboard();

        new Objective().setHealth();
        PluginManager pluginManager = getServer().getPluginManager();

        setStat(Stat.LOBBY);
        pluginManager.registerEvents(new onDrop(), this);
        pluginManager.registerEvents(new onQuit(), this);
        pluginManager.registerEvents(new entityDamage(), this);
        pluginManager.registerEvents(new foodLevel(), this);
        pluginManager.registerEvents(new onInventory(), this);
        pluginManager.registerEvents(new onInteract(), this);
        pluginManager.registerEvents(new onJoin(), this);
        pluginManager.registerEvents(new asyncChat(), this);

    }

    @Override
    public void onDisable() {

    }

    public static MainIWO getInstance() {
        return instance;
    }



    // GESTION DES STATUS DE JEU

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public ArmorStand getArmorStand() {
        return armorStand;
    }
}
