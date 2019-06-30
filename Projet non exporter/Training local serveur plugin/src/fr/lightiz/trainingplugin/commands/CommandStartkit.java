package fr.lightiz.trainingplugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandStartkit implements CommandExecutor
{	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
	{
		if(sender instanceof Player) 
		{
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("startkit")) 
			{
				player.sendMessage("§5Voici ton kit de départ");
				
				player.getInventory().addItem(new ItemStack(Material.WOOD, 32));
				player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE, 1));
				player.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));
								
				player.updateInventory();
				
				return true;
			}
		}
		return false;
	}
}
