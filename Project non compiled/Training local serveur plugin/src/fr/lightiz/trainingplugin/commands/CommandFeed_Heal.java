package fr.lightiz.trainingplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFeed_Heal implements CommandExecutor
{
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
	{
		if(sender instanceof Player) 
		{
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("feed")) 
			{	
				player.setFoodLevel(20);
				
				player.updateInventory();
				
				player.sendMessage("Vous avez été rassasier");
				
				return true;
			}
			
			if(sender instanceof Player) 
			{
				Player player1 = (Player)sender;
			
				if(cmd.getName().equalsIgnoreCase("heal")) 
				{			
					player1.setHealth(20);
					player1.updateInventory();
					
					player1.sendMessage("Votre santé est au maximum");
					
					return true;
				}
			}	
		}
		
		return false;
	}
}
