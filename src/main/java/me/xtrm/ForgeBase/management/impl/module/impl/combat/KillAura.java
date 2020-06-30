package me.xtrm.ForgeBase.management.impl.module.impl.combat;

import org.lwjgl.input.Keyboard;

import me.xtrm.ForgeBase.management.impl.event.eventbus.EventTarget;
import me.xtrm.ForgeBase.management.impl.event.impl.EventUpdate;
import me.xtrm.ForgeBase.management.impl.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;

public class KillAura extends Module {

	public KillAura() {
		super("KillAura", Keyboard.KEY_R, Category.Combat);
	}

	@EventTarget
	public void onUpdate(EventUpdate event) {
		try {
			for(Object o : mc.theWorld.loadedEntityList) {
				if(o instanceof EntityLivingBase) {
					EntityLivingBase entityLivingBase = (EntityLivingBase)o;
					if(entityLivingBase != null && entityLivingBase != mc.thePlayer && entityLivingBase.isEntityAlive() && !entityLivingBase.isEntityInvulnerable()) {
						if(entityLivingBase.getDistanceToEntity(mc.thePlayer) < 6F) {
							mc.thePlayer.swingItem();
							mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(entityLivingBase, Action.ATTACK));
						}
					}
				}
			}			
		} catch(Exception e) {}
	}
	
}
