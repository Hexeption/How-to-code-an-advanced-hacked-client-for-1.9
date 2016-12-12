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
	//fix
		Wrapper.getInstance().getPlayer().stepHeight = 1F;
	}
	
	@Override
	public void onDisable() {
		EventManager.unregister(this);
		super.onDisable();
	//fix
		Wrapper.getInstance().getPlayer().stepHeight = 0.5F;
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event){
		if(this.getState()){
			// doesnt work: Wrapper.getInstance().getPlayer().stepHeight = 1F;
		
		}else{
			// doesnt work: Wrapper.getInstance().getPlayer().stepHeight = 0.5F;
	
		}
	}
	
}

