package me.blha303;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
// The listener originally pulled the messages from config.yml, like
// Ouch.java. Sadly, I could never get that to work. If you do, please
// submit it as a pull request. If not, modify this file and recompile
// if you want to localize this part of the plugin.
public class myListener implements Listener{
	
    @EventHandler
	public void blockBreak(BlockBreakEvent event){
        Player p = event.getPlayer();
        if(p.hasPermission("ouch.break")){
		    p.sendMessage("Ouch.");
        }else{
        	exit();
        }
    }
	@EventHandler
	public void blockPlace(BlockPlaceEvent event){
		String b = event.getBlockPlaced().getType().toString().toLowerCase();
		Player p = event.getPlayer();
		if(p.hasPermission("ouch.place")){
		    p.sendMessage("Ahhhhh....." + b + "!");
		}else{
			exit();
		}
	}
	private boolean exit() {
		return false;
		
	}
}
