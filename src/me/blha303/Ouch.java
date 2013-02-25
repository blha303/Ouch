package me.blha303;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Ouch extends JavaPlugin implements Listener {
	
	public final Logger logger = this.getLogger();
	
	@Override
	public void onDisable() {
		logger.info(String.format("%s %s", getConfig().getString("disable"), getDescription().getVersion()));
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().addDefault("enable", "Enabled version");
		getConfig().addDefault("disable", "Disabled version");
		getConfig().options().copyDefaults(true);
		saveConfig();
		logger.info(String.format("%s %s", getConfig().getString("enable"), getDescription().getVersion()));
	}
	
    @EventHandler
	public void blockBreak(BlockBreakEvent event){
        Player p = event.getPlayer();
        if(p.hasPermission("ouch.break")){
		    p.sendMessage("Ouch.");
        }else{
        	return;
        }
    }
	@EventHandler
	public void blockPlace(BlockPlaceEvent event){
		Player p = event.getPlayer();
		if(p.hasPermission("ouch.place")){
		    p.sendMessage("Ahhhhh....." + event.getBlockPlaced().getType().toString().toLowerCase() + "!");
		}else{
			return;
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		boolean allowuse = false;
		if (sender instanceof Player) {
			if (((Player)sender).hasPermission("ouch.command")) {
				allowuse = true;
			}
		} else {
			allowuse = true;
		}
		if (allowuse) {
			if (args.length == 1) {
				if (args[0] == "on") {
					if (getServer().getPluginManager().getPlugin(getDescription().getName()) == null) {
						getServer().getPluginManager().enablePlugin(this);
					} else {
						sender.sendMessage("Plugin already enabled.");
					}
					return true;
				} else if (args[0] == "off") {
					if (getServer().getPluginManager().getPlugin(getDescription().getName()) != null) {
						getServer().getPluginManager().enablePlugin(this);
					} else {
						sender.sendMessage("Plugin already disabled.");
					}
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You can't use this command.");
			return true;
		}
	}
}