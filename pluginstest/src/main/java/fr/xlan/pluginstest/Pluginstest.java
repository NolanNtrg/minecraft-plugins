package fr.xlan.pluginstest;

import fr.xlan.pluginstest.commands.Command;
import org.bukkit.plugin.java.JavaPlugin;

public final class Pluginstest extends JavaPlugin {

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
