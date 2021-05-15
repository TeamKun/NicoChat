package net.kunmc.lab.nicochat;

import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GetPlayerChatEvent {

    private static final Logger LOGGER = LogManager.getLogger();
    private static List<String> sentMessages = null;
    public static void Update(){
        if(sentMessages == null){
            sentMessages = Minecraft.getInstance().ingameGUI.getChatGUI().getSentMessages();
        }
        LOGGER.info(sentMessages.size());

    }
}
