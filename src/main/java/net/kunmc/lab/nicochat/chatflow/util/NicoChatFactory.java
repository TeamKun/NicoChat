package net.kunmc.lab.nicochat.chatflow.util;

import net.kunmc.lab.nicochat.chatflow.chats.*;
import net.minecraft.util.text.Color;

public class NicoChatFactory {
    public static INicoChat NewNicoChat(NicoChatType type, int size, int color, float y,String chat){
        INicoChat tmp = null;
        switch (type){
            case Top:
                tmp = new TopNicoChat(color,size,y,chat);
                break;
            case Under:
                tmp = new UnderNicoChat(color,size,y,chat);
                break;
            default:
                tmp = new NormalNicoChat(color,size,y,chat);
                break;
        }
        return tmp;
    }
}
