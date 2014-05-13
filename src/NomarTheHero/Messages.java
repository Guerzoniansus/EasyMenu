package NomarTheHero;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages {
	
	EasyMenu plugin;
	
	public Messages(EasyMenu instance) {
	plugin = instance;
	}
	
	ArrayList<String> lines = new ArrayList<String>();
	
	public void playerMessage(String string, Player player){
		if (string == "none") return;
		else player.sendMessage(string);
	}
	
	public void message0(Player player){
		player.sendMessage(ChatColor.GOLD + "Set to Gamemode Survival");
	}
	
	public void message1(Player player){
		player.sendMessage(ChatColor.GOLD + "Set to Gamemode Creative");
	}
	
	public void message2(Player player){
		player.sendMessage(ChatColor.GOLD + "Toggled time");
	}
	
	public void message3(Player player){
		player.sendMessage(ChatColor.GOLD + "Toggled weather");
	}
	
	public String message4 = ChatColor.translateAlternateColorCodes('%', plugin.getConfig().getString("items.slot5.message"));

	public String message5 = ChatColor.translateAlternateColorCodes('%', plugin.getConfig().getString("items.slot6.message"));
	
	public void message6(Player player){
		player.sendMessage(ChatColor.GOLD + "");
	}
	
	public void message7(Player player){
		player.sendMessage(ChatColor.GOLD + "");
	}
	
	public void messageRemove(Player player){
		player.sendMessage(ChatColor.DARK_RED + "Removed Menu Item!");
	}
	
	public void receiveMenu(Player player){
		player.sendMessage(ChatColor.GOLD + "Received Menu!");
	}
	
	public void noPerm(Player player){
		player.sendMessage(ChatColor.DARK_RED + "You don't have permission");
	}
	
	public void tooManyArguments(Player player){
		player.sendMessage(ChatColor.DARK_RED + "Error: Too many arguments");
	}
	
	public void alreadyHave(Player player){
		player.sendMessage(ChatColor.DARK_RED + "You already have a menu item!");
	}
	
	public void noCommand(Player player){
		player.sendMessage(ChatColor.DARK_RED + "There is no configured command!");
	}
	
	


	

}
