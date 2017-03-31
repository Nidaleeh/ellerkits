package me.ekits.listeners;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ekits.abilities.Wolf;
import me.ekits.main.Main;

public class PlayerListeners implements Listener{
	
	Main plugin;
	public PlayerListeners(Main instance) {
		this.plugin = instance;
	}
	HashMap<Player, Integer> cache = new HashMap<Player, Integer>();
	
	//When player joins the server
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		String pname = p.getName();
		p.setHealth(0.0);
		p.getInventory().clear();
		Bukkit.broadcastMessage("" + ChatColor.AQUA + ChatColor.BOLD + pname + ChatColor.RESET + ChatColor.GOLD + " has joined the server!");
        //
		ItemStack Ninjasword = new ItemStack(Material.PAPER);
		ItemMeta sm = Ninjasword.getItemMeta();
		sm.setDisplayName("" + ChatColor.GOLD + "Pick a Kit!");
		Ninjasword.setItemMeta(sm);
		//
		if(!(p.getInventory().contains(Ninjasword))){
		p.getInventory().addItem(Ninjasword);
		//
	}
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		String pname = p.getName();
		e.getDrops().clear();
		e.setDeathMessage("" + ChatColor.GREEN + pname + ChatColor.AQUA + " was killed by " + ChatColor.RED + p.getKiller());
		if(p.getKiller() == null){
			e.setDeathMessage("" + ChatColor.GREEN + pname + ChatColor.AQUA + " got rekt by an " + ChatColor.DARK_RED + ChatColor.BOLD + "ADMIN");
			if(plugin.tamedwolf.contains(p.getName())){
				for(Entity wolf : Bukkit.getServer().getWorld(p.getWorld().getName()).getEntities()){
					Wolf wolf = (Wolf) p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
					wolf.setOwner(p);
					
							
						
					}
				}
			}
		}
		plugin.kitused.remove(p.getName());
		plugin.assassin2.remove(p.getName());
		plugin.assassin.remove(p.getName());
		plugin.thor.remove(p.getName());
		plugin.ender.remove(p.getName());
		plugin.ninja.remove(p.getName());
		plugin.ninja2.remove(p.getName());
		plugin.heal.remove(p.getName());
		plugin.wolf.remove(p.getName());
		plugin.chameleon.remove(p.getName());
		plugin.water.remove(p.getName());
		plugin.lava.remove(p.getName());
		plugin.viper.remove(p.getName());
		plugin.rteleport.remove(p.getName());
		plugin.djump.remove(p.getName());
		plugin.switcher.remove(p.getName());
		plugin.regen.remove(p.getName());
		plugin.phantom.remove(p.getName());
		plugin.hit.remove(p.getName());
		plugin.tamedwolf.remove(p.getName());
		}
	@EventHandler
	public void onSpawn(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		p.sendMessage("" + ChatColor.GOLD + "Choose a kit to fight!");
        //
		ItemStack Ninjasword = new ItemStack(Material.PAPER);
		ItemMeta sm = Ninjasword.getItemMeta();
		sm.setDisplayName("" + ChatColor.GOLD + "Pick a Kit!");
		Ninjasword.setItemMeta(sm);
		//
		if(!(p.getInventory().contains(Ninjasword))){
		p.getInventory().addItem(Ninjasword);
	}
	}
	@EventHandler
	public void onBlockIgnite(BlockIgniteEvent event) {
	    if (event.getCause() == IgniteCause.LIGHTNING) {
	        event.setCancelled(true);
	    }
	}
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		e.getItemDrop().remove();
		if(!(e.getItemDrop().getItemStack().getType() == (Material.BOWL))){
			e.getPlayer().sendMessage("" + ChatColor.RED + ChatColor.BOLD	 + "Sorry," + ChatColor.YELLOW + ChatColor.ITALIC + " but you " + ChatColor.YELLOW + ChatColor.UNDERLINE + "can't" + ChatColor.YELLOW + ChatColor.ITALIC + " drop this.");
			e.setCancelled(true);
		}
		}
	    @EventHandler
	    
	    public void kill(PlayerDeathEvent event) {
	        if (event.getEntity() instanceof Player) {
	            Player killer = event.getEntity().getKiller();
	            if (cache.containsKey(killer)) {
	                cache.put(killer, cache.get(killer) + 1);
	                if (cache.get(killer) == 3)
	                    Bukkit.broadcastMessage(
	                            ChatColor.GOLD.toString() + ChatColor.BOLD + killer.getName() + " has a 3 KillStreak! ");
	                if (cache.get(killer) == 5)
	                    Bukkit.broadcastMessage(
	                            ChatColor.GOLD.toString() + ChatColor.BOLD + killer.getName() + " has a 5 KillStreak! ");
	                if (cache.get(killer) == 7)
	                    Bukkit.broadcastMessage(
	                            ChatColor.GOLD.toString() + ChatColor.BOLD + killer.getName() + " has a 7 KillStreak! ");
	                if (cache.get(killer) == 9)
	                    Bukkit.broadcastMessage(
	                            ChatColor.GOLD.toString() + ChatColor.BOLD + killer.getName() + " has a 9 KillStreak! ");
	                if (cache.get(killer) == 11)
	                    Bukkit.broadcastMessage(
	                            ChatColor.GOLD.toString() + ChatColor.BOLD + killer.getName() + " has a 11 KillStreak! ");
	            } else {
	                cache.put(killer, 1);
	            }
	        }
	    }
	 
	    @EventHandler
	    public void death(PlayerDeathEvent event) {
	        if (event.getEntity() instanceof Player) {
	            Player player = event.getEntity();
	            if (cache.containsKey(player)) {
	                cache.remove(player);
	                
	               
	            }
	        }
	}
}


