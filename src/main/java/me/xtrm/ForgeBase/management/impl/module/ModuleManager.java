package me.xtrm.ForgeBase.management.impl.module;

import java.util.ArrayList;

import me.xtrm.ForgeBase.management.impl.event.eventbus.EventManager;
import me.xtrm.ForgeBase.management.impl.event.eventbus.EventTarget;
import me.xtrm.ForgeBase.management.impl.event.impl.EventKeyboard;
import me.xtrm.ForgeBase.management.impl.module.Module.Category;
import me.xtrm.ForgeBase.management.impl.module.impl.combat.KillAura;
import me.xtrm.ForgeBase.management.impl.module.impl.movement.Speed;
import me.xtrm.ForgeBase.management.impl.module.impl.player.Spammer;
import me.xtrm.ForgeBase.management.impl.module.impl.render.HUD;

/**
 * Manager listing & registering all Modules
 */
public class ModuleManager {

	private ArrayList<Module> modules;
	
	public ModuleManager() {
		modules = new ArrayList<>();
		EventManager.register(this);
	}
	
	public void init() {
		modules.add(new HUD());
		modules.add(new KillAura());
		modules.add(new Spammer());
		modules.add(new Speed());
	}
	
	public ArrayList<Module> getModules() {
		return modules;
	}
	
	public Module getModule(String mod) {
		for(Module m : getModules()) {
			if(m.getName().equalsIgnoreCase(mod))
				return m;
		}
		return null;
	}
	
	public ArrayList<Module> getModulesInCategory(Category cat){
		ArrayList<Module> returnable = new ArrayList<>();
		for(Module m : getModules()) {
			if(m.getCategory() == cat) {
				returnable.add(m);
			}
		}
		return returnable;
	}
	
	@EventTarget
	public void onKey(EventKeyboard e) {
		for(Module m : getModules()) {
			if(m.getKey() == e.getKey()) {
				m.toggle();
			}
		}
	}

}
