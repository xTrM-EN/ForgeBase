package me.xtrm.ForgeBase.management.impl.gui.impl.ui;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;

/**
 * Custom GuiButton.
 * Remove drawButton() to bring it back to default
 */
public class UIButton extends GuiButton {
		
	private int alpha;
	
	public UIButton(int id, int x, int y, int width, int height, String text) { super(id, x, y, width, height, text); alpha = 125; }
	public UIButton(int id, int x, int y, String text) { super(id, x, y, text); alpha = 125; }

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if(this.visible) {
			if(!this.enabled) {
				Gui.drawRect(xPosition, yPosition, xPosition + width, yPosition + height, 0xDE000000);
				mc.fontRenderer.drawStringWithShadow(
						displayString, 
						xPosition + (width / 2) - (mc.fontRenderer.getStringWidth(displayString) / 2), 
						yPosition + (height / 2) - (mc.fontRenderer.FONT_HEIGHT / 2), 
						-1);
			}else {
				boolean hovering = mouseX > this.xPosition && mouseX < this.xPosition + this.width && mouseY > this.yPosition && mouseY < this.yPosition + this.height;
				
				alpha += hovering ? ((alpha < 200) ? 10 : 0) : ((alpha > 130) ? -10 : 0);
				
				Color color = new Color(0, 0, 0, alpha);
				Gui.drawRect(xPosition, yPosition, xPosition + width, yPosition + height, color.getRGB());
				mc.fontRenderer.drawStringWithShadow(
						displayString, 
						xPosition + (width / 2) - (mc.fontRenderer.getStringWidth(displayString) / 2), 
						yPosition + (height / 2) - (mc.fontRenderer.FONT_HEIGHT / 2), 
						-1);
			}
		}
	}

}
