package fr.lightiz.trainingplugin.tasks;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable
{
	private int timer = 0;

	@Override
	public void run()
	{	
		Bukkit.broadcastMessage("Il y a " + timer + "s d'�couler !");
		
		if(timer == 10) 
		{
			Bukkit.broadcastMessage("Le timer est � 10 !");
			cancel();
		}

		timer++;
	}
}
