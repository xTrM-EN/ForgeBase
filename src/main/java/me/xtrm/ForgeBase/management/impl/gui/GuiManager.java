package me.xtrm.ForgeBase.management.impl.gui;

import me.xtrm.ForgeBase.management.impl.event.eventbus.EventManager;
import me.xtrm.ForgeBase.management.impl.event.eventbus.EventTarget;
import me.xtrm.ForgeBase.management.impl.event.impl.EventGuiOpen;
import me.xtrm.ForgeBase.management.impl.gui.impl.overrides.CMainMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;

/**
 * Manager in charge of overriding GUIs
 */
public class GuiManager {
	
	public GuiManager() {
		EventManager.register(this);
	}
	
	@EventTarget
	public void onGui(EventGuiOpen event) {
		GuiScreen gui = event.getGui();
		
		// If the gui is the main menu
		if(gui instanceof GuiMainMenu) {
			// If the gui isn't the Custom MainMenu
			// (because CMainMenu extends from GuiMainMenu)
			if(!(gui instanceof CMainMenu)) {
				// Display CustomMainMenu
				event.setGui(new CMainMenu());
			}
		}
	}
}
