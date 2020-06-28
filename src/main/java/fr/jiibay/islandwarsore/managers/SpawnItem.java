package fr.jiibay.islandwarsore.managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class SpawnItem {

    public void iron(){
        Bukkit.getWorld("world").dropItemNaturally(new Location(Bukkit.getWorld("world"), 25 , 5 ,-8).add(-0.5, 0, -0.5), new ItemStack(Material.IRON_INGOT, 10)).setVelocity(new Vector(0, 0, 0));
    }

    public void gold(){
        Bukkit.getWorld("world").dropItemNaturally(new Location(Bukkit.getWorld("world"), 26 , 5 ,-8).add( +0.5, 0, -0.5), new ItemStack(Material.GOLD_INGOT, 4)).setVelocity(new Vector(0, 0, 0));
    }

    public void diamond(){
        Bukkit.getWorld("world").dropItemNaturally(new Location(Bukkit.getWorld("world"), 28, 5 ,-8).add( +0.5, 0, -0.5), new ItemStack(Material.DIAMOND, 2)).setVelocity(new Vector(0, 0, 0));
    }

    public void emerald(){
        Bukkit.getWorld("world").dropItemNaturally(new Location(Bukkit.getWorld("world"), 30 , 5 ,-8).add( +0.5, 0, -0.5), new ItemStack(Material.EMERALD, 1)).setVelocity(new Vector(0, 0, 0));
    }
}
