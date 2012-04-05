package me.blha303;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Ouch extends JavaPlugin {
	
	
	
	public static Ouch plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onDisable() {
		this.logger.info(this.getDescription().getName() + " " + getConfig().getString("lang.disable"));
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new myListener(), this);
		FileConfiguration config;    // http://forums.bukkit.org/threads/tutorial-intermediate-configuration-yaml-make-configs.45383/
		try{
			config = getConfig();
			File Ouch = new File (getDataFolder() + "config.yml");
			Ouch.mkdir();
			if(!config.contains("lang")){
				config.set("lang", "english");
				}
			if(!config.contains("lang.name")){
				config.set("lang.name", "Ouch");
				}
			if(!config.contains("lang.disable")){
				config.set("lang.disable", "is now disabled.");
				}
			if(!config.contains("lang.enable")){
				config.set("lang.enable", "Enabled.");
				}
			if(!config.contains("lang.break")){
				config.set("lang.break", "Ouch.");
				}
			if(!config.contains("lang.place")){
				config.set("lang.place", "Ahhhhh.....");
				}
			saveConfig();
		}catch(Exception e1){
		e1.printStackTrace();
		}
		this.logger.info("[" + this.getDescription().getName() + "]" + " " + getConfig().getString("lang.enable"));
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("ouch")){
				reloadConfig();
				this.logger.info("Ouch config reloaded.");
			return true;
		}
		return false; 
	}

}