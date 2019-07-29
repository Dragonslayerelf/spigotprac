package com.dragonslayerelf.spigottesting.spigottesting;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spigottesting extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Opening...");
        this.getCommand("healme").setExecutor(new CommandClass());
        this.getCommand("setrace").setExecutor(new CommandClass());
        this.getCommand("getLoredItem").setExecutor(new CommandClass());
        //this.getConfig().options().copyDefaults();
        //this.saveConfig();
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EventClass(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Closing...");
    }
}
