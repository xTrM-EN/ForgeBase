package me.xtrm.ForgeBase.management.impl.module;

import me.xtrm.ForgeBase.management.impl.event.eventbus.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Module {
	
	protected Minecraft mc = Minecraft.getMinecraft();
	protected FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
	
	private String name, displayName;
	private int key, anim;
	private Category category;
	private boolean visible, enabled;
	
	public Module(String name, Category category) { this(name, 0, category, false, true); }	
	public Module(String name, Category category, boolean enabled) { this(name, 0, category, enabled, true); }	
	public Module(String name, Category category, boolean enabled, boolean visible) { this(name, 0, category, enabled, visible); }
	public Module(String name, int key, Category category) { this(name, key, category, false, true); }	
	public Module(String name, int key, Category category, boolean enabled) { this(name, key, category, enabled, true); }	
	public Module(String name, int key, Category category, boolean enabled, boolean visible) {
		this.name = this.displayName = name;
		this.key = key;
		this.anim = 0;
		this.category = category;
		this.visible = visible;
		this.enabled = enabled;
		
		if(enabled) {
			iEnable();
		}
	}
	
	public enum Category { Combat, Movement, Player, Render, World, Misc; }

	public String getDisplayName() { return displayName; }
	public void setDisplayName(String displayName) { this.displayName = displayName; }
	public int getKey() { return key; }
	public void setKey(int key) { this.key = key; }
	public int getAnim() { return anim; }
	public void setAnim(int anim) { this.anim = anim; }
	public boolean isEnabled() { return enabled; }
	public boolean isToggled() { return enabled; }
	public boolean getState() { return enabled; }
	public String getName() { return name; }
	public Category getCategory() { return category; }
	public boolean isVisible() { return visible; }
	
	public void setEnabled(boolean enabled) { this.setToggled(enabled); }
	public void setToggled(boolean toggled) { this.setState(enabled); }
	
	public void setState(boolean state) {
		if(state != getState())
			iToggle();
		
		this.enabled = state;
		
		if(state)
			iEnable();
		else
			iDisable();
	}
	
	public void toggle() {
		iToggle();
		
		boolean next = !this.enabled;
		this.enabled = next;
		
		if(next)
			iEnable();
		else
			iDisable();
	}
	
	private void iEnable() { EventManager.register(this); anim = 0; onEnable(); }
	private void iDisable() { EventManager.unregister(this); onDisable(); }
	private void iToggle() { onToggle(); }
	
	protected void onEnable() {}
	protected void onDisable() {}
	protected void onToggle() {}

}
