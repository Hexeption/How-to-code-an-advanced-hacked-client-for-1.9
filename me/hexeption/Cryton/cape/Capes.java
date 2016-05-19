package me.hexeption.Cryton.cape;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpServerConnection;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import me.hexeption.Cryton.Cryton;
import net.minecraft.client.resources.SkinManager.SkinAvailableCallback;

public class Capes {
	
	private static JsonObject capesJson;
	private static JsonParser jsonParser = new JsonParser();
	
	public static void GetCapes(GameProfile gameProfile,Map skinMap,  SkinAvailableCallback callback){
		if(capesJson == null){
			try{
				HttpsURLConnection connection = (HttpsURLConnection) new URL("https://www.dropbox.com/s/6e5egb5jjht28cr/capes.json?raw=1").openConnection();
				connection.connect();
				capesJson = jsonParser.parse(new InputStreamReader(connection.getInputStream())).getAsJsonObject();
			}catch(Exception e){
				Cryton.getInstance().getLogger().error("[Cryton] Faild To Load Capes");
				e.printStackTrace();
				return;
			}
			
			try{
				if(capesJson.has(gameProfile.getName())){
					skinMap.put(Type.CAPE, new MinecraftProfileTexture(capesJson.get(gameProfile.getName()).getAsString(), null));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
