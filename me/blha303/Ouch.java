package me.blha303;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Ouch extends JavaPlugin {
	
	
	
	public static Ouch plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onDisable() {
		this.logger.info(this.getDescription().getName() + " " + getConfig().getString("disable"));
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new myListener(), this);
		this.saveConfig();
		this.logger.info("[" + this.getDescription().getName() + "]" + " " + getConfig().getString("enable"));
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