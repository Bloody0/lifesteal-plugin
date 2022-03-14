package bloody;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

        @Override
        public void onEnable(){
            System.out.println("Thanks for using the lifesteal plugin made by bloody!");
            getServer().getPluginManager().registerEvents(new Event(), this);
        }

        @Override
        public void onDisable(){
            System.out.println("Sad to see you go!");
        }
}
