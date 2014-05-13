package NomarTheHero;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {
	
	EasyMenu plugin;
	private Messages messages = new Messages(plugin);

	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player player = (Player)e.getWhoClicked();
		int slot = e.getRawSlot();
		ItemStack curritem = e.getCurrentItem();
		ItemStack cursoritem = e.getCursor();
		ClickType click = e.getClick();
		
		if (new Menu().check(player, curritem, cursoritem) == true){
			if (click != ClickType.LEFT && click != ClickType.CREATIVE){
				e.setCancelled(true);
			}
			
			else {
				e.setCancelled(true);
				player.closeInventory();
				player.openInventory(Menu.menu);
			}
		}
		
		if (e.getInventory().getTitle().equals(Menu.menu.getTitle())){
			e.setCancelled(true);
			new Menu().doActions(player, slot);

		}
	}
	

	
	

}
