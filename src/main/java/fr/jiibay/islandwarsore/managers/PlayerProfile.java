package fr.jiibay.islandwarsore.managers;


import fr.jiibay.islandwarsore.MainIWO;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PlayerProfile {

    private int kill = 0;
    private Team team = null;
    private Player p ;

    public PlayerProfile(Player p){
        this.p = p;
        Team.NONE.addPlayer(this.p, this);
    }

    protected void setTeam(Team team){
        if (this.team != null) this.team.removePlayer(p);
        this.team = team;
        team.addPlayer(p, this);
        p.setPlayerListName(team.getName()+" "+p.getName());
        MainIWO.getInstance().scoreboardMain.getTeam(team.getName()).addPlayer(p.getPlayer());
    }

    public Team getTeam() {
        return team;
    }

    public void addKill(int kill) {
        this.kill = kill + kill;
    }

    public int getKill() {
        return kill;
    }

}
