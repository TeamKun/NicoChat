package net.kunmc.lab.nicochat;

import net.minecraft.client.Minecraft;

public class GetPlayerChatEvent {
    public static void Update(){
        Minecraft.getInstance().ingameGUI.getChatGUI()
    }
}
