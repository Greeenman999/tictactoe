package de.greenman999.tictactoe;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIConfig;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class TicTacToe extends JavaPlugin {

    private static de.greenman999.tictactoe.TicTacToe plugin;
    FileConfiguration config = getConfig();

    PluginManager pluginManager = Bukkit.getPluginManager();

    public static final String PREFIX = "§7[§eTemplate 1.19§7]";

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;


        CommandAPI.onEnable(this);
        registerAllCommands();
        //pluginManager.registerEvents(new ExampleListener(), Template119.getPlugin());

        //saveDefaultConfig();
        log("Plugin successfully enabled and loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log("Plugin successfully disabled and unloaded!");
    }

    private void registerAllCommands() {

    }

    @Override
    public void onLoad() {
        CommandAPI.onLoad(new CommandAPIConfig().verboseOutput(false).silentLogs(true));
    }


    public static void log(String string) {
        Logger.getLogger("Template 1.19").info(string);
    }

    public static de.greenman999.tictactoe.TicTacToe getPlugin() {
        return plugin;
    }


}
