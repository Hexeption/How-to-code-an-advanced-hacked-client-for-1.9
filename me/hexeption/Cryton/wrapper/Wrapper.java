package me.hexeption.Cryton.wrapper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.network.Packet;
import net.minecraft.util.math.RayTraceResult;

public class Wrapper {
	
private static Wrapper theWrapper = new Wrapper();
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public static Wrapper getInstance(){
		return theWrapper;
	}
	
	public EntityPlayerSP getPlayer(){
		return this.mc.thePlayer;
	}
	
	public WorldClient getWorld(){
		return this.mc.theWorld;
	}
	
	public FontRenderer getFontRenderer(){
		return this.mc.fontRendererObj;
	}
	
	public NetHandlerPlayClient getQueue(){
		return this.mc.thePlayer.sendQueue;
	}
	
	public EntityRenderer getEntityRenderer(){
		return this.mc.entityRenderer;
	}
	
	public EffectRenderer getEffectRenderer(){
		return this.mc.effectRenderer;
	}
	
	public GameSettings getGameSettings(){
		return this.mc.gameSettings;
	}
	
	public static void sendPackets(Packet packet){
		getInstance().getPlayer().sendQueue.addToSendQueue(packet);
	}
	
	public PlayerControllerMP getPlayerContoller(){
		return this.mc.playerController;
	}
	
	public RenderGlobal getRenderGlobal(){
		return this.mc.renderGlobal;
	}
	
	public GuiScreen getCurrentDisplyedGuiScreen(){
		return this.mc.currentScreen;
	}
	
	public RayTraceResult getMouseOverObject(){
		return this.mc.objectMouseOver;
	}
	
	public GuiIngame getGuiIngame(){
		return this.mc.ingameGUI;
	}
	
	public Minecraft getMinecraft(){
		return this.mc;
	}

}
