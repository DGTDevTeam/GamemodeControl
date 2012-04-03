package me.JamieSinn.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class GamemodeControl extends JavaPlugin
{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static GamemodeControl Plugin;
	@Override
	public void onDisable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
		
	}
	@Override
	public void onEnable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() +  " Has Been Successfully Enabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player player = (Player) sender;
	
		
		if(commandLabel.equalsIgnoreCase("c"))
		{
		
			if(player.hasPermission("GamemodeControl.self.creative"))
			{
				

				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage(ChatColor.DARK_GRAY + "[GameModeControl]"+ ChatColor.DARK_BLUE +" You are in Creative Mode!");

			}
		
		
			else
			{
				player.sendMessage(ChatColor.DARK_RED + "You do not have the permission");
			}
			

		}
		if(commandLabel.equalsIgnoreCase("s"))
		{
					if(player.hasPermission("GamemodeControl.self.survival"))
					{
						player.setGameMode(GameMode.SURVIVAL);
						player.sendMessage(ChatColor.DARK_BLUE + "[GameModeControl]"+ ChatColor.DARK_GRAY +" You are in Survival Mode!");
					}
						else
						{
							player.sendMessage(ChatColor.DARK_RED + "You do not have the permission");
						}
					return false;
		}
	
		
	
	if(commandLabel.equalsIgnoreCase("gamemodehelp"))
	{
				if(player.hasPermission("GamemodeControl.help"))
				{
					player.sendMessage(ChatColor.DARK_BLUE + "[GameModeControl]"+ ChatColor.DARK_GRAY +" Help Page");
					player.sendMessage(ChatColor.DARK_BLUE + "/s:" + ChatColor.DARK_GRAY + " Change your gamemode to Survival");
					player.sendMessage(ChatColor.DARK_BLUE + "/c:" + ChatColor.DARK_GRAY + " Change your gamemode to Creative");
					player.sendMessage(ChatColor.DARK_BLUE + "/gamemodehelp" + ChatColor.DARK_GRAY + "Shows this screen");
							
				}
					else
					{
						player.sendMessage(ChatColor.DARK_RED + "You do not have the permission");
					}
				return false;
	}
	return false;
	
	
}
}
