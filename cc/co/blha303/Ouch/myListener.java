package cc.co.blha303.Ouch;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;
import cc.co.blha303.Ouch;

public class myListener implements Listener{
	
	@EventHandler
	public void blockBreak(BlockBreakEvent event){
		Player p = event.getPlayer();
		p.sendMessage("Ouch.");
		Ouch.getServer().getConsoleSender().sendMessage("Ouch.");
	}
	@EventHandler
	public void blockPlace(BlockPlaceEvent event){
		Player p = event.getPlayer();
		p.sendMessage("Ahhhhh.....");
		Ouch.getServer().getConsoleSender().sendMessage("Ahhhhh.....");
	}
	private Ouch plugin; 
	public myListener(Ouch instance) { 
		this.plugin = instance; 
	}
}
