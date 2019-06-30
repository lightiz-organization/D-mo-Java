package fr.lightiz.trainingplugin;

import org.bukkit.plugin.java.JavaPlugin;

import fr.lightiz.trainingplugin.commands.CommandAlert;
import fr.lightiz.trainingplugin.commands.CommandFeed_Heal;
import fr.lightiz.trainingplugin.commands.CommandStartkit;
import fr.lightiz.trainingplugin.tasks.Timer;

public class Main extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		System.out.println("The plugin went to set ON !");
		getCommand("startkit").setExecutor(new CommandStartkit());
		getCommand("bc").setExecutor(new CommandAlert());
		getCommand("feed").setExecutor(new CommandFeed_Heal());
		getCommand("heal").setExecutor(new CommandFeed_Heal());
		
		getServer().getPluginManager().registerEvents(new PluginListener(), this);
				
		Timer timer = new Timer();
		timer.runTaskTimer(this, 0, 20);
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("The plugin went to set OFF");
	}
}
