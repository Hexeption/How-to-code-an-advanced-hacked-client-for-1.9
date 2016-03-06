package me.hexeption.Cryton.module.modules;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.hexeption.Cryton.events.EventUpdate;
import me.hexeption.Cryton.module.Category;
import me.hexeption.Cryton.module.Module;
import me.hexeption.Cryton.wrapper.Wrapper;

public class SimpleStep extends Module{

	public SimpleStep() {
		super("Simple Step", "", Keyboard.KEY_P, Category.MOVEMENT);
	}
	
	@Override
	public void onEnable() {
		EventManager.register(this);
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		EventManager.unregister(this);
		super.onDisable();
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event){
		if(this.getState()){
			Wrapper.getInstance().getPlayer().stepHeight = 1f;
		}else{
			Wrapper.getInstance().getPlayer().stepHeight = 0.5f;
		}
	}

}
