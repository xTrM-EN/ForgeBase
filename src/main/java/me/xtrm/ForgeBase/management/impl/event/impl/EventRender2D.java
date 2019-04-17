package me.xtrm.ForgeBase.management.impl.event.impl;

import me.xtrm.ForgeBase.management.impl.event.eventbus.events.Event;

public class EventRender2D implements Event {
	
	private float partialTicks;
	
	public EventRender2D(float partialTicks) {
		this.partialTicks = partialTicks;
	}
	
	public float getPartialTicks() {
		return this.partialTicks;
	}

}
