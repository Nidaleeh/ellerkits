package me.ekits.kits;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import me.ekits.main.Main;

public class LavaHound implements CommandExecutor{
	
	Main plugin;
	public LavaHound(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Soldier Kit
		if(cmd.getName().equalsIgnoreCase("Lavahound") && sender instanceof Player){
			
			Player p = (Player) sender;
			
			if(!sender.hasPermission("ekits.mvp")) {
                sender.sendMessage(ChatColor.RED + "You are not permitted to do this!");
                return true;
        }
			
			ItemStack soldiersword = new ItemStack(Material.IRON_SWORD);
			ItemMeta sm = soldiersword.getItemMeta();
			sm.setDisplayName("" + ChatColor.GOLD + "Lavahound Sword");
			soldiersword.setItemMeta(sm);
			//Dyed Armor
			ItemStack lhelm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta hmeta = (LeatherArmorMeta) lhelm.getItemMeta();
			hmeta.setColor(Color.RED);	
			hmeta.addEnchant(Enchantment.DURABILITY, 1, true);
			hmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
			lhelm.setItemMeta(hmeta);
			// Chest
			ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta cmeta = (LeatherArmorMeta) lchest.getItemMeta();
			cmeta.setColor(Color.RED);	
			cmeta.addEnchant(Enchantment.DURABILITY, 1, true);
			cmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
			lchest.setItemMeta(cmeta);
			
			ItemStack llegs = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta lmeta = (LeatherArmorMeta) llegs.getItemMeta();
			lmeta.setColor(Color.RED);	
			lmeta.addEnchant(Enchantment.DURABILITY, 1, true);
			lmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
			llegs.setItemMeta(lmeta);
			
			ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bmeta = (LeatherArmorMeta) lboots.getItemMeta();
			bmeta.setColor(Color.RED);	
			bmeta.addEnchant(Enchantment.DURABILITY, 1, true);
			bmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
			lboots.setItemMeta(bmeta);
			
			plugin.lava.add(p.getName());
			p.getInventory().clear();
			p.setMaxHealth(20);
	        p.setHealth(20);
			p.getInventory().addItem(soldiersword);
			p.getInventory().setHelmet(lhelm);
			p.getInventory().setChestplate(lchest);
			p.getInventory().setLeggings(llegs);
			p.getInventory().setBoots(lboots);
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			p.sendMessage(ChatColor.GOLD + "You have obtained the" + ChatColor.GREEN + " Lavahound " + ChatColor.GOLD + "kit!");
		}
		
		
		return false;
}


}

