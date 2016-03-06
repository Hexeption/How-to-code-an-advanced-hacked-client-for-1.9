package me.hexeption.Cryton.events;

import com.darkmagician6.eventapi.events.Event;

public class EventRender2D implements Event{
	
	public int width, height;
	
	public EventRender2D(final int width, final int height){
		this.width = width;
		this.height = height;
	}

}
