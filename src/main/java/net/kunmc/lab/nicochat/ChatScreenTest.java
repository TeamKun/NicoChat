package net.kunmc.lab.nicochat;

import net.minecraft.client.gui.screen.ChatScreen;

public class ChatScreenTest extends ChatScreen {
    public ChatScreenTest(String defaultText) {
        super(defaultText);
    }

    public ChatScreenTest(ChatScreen chatScreen){
        super("");
    }
}
