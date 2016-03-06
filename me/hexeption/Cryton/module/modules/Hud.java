package me.hexeption.Cryton.module.modules;

import net.minecraft.client.gui.ScaledResolution;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.hexeption.Cryton.Cryton;
import me.hexeption.Cryton.events.EventRender2D;
import me.hexeption.Cryton.module.Category;
import me.hexeption.Cryton.module.Module;
import me.hexeption.Cryton.ttf.TTFManager;
import me.hexeption.Cryton.wrapper.Wrapper;

public class Hud extends Module {

	public Hud() {
		super("Hud", "Hud", 0, Category.GUI);
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
	private void onRender2D(EventRender2D event){
		ScaledResolution sr = new ScaledResolution(Wrapper.getInstance().getMinecraft());
		String drawFPS = String.valueOf(Wrapper.getInstance().getMinecraft().debugFPS);
		TTFManager.getInstance().getStandardFont().drawString(Cryton.getInstance().getClientName() + " §6[rel-" + Cryton.getInstance().getClientVersion() + "]", 7, 2, 0xff00FF00);
		TTFManager.getInstance().getStandardFont().drawString("FPS: " + drawFPS, 7, 14, 0xffffff);
		renderArrayList(sr);
	}
	
	private static void renderArrayList(ScaledResolution scaledResolution){
		int yCount = 2;
		int right = scaledResolution.getScaledWidth() - 2;
		for(Module m : Cryton.getInstance().getModuleManager().activeModules){
			if(m.getState() && !m.isCategory(Category.GUI)){
				TTFManager.getInstance().getModListFont().drawString(m.getName(), right - TTFManager.getInstance().getModListFont().getWidth(m.getName()), yCount, m.getColor());
				yCount += 10;
			}
		}
	}

}
