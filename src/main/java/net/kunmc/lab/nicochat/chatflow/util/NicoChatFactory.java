package net.kunmc.lab.nicochat.chatflow.util;

import net.kunmc.lab.nicochat.ChatAnalysis.ChatAnalysisColor;
import net.kunmc.lab.nicochat.ChatAnalysis.ChatAnalysisSize;
import net.kunmc.lab.nicochat.ChatAnalysis.ChatAnalysisType;
import net.kunmc.lab.nicochat.ChatAnalysis.ChatRemoveTag;
import net.kunmc.lab.nicochat.chatflow.chats.*;

public class NicoChatFactory {
    public static INicoChat NewNicoChat(NicoChatType type, int size, int color, float y,String chat){
        INicoChat tmp = null;
        switch (type) {
            case Top:
                tmp = new TopNicoChat(color, size, y, chat);
                break;
            case Under:
                tmp = new UnderNicoChat(color, size, y, chat);
                break;
            default:
                tmp = new NormalNicoChat(color, size, y, chat);
                break;
        }
        return tmp;
    }

    public static INicoChat NewNicoChat(String chat,float y){
        return NewNicoChat(
                ChatAnalysisType.GetType(chat),
                ChatAnalysisSize.GetSize(chat),
                ChatAnalysisColor.GetColor(chat),
                y,
                ChatRemoveTag.Remove(chat));
    }
}
