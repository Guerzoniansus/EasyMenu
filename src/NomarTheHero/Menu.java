package NomarTheHero;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Menu {
	
	public static Inventory menu = Bukkit.createInventory(null, 9, "Easy Menu");
	Actions actions = new Actions();


    public ItemStack createMenuItem(){
        ItemStack itemstack = new ItemStack(Material.CHEST, 1); 
        ItemMeta itemstackMeta = itemstack.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GREEN + "Open Menu");
        itemstackMeta.setDisplayName(ChatColor.RED + "Menu");
        itemstackMeta.setLore(lore);
        itemstack.setItemMeta(itemstackMeta);
        return itemstack;
        
    }
    
    public void doActions(Player player, int slot){
    	//When config stuff make it so it reads slot "1" and "2" etc
    	//PERMS for clicking a specific slot
    	switch (slot){
    	case 0: actions.menuAction0(player); break;
    	case 1: actions.menuAction1(player); break;
    	case 2: actions.menuAction2(player); break;
    	case 3: actions.menuAction3(player); break;	
    	case 4: actions.menuAction4(player); break;
    	case 5: actions.menuAction5(player); break;
    	case 8: actions.menuAction8(player); break;
    	default: return;
    	}
    	
    }
    

    
	public boolean check(Player player, ItemStack curritem, ItemStack cursoritem){
		if (!player.getOpenInventory().getTopInventory().equals(menu)){
			if (curritem == null || cursoritem == null){
				return false;
			}
			else if (curritem.getType() == Material.CHEST|| cursoritem.getType() == Material.CHEST){
				if (curritem.hasItemMeta() || cursoritem.hasItemMeta()){
				if (curritem.getItemMeta().getDisplayName().matches(ChatColor.RED + "Menu") 
				||cursoritem.getItemMeta().getDisplayName().matches(ChatColor.RED + "Menu")){
					if (curritem.getItemMeta().getLore().get(0).matches(ChatColor.GREEN + "Open Menu") 
					||cursoritem.getItemMeta().getLore().get(0).matches(ChatColor.GREEN + "Open Menu")){
						return true;	 
					}
					else return false;
					}
				else return false;
				}
				else return false;
			}
			else return false;
			}
		else return false;
	}
	
		

    


}
