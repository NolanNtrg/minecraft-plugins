package fr.xlan.mcpluginstest;

import fr.xlan.mcpluginstest.commands.Command;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mcpluginstest extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Pluginstest plugin enabled");
        this.getCommand("test").setExecutor(new Command());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Pluginstest plugin disabled");
    }
}