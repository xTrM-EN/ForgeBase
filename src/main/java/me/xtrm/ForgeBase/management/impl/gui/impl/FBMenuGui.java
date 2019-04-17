package me.xtrm.ForgeBase.management.impl.gui.impl;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.GuiModList;
import me.xtrm.ForgeBase.management.impl.gui.impl.ui.UIButton;
import me.xtrm.ForgeBase.utils.Refs;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

@SuppressWarnings("unchecked")
public class FBMenuGui extends GuiScreen {
	
	private GuiScreen parent;
	
	public FBMenuGui(GuiScreen parent) {
		this.parent = parent;
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(new UIButton(5, this.width / 2 - 100, this.height / 2 - 50, "Mods"));
		this.buttonList.add(new UIButton(6, this.width / 2 - 100, this.height / 2 - 26, "Alt Login"));
		this.buttonList.add(new UIButton(7, this.width / 2 - 100, this.height / 2 + 50, "Back"));
		super.initGui();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		GL11.glPushMatrix();
    	{
    		GL11.glScalef(3, 3, 3);
    		mc.fontRenderer.drawStringWithShadow(Refs.NAME, (this.width / 2 / 3) - (mc.fontRenderer.getStringWidth(Refs.NAME)/2), 25 / 3, -1);
    	}
    	GL11.glPopMatrix();
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		switch(button.id) {
			case 5:
				this.mc.displayGuiScreen(new GuiModList(this));
				break;
			case 6:
				
				break;
			case 7:
				this.mc.displayGuiScreen(parent);
				break;
		}
		super.actionPerformed(button);
	}

}
