package net.kunmc.lab.nicochat.chatflow.util;

import net.kunmc.lab.nicochat.ChatAnalysis.ChatAnalysisColor;
import net.kunmc.lab.nicochat.ChatAnalysis.ChatAnalysisSize;
import net.kunmc.lab.nicochat.ChatAnalysis.ChatAnalysisType;
import net.kunmc.lab.nicochat.chatflow.chats.*;

public class NicoChatFactory {
    public static INicoChat NewNicoChat(NicoChatType type, int size, int color, float y,String chat){
        return switch (type) {
            case Top -> new TopNicoChat(color, size, y, chat);
            case Under -> new UnderNicoChat(color, size, y, chat);
            default -> new NormalNicoChat(color, size, y, chat);
        };
    }

    public static INicoChat NewNicoChat(String chat,float y){
        return NewNicoChat(
                ChatAnalysisType.GetType(chat),
                ChatAnalysisSize.GetSize(chat),
                ChatAnalysisColor.GetColor(chat),
                y,
                chat);
    }
}
