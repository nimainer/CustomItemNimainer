package com.nima.main;

import Commands.ArmorStandCommand;
import Commands.CScommand;
import Commands.FlyCommand;
import Commands.MapCommand;
import Items.SwordKbItem;
import Items.TeleportBowItem;
import Items.Wand;
import Listeners.JoinLeaveListener;
import Listeners.TeleportBowListener;
import events.ExplosiveWandEvent;
import events.SwordKbEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // variable reference
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        // items
        SwordKbItem.init();
        Wand.init();
        TeleportBowItem.init();
        // commands
        getCommand("givewand").setExecutor(new CScommand());
        getCommand("GiveRabbitFoot").setExecutor(new CScommand());
        getCommand("giveTpbow").setExecutor(new CScommand());
        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("CINarmorStand").setExecutor(new ArmorStandCommand());
        getCommand("map").setExecutor(new MapCommand(this));
        // events
        getServer().getPluginManager().registerEvents(new ExplosiveWandEvent(), this);
        getServer().getPluginManager().registerEvents(new SwordKbEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(this), this);
        getServer().getPluginManager().registerEvents(new TeleportBowListener(), this);

    }

    @Override
    public void onDisable() {
    }
}
