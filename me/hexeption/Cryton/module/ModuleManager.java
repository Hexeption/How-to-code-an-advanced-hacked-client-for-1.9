package me.hexeption.Cryton.module;

import java.util.ArrayList;

import me.hexeption.Cryton.module.modules.*;

public class ModuleManager {
	
	public static ArrayList<Module> activeModules = new ArrayList<Module>();
	
	public void AddModules(){
		this.activeModules.add(new Hud());
		this.activeModules.add(new SimpleStep());
	}
	
	public static ArrayList<Module> getModules(){
		return activeModules;
	}
	
	public Module getModule(Class<? extends Module> clazz){
		for(Module m : getModules()){
			if(m.getClass() == clazz){
				return m;
			}
		}
		return null;
	}
	
	public void setModuleState(String modName, boolean state){
		for(Module m : activeModules){
			if(m.getName().equalsIgnoreCase(modName.trim())){
				m.setState(state);
				return;
			}
		}
	}

}
