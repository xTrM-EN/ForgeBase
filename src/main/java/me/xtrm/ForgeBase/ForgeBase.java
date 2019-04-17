package me.xtrm.ForgeBase;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.xtrm.ForgeBase.management.MasterManager;
import me.xtrm.ForgeBase.proxy.CommonProxy;
import me.xtrm.ForgeBase.utils.Refs;

@Mod(name = Refs.NAME, version = Refs.VER, modid = Refs.MODID)
public class ForgeBase {
	
	@SidedProxy(clientSide = Refs.CliPROXY, serverSide = Refs.ComPROXY)
	public static CommonProxy proxy;
	
	public static ForgeBase instance;
	
	public MasterManager masterManager;
	
	@EventHandler
	public void onPreInit(FMLPreInitializationEvent event) {
		instance = this;
		
		proxy.preInit(event);
		
		masterManager = new MasterManager();
		masterManager.preInit();
	}
	
	@EventHandler
	public void onInit(FMLInitializationEvent event) {
		proxy.init(event);
		
		masterManager.init();
	}
	
	@EventHandler
	public void onPostInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
		
		masterManager.postInit();
	}

}
