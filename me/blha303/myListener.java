package me.blha303;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class myListener implements Listener{

	@EventHandler
	public void blockBreak(BlockBreakEvent event){
		Player p = event.getPlayer();
		p.sendMessage("Ouch.");
	}
	@EventHandler
	public void blockPlace(BlockPlaceEvent event){
		String b = event.getBlockPlaced().getType().toString().toLowerCase();
		Player p = event.getPlayer();
		p.sendMessage("Ahhhhh....." + b + "!");
	}
}
