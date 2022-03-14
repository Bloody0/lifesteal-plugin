package bloody;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Event implements Listener {

    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent event){
        //checks if the killer and the killed person are entitys
        if(event.getEntity() instanceof Player && event.getEntity().getKiller() instanceof Player){
            Player killed = event.getEntity();
            Player killer = event.getEntity().getKiller();
            //Change the player's health
            killed.sendMessage("You died to " + killer.getDisplayName() + " and lost 1 heart!");
            killed.setMaxHealth(killed.getMaxHealth() - 2.0);
            killed.setHealthScale(killed.getMaxHealth());

            killer.setMaxHealth(killer.getMaxHealth() + 2.0);
            killer.setHealthScale(killer.getMaxHealth());
            killer.setHealth(killer.getHealth() + 1.0);
            killer.sendMessage("You killed " + killed.getDisplayName() + " and got 1 heart!");
            if(killed.getMaxHealth() == 0.0){
                BanList banList = Bukkit.getBanList(BanList.Type.NAME);
                banList.addBan(killed.getName(), "You ran out of hearts!", null, null);
            }
        }
    }
}
