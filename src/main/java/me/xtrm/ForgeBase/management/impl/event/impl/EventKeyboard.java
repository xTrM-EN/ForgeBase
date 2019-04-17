package me.xtrm.ForgeBase.management.impl.event.impl;

import me.xtrm.ForgeBase.management.impl.event.eventbus.events.Event;

public class EventKeyboard implements Event {

	private int key;
	
	public EventKeyboard(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return this.key;
	}
	
}
