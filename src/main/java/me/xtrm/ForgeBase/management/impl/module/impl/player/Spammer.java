package me.xtrm.ForgeBase.management.impl.module.impl.player;

import java.util.Random;

import org.lwjgl.input.Keyboard;

import me.xtrm.ForgeBase.management.impl.event.eventbus.EventTarget;
import me.xtrm.ForgeBase.management.impl.event.impl.EventUpdate;
import me.xtrm.ForgeBase.management.impl.module.Module;
import me.xtrm.ForgeBase.utils.Refs;
import me.xtrm.ForgeBase.utils.TimeHelper;
import net.minecraft.network.play.client.C01PacketChatMessage;

public class Spammer extends Module {
	
	public Spammer() {
		super("Spammer", Keyboard.KEY_K, Category.Player);
	}
	
	private TimeHelper timer = new TimeHelper();
	
	@EventTarget
	public void onUpdate(EventUpdate e) {
		if(!timer.hasReached(3050))
			return;
		timer.reset();
		
		boolean antiSpamBypass = true;
		
		String message = String.format("ForgeBase v%s by xTrM_", Refs.VER);
		
		if(antiSpamBypass) {			
			message = message + " [" + (new Random().nextInt(1000000)) + "]";
		}
		
		mc.thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(message));
	}

}
