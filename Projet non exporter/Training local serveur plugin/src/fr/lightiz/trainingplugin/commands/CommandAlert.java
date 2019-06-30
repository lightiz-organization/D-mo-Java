package fr.lightiz.trainingplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAlert implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
	{
		if(sender instanceof Player) 
		{
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("bc")) 
			{
				if(args.length == 0) 
				{
					player.sendMessage("La commande est : §c/bc §e<Message>");
				}
				
				if(args.length >= 1) 
				{
					StringBuilder bc = new StringBuilder();
					
					for(String part : args) 
					{
						bc.append(part + " ");
					}
					
					Bukkit.broadcastMessage("[§4§lBroadcast§f]§4 " + bc.toString());
				}
				return true;
			}
		}
		
		return false;
	}
	
}
