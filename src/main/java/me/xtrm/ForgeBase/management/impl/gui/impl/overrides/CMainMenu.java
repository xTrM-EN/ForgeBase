package me.xtrm.ForgeBase.management.impl.gui.impl.overrides;

import org.lwjgl.opengl.GL11;

import me.xtrm.ForgeBase.management.impl.gui.impl.MCMainMenu;
import me.xtrm.ForgeBase.management.impl.gui.impl.FBMenuGui;
import me.xtrm.ForgeBase.management.impl.gui.impl.ui.UIButton;
import me.xtrm.ForgeBase.utils.Refs;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;

@SuppressWarnings("unchecked") 
public class CMainMenu extends MCMainMenu {

	public CMainMenu() {
		super();
	}
	
	@Override
	public void initGui() {
		super.initGui();
		
		this.buttonList.clear();
		
		// GuiMainMenu
		
		// Add Minecraft Buttons
		this.buttonList.add(new UIButton(1, 65 / 2, this.height / 4 + 48, I18n.format("menu.singleplayer", new Object[0])));
        this.buttonList.add(new UIButton(2, 65 / 2, this.height / 4 + 48 + 24, I18n.format("menu.multiplayer", new Object[0])));
        this.buttonList.add(new UIButton(0, 65 / 2, this.height / 4 + 48 + 24 + 24 + 24, I18n.format("menu.options", new Object[0])));
        this.buttonList.add(new UIButton(4, 65 / 2, this.height / 4 + 48 + 24 + 24 + 24 + 24, I18n.format("menu.quit", new Object[0])));
        
        // Add FBMenu Button
        this.buttonList.add(new UIButton(69, 65 / 2, this.height / 4 + 48 + 24 + 24, "ForgeBase"));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GL11.glDisable(GL11.GL_ALPHA_TEST);
        this.renderSkybox(mouseX, mouseY, partialTicks);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        		
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		
		Gui.drawRect(25, 0, 238, sr.getScaledHeight(), 0xBB000000);
    	
    	Gui.drawRect(24, 0, 25, sr.getScaledHeight(), 0xFFff422d);
    	Gui.drawRect(238, 0, 239, sr.getScaledHeight(), 0xFFff422d);
    	
    	GL11.glPushMatrix();
    	{
    		GL11.glScalef(3, 3, 3);
    		mc.fontRenderer.drawStringWithShadow(Refs.NAME, (213/2 - mc.fontRenderer.getStringWidth(Refs.NAME)) / 3, 30 / 3, -1);
    	}
    	GL11.glPopMatrix();
    	
    	super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		if(button.id == 69) {
			mc.displayGuiScreen(new FBMenuGui(this));
		}
		if (button.id == 0)
        {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }

        if (button.id == 5)
        {
            this.mc.displayGuiScreen(new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
        }

        if (button.id == 1)
        {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        }

        if (button.id == 2)
        {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }

        if (button.id == 4)
        {
            this.mc.shutdown();
        }
		super.actionPerformed(button);
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int state) {
		super.mouseClicked(mouseX, mouseY, state);
	}
	
	@Override
	protected void keyTyped(char c, int keyCode) {
		super.keyTyped(c, keyCode);
	}
	
	
	
}
