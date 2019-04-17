package me.xtrm.ForgeBase.management;

import me.xtrm.ForgeBase.management.impl.gui.GuiManager;
import me.xtrm.ForgeBase.management.impl.module.ModuleManager;

public class MasterManager {

	public ModuleManager moduleManager;
	public GuiManager guiManager;
	
	public MasterManager() {
		moduleManager = new ModuleManager();
		guiManager = new GuiManager();
	}
	
	public void preInit() {
		
	}
	
	public void init() {
		moduleManager.init();
	}
	
	public void postInit() {
		
	}

}
