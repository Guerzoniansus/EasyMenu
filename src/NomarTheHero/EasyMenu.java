package NomarTheHero;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class EasyMenu extends JavaPlugin{
	
	/*
	 * TODO:
	 * Permission per slot
	 * Configurable item colors etc
	 * Messages when clicked and get menu + configurable
	 * 
	 * TRY CONFIG COMMAND WITH PLAYER.CHAT
	 * SOUNDS WHEN CLICKED
	 */
	
    public void onEnable(){
    	loadConfig();
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        new Data(this).addContents();
        new Menu().createMenuItem();
        
    }
    
    
	private Messages messages = new Messages(this);
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("Menu")){
			if ((sender instanceof Player)){
			Player player = (Player)sender;
			if (args.length == 0){
				player.openInventory(Menu.menu);
				return true;
			}
			else if (args.length == 1){
				if (args[0].equalsIgnoreCase("get")){
					if (player.hasPermission("easymenu.get") || player.hasPermission("easymenu.*")){
						if (!player.getInventory().contains(new Menu().createMenuItem())){
							player.getInventory().setItem(9, new Menu().createMenuItem());
							messages.receiveMenu(player);
							return true;
						}
						else messages.alreadyHave(player);
					}
					else messages.noPerm(player);	
				}
				else if (args[0].equalsIgnoreCase("reload")){
					if (player.hasPermission("easymenu.reload") || player.hasPermission("easymenu.*")){
				    	loadConfig();
				        new Data(this).addContents();
				        new Menu().createMenuItem();
				        player.sendMessage("Reloaded configuration!");
					}
					else messages.noPerm(player);
				}
			}
			else messages.tooManyArguments(player);
		}
		}
		return false;
	}
    
    
    
    
    public void onDisable() {
    }
    
    public void loadConfig(){    
    	final FileConfiguration config = this.getConfig();
    	this.saveDefaultConfig();     	
    }

    
    /*
     * Permissions:
     * easymenu.open - /Menu
     * easymenu.get - /menu get
     * easymenu.use.* - Use all slots
     * easymenu.use.# - Use specific slot
     * easymenu.* - All permissions, all slots
     * 
     */
    


}
