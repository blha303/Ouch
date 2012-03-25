package cc.co.blha303.Ouch;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class Ouch extends JavaPlugin {
	
	public static Ouch plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		this.logger.info(this.getDescription().getName() + " is now disabled.");
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		getServer().getPluginManager().registerEvents(new myListener(), this);
		this.logger.info("[" + this.getDescription().getName() + "]" + " Enabled.");
	}

}