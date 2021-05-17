package net.kunmc.lab.nicochat.chatflow.util;

import net.kunmc.lab.nicochat.ChatAnalysis.ChatAnalysisColor;
import net.kunmc.lab.nicochat.ChatAnalysis.ChatAnalysisSize;
import net.kunmc.lab.nicochat.ChatAnalysis.ChatAnalysisType;
import net.kunmc.lab.nicochat.ChatAnalysis.ChatRemoveTag;
import net.kunmc.lab.nicochat.chatflow.chats.*;

import java.util.Random;

public class NicoChatFactory {
    public static INicoChat NewNicoChat(NicoChatType type, int size, int color, String chat){

        float y = ((new Random()).nextInt(100) + 5) /100.0f;
        INicoChat tmp = null;
        switch (type) {
            case Top:
                y = y*y*y;
                if(0.4f < y) y = 0.4f;
                tmp = new TopNicoChat(color, size, y, chat);
                break;
            case Under:
                y = (float) (1 - Math.pow(1 - y, 3));
                if(y < 0.6f) y = 0.6f;
                tmp = new UnderNicoChat(color, size, y, chat);
                break;
            default:
                y = y*y*y;
                tmp = new NormalNicoChat(color, size, y, chat);
                break;
        }
        return tmp;
    }

    public static INicoChat NewNicoChat(String chat){
        return NewNicoChat(
                ChatAnalysisType.GetType(chat),
                ChatAnalysisSize.GetSize(chat),
                ChatAnalysisColor.GetColor(chat),
                ChatRemoveTag.Remove(chat));
    }
}
