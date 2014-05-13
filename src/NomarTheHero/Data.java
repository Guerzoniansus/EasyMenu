package NomarTheHero;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Data {
	
	EasyMenu plugin;
	
	public Data(EasyMenu instance) {
	plugin = instance;
	}
	
	
	
    public void addContents(){
    	//Todo: Make config stuff to add chosen contents, names, lores, items..
    	ItemStack i0 = new ItemStack(Material.GRASS);
    	ItemStack i1 = new ItemStack(Material.GOLD_BLOCK);
    	ItemStack i2 = new ItemStack(Material.WATCH);
    	ItemStack i3 = new ItemStack(Material.WATER_LILY);
    	ItemStack i4 = new ItemStack(Material.matchMaterial(plugin.getConfig().getString("items.slot5.type")));
    	
    	ItemStack i5 = new ItemStack(Material.matchMaterial(plugin.getConfig().getString("items.slot6.type")));
    	
    	ItemStack i8 = new ItemStack(Material.TNT);
    	addData(i0, i1, i2, i3, i4, i5, i8);

    	Menu.menu.setItem(0, i0);
    	Menu.menu.setItem(1, i1);
    	Menu.menu.setItem(2, i2);
    	Menu.menu.setItem(3, i3);
    	Menu.menu.setItem(4, i4);
    	Menu.menu.setItem(5, i5);
    	Menu.menu.setItem(8, i8);
    	
    }
    
    public void addData(ItemStack i0, ItemStack i1, ItemStack i2, ItemStack i3, ItemStack i4, ItemStack i5, ItemStack i8){
    	ItemMeta m0 = i0.getItemMeta();
    	ItemMeta m1 = i1.getItemMeta();
    	ItemMeta m2 = i2.getItemMeta();
    	ItemMeta m3 = i3.getItemMeta();
    	ItemMeta m4 = i4.getItemMeta();
    	ItemMeta m5 = i5.getItemMeta();
    	ItemMeta m8 = i8.getItemMeta();
    	
    	m0.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Survival Mode");
    	m1.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Creative Mode");
    	m2.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Toggle Day / Night");
    	m3.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Toggle Weather");
    	
    	m4.setDisplayName(ChatColor.translateAlternateColorCodes('%', plugin.getConfig().getString("items.slot5.name")));
    	m5.setDisplayName(ChatColor.translateAlternateColorCodes('%', plugin.getConfig().getString("items.slot6.name")));
    	
    	m8.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Remove Menu");
    	
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GOLD + "Easy Menu plugin by:");
        lore.add(ChatColor.GOLD + "NomarTheHero");
    	m8.setLore(lore);

    	i0.setItemMeta(m0);
    	i1.setItemMeta(m1);
    	i2.setItemMeta(m2);
    	i3.setItemMeta(m3);
    	i4.setItemMeta(m4);
    	i5.setItemMeta(m5);
    	i8.setItemMeta(m8);
    }
	


}
