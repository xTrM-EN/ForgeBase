package me.xtrm.ForgeBase.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.xtrm.ForgeBase.management.impl.event.EventTransmitter;
//import me.xtrm.ForgeBase.management.impl.event.EventTransmitter;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		EventTransmitter eventTransmitter = new EventTransmitter();
		
		MinecraftForge.EVENT_BUS.register(eventTransmitter);
		FMLCommonHandler.instance().bus().register(eventTransmitter);
		
		super.preInit(event);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
	
}
