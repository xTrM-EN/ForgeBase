package me.xtrm.ForgeBase.management.impl.event.impl;

import me.xtrm.ForgeBase.management.impl.event.eventbus.events.Event;
import net.minecraft.client.gui.GuiScreen;

public class EventGuiOpen implements Event {
	
	private GuiScreen gui;
	
	public EventGuiOpen(GuiScreen gui) {
		this.gui = gui;
	}
	
	public GuiScreen getGui() {
		return this.gui;
	}
	
	public void setGui(GuiScreen set) {
		this.gui = set;
	}

}
