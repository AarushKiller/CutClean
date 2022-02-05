package me.vrom.cutclean;

import me.vrom.cutclean.events.GoldMine;
import me.vrom.cutclean.events.IronMine;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CutClean extends JavaPlugin {

    @Override
    public void onEnable() {
        //Send a message to console that the plugin has been enabled
        getLogger().info("CutClean has been enabled!");
        registerEvents();
        //Send a message to console that events have been registered
        getLogger().info("Events have been registered!");
        loadConfig();

    }

    @Override
    public void onDisable() {
        //Tell the server the plugin is being disabled
        this.getLogger().info("CutClean has been disabled!");
    }

    public void registerEvents() {
        PluginManager pm  = this.getServer().getPluginManager();
        pm.registerEvents(new IronMine(this) , this);
        pm.registerEvents(new GoldMine(this) , this);
    }

    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
