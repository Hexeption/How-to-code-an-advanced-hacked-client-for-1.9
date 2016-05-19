package me.hexeption.Cryton.module;

import java.util.ArrayList;

import org.newdawn.slick.font.effects.OutlineEffect;

import me.hexeption.Cryton.module.modules.*;

public class ModuleManager {
	
	public static ArrayList<Module> activeModules = new ArrayList<Module>();
	
	public void AddModules(){
		this.activeModules.add(new Hud());
		this.activeModules.add(new SimpleStep());
		this.activeModules.add(new ChestOutlineESP());
		this.activeModules.add(new OutlineESP());
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
