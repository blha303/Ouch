package me.blha303;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
// Messages in this part of the plugin can be modified in 
// config.yml (with the exception of the Loading message).
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
		this.getConfig().options().copyDefaults(true);
		saveConfig();
		this.logger.info("[" + this.getDescription().getName() + "]" + " " + getConfig().getString("lang.enable"));
	}

}