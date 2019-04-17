package me.xtrm.ForgeBase.management.impl.module.impl.movement;

import org.lwjgl.input.Keyboard;

import me.xtrm.ForgeBase.management.impl.event.eventbus.EventTarget;
import me.xtrm.ForgeBase.management.impl.event.impl.EventUpdate;
import me.xtrm.ForgeBase.management.impl.module.Module;
import me.xtrm.ForgeBase.utils.MovementUtils;

public class Speed extends Module {
	
	public Speed() {
		super("Speed", Keyboard.KEY_M, Category.Movement);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate e) {
		MovementUtils.setSpeed(0);
		if(MovementUtils.isMoving())
			MovementUtils.setSpeed(1);
	}

}
