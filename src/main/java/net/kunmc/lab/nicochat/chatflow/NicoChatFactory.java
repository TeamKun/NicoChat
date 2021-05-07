package net.kunmc.lab.nicochat.chatflow;

import net.kunmc.lab.nicochat.chatflow.chats.*;
import net.minecraft.util.text.Color;

public class NicoChatFactory {
    public static INicoChat NewNicoChat(NicoChatType type, int size, Color color, double y){
        switch (type){
            case Top:
                return new TopNicoChat(color,size,y);
            case Under:
                return new UnderNicoChat(color,size,y);
            default:
                return new NormalNicoChat(color,size,y);
        }
    }
}
