package me.blha303;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Ouch extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
    @EventHandler
	public void blockBreak(BlockBreakEvent event){
        if(event.getPlayer().hasPermission("ouch.break")){
        	event.getPlayer().sendMessage("Ouch.");
        }
    }
	@EventHandler
	public void blockPlace(BlockPlaceEvent event){
		if(event.getPlayer().hasPermission("ouch.place")){
			event.getPlayer().sendMessage("Ahhhhh....." + event.getBlockPlaced().getType().toString().toLowerCase() + "!");
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		boolean allowuse = false;
		if (sender.hasPermission("ouch.command")) {
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
				}
			}
			return false;
		} else {
			sender.sendMessage(ChatColor.RED + "You can't use this command.");
			return true;
		}
	}
}