package fr.lightiz.trainingplugin.tasks;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable
{
	private int timer = 10;
	
	@Override
	public void run()
	{	
		Bukkit.broadcastMessage("Il y a " + timer + "s d'écouler !");
		
		if(timer == 0) 
		{
			Bukkit.broadcastMessage("Le timer est à 10 !");
			cancel();
		}
		
		timer--;
	}
}
