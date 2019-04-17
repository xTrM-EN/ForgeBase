package me.xtrm.ForgeBase.management.impl.module.impl.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.lwjgl.opengl.GL11;

import me.xtrm.ForgeBase.ForgeBase;
import me.xtrm.ForgeBase.management.impl.event.eventbus.EventTarget;
import me.xtrm.ForgeBase.management.impl.event.impl.EventRender2D;
import me.xtrm.ForgeBase.management.impl.module.Module;
import me.xtrm.ForgeBase.utils.Refs;
import me.xtrm.ForgeBase.utils.Wrapper;
import net.minecraft.client.gui.ScaledResolution;

public class HUD extends Module {
	
	public HUD() {
		super("HUD", Category.Render, true);
	}
	
	@EventTarget
	public void onRender2D(EventRender2D e) {
		drawWatermark();
		drawArraylist();
	}
	
	public void drawWatermark() {
		GL11.glPushMatrix();
		{
			GL11.glScalef(2, 2, 2);
			fr.drawStringWithShadow(Refs.NAME, 1, 1, -1);
			GL11.glScalef(0.5f, 0.5f, 0.5f);
			fr.drawStringWithShadow("v" + Refs.VER, fr.getStringWidth(Refs.NAME) * 2 + 5, 1, -1);
		}
		GL11.glPopMatrix();
	}
	
	public void drawArraylist() {
		ArrayList<Module> mods = ForgeBase.instance.masterManager.moduleManager.getModules();
		Collections.sort(mods, new Comparator<Module>() { public int compare(Module m1, Module m2) { if (Wrapper.fr.getStringWidth(m1.getDisplayName()) > Wrapper.fr.getStringWidth(m2.getDisplayName())) { return -1; } if (Wrapper.fr.getStringWidth(m1.getDisplayName()) < Wrapper.fr.getStringWidth(m2.getDisplayName())) { return 1; } return 0; } });
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayWidth);
		int yPos = 1;
		int increment = fr.FONT_HEIGHT + 1;
				
		int niceColor = new Color(100, 100, 255).getRGB();

		for(Module m : mods) {
			if(m.isVisible() && m.getAnim() != -1) {
				String text = m.getDisplayName();
				fr.drawStringWithShadow(text, sr.getScaledWidth() - m.getAnim() - 1, yPos, niceColor);
				
				for(int i = 0; i < 3; i++) {
					if(m.isEnabled()) {
						if(m.getAnim() < fr.getStringWidth(text)) { m.setAnim(m.getAnim() + 1); }
						if(m.getAnim() > fr.getStringWidth(text)) { m.setAnim(fr.getStringWidth(text)); }
					}else {
						if(m.getAnim() > -1) { m.setAnim(m.getAnim() - 1); }
					}
				}
				
				yPos += Math.min(increment, m.getAnim());
			}
		}
	}

}
