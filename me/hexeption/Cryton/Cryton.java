package me.hexeption.Cryton;

import me.hexeption.Cryton.module.Module;
import me.hexeption.Cryton.module.ModuleManager;
import me.hexeption.Cryton.wrapper.Wrapper;

public class Cryton {
	
	private final String clientName = "Cryton";
	private final double clientVersion = 2.0;
	private final String clientCreator = "Hexeption";
	
	private static Cryton theClient = new Cryton();
	
	private static ModuleManager moduleManager = null;
	
	public static Cryton getInstance(){
		return theClient;
	}
	
	public static void initClient(){
		
		moduleManager = new ModuleManager();
		moduleManager.AddModules();
		
		if(Wrapper.getInstance().getWorld() != null){
			moduleManager.setModuleState("Hud", false);
		}else{
			moduleManager.setModuleState("Hud", true);
		}
		
	}

	public String getClientName() {
		return clientName;
	}

	public double getClientVersion() {
		return clientVersion;
	}

	public String getClientCreator() {
		return clientCreator;
	}

	public static ModuleManager getModuleManager() {
		return moduleManager;
	}
	
	
	
}
