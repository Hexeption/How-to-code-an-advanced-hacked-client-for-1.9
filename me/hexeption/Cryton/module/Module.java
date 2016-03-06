package me.hexeption.Cryton.module;

import java.util.Random;

public class Module {
	
	private String name, description;
	private int bind, color;
	private Category category;
	private boolean isEnabled, save = true;
	
	public Module(String name, String description, int bind, Category category){
		this.name = name;
		this.description = description;
		this.bind = bind;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getBind() {
		return bind;
	}

	public int getColor() {
		return color;
	}

	public Category getCategory() {
		return category;
	}

	public boolean getState() {
		return isEnabled;
	}
	
	public void toggleModule(){
		this.setState(!this.getState());
	}
	
	public void onToggle(){
		
	}
	
	public final void setKeyBind(int keybind){
		this.bind = keybind;
	}
	
	public void onEnable(){
		Random randomColor = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append("0x");
		while(sb.length() < 10){
			sb.append(Integer.toHexString(randomColor.nextInt()));
		}
		sb.setLength(8);
		this.color = Integer.decode(sb.toString()).intValue();
	}
	
	public void onDisable(){
		
	}
	
	public final boolean isCategory(Category c){
		if(c == category)
			return true;
		return false;
	}
	
	public void setState(boolean flag){
		this.isEnabled = flag;
		onToggle();
		if(isEnabled){
			onEnable();
		}else{
			onDisable();
		}
		
		//TODO: FileManager Save
		
	}
	
	public final void setSavable(boolean b){
		this.save = b;
	}
	
	public final boolean isSavable(boolean s){
		if(s == save)
			return true;
		return false;
	}
	
	public boolean getSavalbe(){
		return save;
	}
	
	

}
