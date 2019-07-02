package fr.lightiz.trainingplugin;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PluginListener implements Listener
{
	@EventHandler
	public void onJoin(PlayerJoinEvent joinEvent) 
	{
		Player player = joinEvent.getPlayer();
		
		ItemStack compass = new ItemStack(Material.COMPASS, 1);
		ItemMeta compassMeta = compass.getItemMeta();
		compassMeta.setDisplayName("§cJesus's Object");
		compassMeta.setLore(Arrays.asList("The object of Jesus !", "§cThis a trash can too ^^'"));
		compassMeta.addEnchant(Enchantment.DAMAGE_ALL, 50, true);
		compass.setItemMeta(compassMeta);
		
		player.getInventory().clear();
		player.getInventory().remove(Material.COMPASS);
		player.getInventory().addItem(compass);
		
		player.sendMessage("§cBievenue sur le serveur de test, " + player.getName() + "!");

	}
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onInterract(PlayerInteractEvent interractEvent) 
	{
		Player player = interractEvent.getPlayer();
		Action interract = interractEvent.getAction();		
		ItemStack inventoryContainers = interractEvent.getItem();
		
		Inventory inv = Bukkit.createInventory(null, 54, ("§2BIG §cTRASH CAN "));
		
		if(interractEvent.getClickedBlock() != null && interract == Action.RIGHT_CLICK_BLOCK) 
		{
			BlockState bs = interractEvent.getClickedBlock().getState();
			if(bs instanceof Sign) 
			{
				Sign sign = (Sign) bs;
				
				if(sign.getLine(0).equalsIgnoreCase("Click on me") 
				   && (sign.getLine(3).equalsIgnoreCase("Warning")))
				{
					 player.playEffect(EntityEffect.DEATH);
				}
			}
		}
		
		if(interractEvent.getClickedBlock() != null && interract == Action.RIGHT_CLICK_BLOCK) 
		{
			BlockState bs = interractEvent.getClickedBlock().getState();
			if(bs instanceof Sign) 
			{
				Sign sign = (Sign) bs;
				
				if(sign.getLine(1).equalsIgnoreCase("Give"))				   
				{
					 Bukkit.getWorld("world").dropItem(player.getLocation(), new ItemStack(Material.DIAMOND));
				}
			}
		}
		
		if(inventoryContainers == null) 
		{
			return;
		}
		
		if(inventoryContainers.getType() == Material.COMPASS 
		  && inventoryContainers.hasItemMeta()
		  && inventoryContainers.getItemMeta().hasDisplayName() 
		  && inventoryContainers.getItemMeta().getDisplayName().equalsIgnoreCase("§cJesus's Object") 
		  && interract == interract.RIGHT_CLICK_AIR) 
		{
			player.openInventory(inv);
		}
	}
}
