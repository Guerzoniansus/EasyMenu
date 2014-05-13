package NomarTheHero;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Actions {
	
	EasyMenu plugin;
	Data data = new Data(plugin);
	
	private Messages messages = new Messages(plugin);
	
	public void checkCommand(Player player, String slot){
	String command = data.plugin.getConfig().getString("items."+slot+".command");
	if (command == "none"){
		messages.noCommand(player);
	}
	else{
		player.performCommand(command);
	}
	}
	
	
	public void menuAction0(Player player){
		if (checkPerm(player, "easymenu.use.1")){
			player.setGameMode(GameMode.SURVIVAL);
			messages.message0(player);
		}
		else return;
	}
	
	public void menuAction1(Player player){
		 if (checkPerm(player, "easymenu.use.2")){
			 player.setGameMode(GameMode.CREATIVE);
			 messages.message1(player);
		 }
		 else return;
	}
	
	public void menuAction2(Player player){
		if (checkPerm(player, "easymenu.use.3")){
			messages.message2(player);
			if (player.getWorld().getTime() >= 0 && player.getWorld().getTime() < 13000) player.getWorld().setTime(13000);
	    	else if (player.getWorld().getTime() >= 13000 && player.getWorld().getTime() < 24000) player.getWorld().setTime(0);
		}
		else return;
	}
	
	public void menuAction3(Player player){
		if (checkPerm(player, "easymenu.use.4")){
			messages.message3(player);
			if (player.getWorld().hasStorm() == true) player.getWorld().setStorm(false);
	    	else if (player.getWorld().isThundering() == true) player.getWorld().setThundering(false);
	    	else player.getWorld().setStorm(true);
		}
		else return;
	}
	
	public void menuAction4(Player player){
		if (checkPerm(player, "easymenu.use.5")){
			player.setHealth(player.getMaxHealth());
			player.setFoodLevel(20);
			player.setSaturation(20);
			messages.playerMessage(messages.message4, player);
		}
		else return;
	}
	
	public void menuAction5(Player player){
		if (checkPerm(player, "easymenu.use.6")){
			//Do stuff
			messages.playerMessage(messages.message5, player);
			player.performCommand(data.plugin.getConfig().getString("items.slot6.command"));
			//checkCommand(player, "slot6");
		}
		else return;
	}
	
	public void menuAction6(Player player){
		if (checkPerm(player, "easymenu.use.7")){
			//Do stuff
			messages.message6(player);
		}
		else return;
		
	}
		
	public void menuAction7(Player player){
		if (checkPerm(player, "easymenu.use.8")){
			//Do stuff
			messages.message7(player);
		}
		else return;
	}
		
	public void menuAction8(Player player){
		if (checkPerm(player, "easymenu.use.remove")){
			if (player.getInventory().contains(new Menu().createMenuItem())){
	    		player.getInventory().remove(new Menu().createMenuItem());
	    		messages.messageRemove(player);
	    	}
		}
		else return;
	}
	
	
	
	public boolean checkPerm(Player player, String perm){
		if (player.hasPermission(perm) || player.hasPermission("easymenu.use.*") || player.hasPermission("easymenu.*")) return true;		
		else {
			messages.noPerm(player);
			return false;
		}
	}
	
	

}
