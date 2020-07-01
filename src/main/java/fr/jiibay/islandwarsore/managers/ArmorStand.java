package fr.jiibay.islandwarsore.managers;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftVillager;
import org.bukkit.entity.*;

public class ArmorStand {

    public void createArmorStand(Location location, String name){

        org.bukkit.entity.ArmorStand armorStand = (org.bukkit.entity.ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);

        armorStand.setCustomName(name);
        armorStand.setVisible(false);
        armorStand.setCustomNameVisible(true);
    }
    public void removeArmorStand(Location location) {


    }
}
