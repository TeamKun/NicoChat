package net.kunmc.lab.nicochat.ChatAnalysis;

public class ChatRemoveTag {
    public static String RemoveAllTag(String chat){
        return
                chat.replaceAll("\\[type:[0-9]]","").
                        replaceAll("\\[size:[1-9]]","").
                        replaceAll("\\[color:#[0-9,a-f]{6}]","");
    }
    public static String RemoveType(String chat){
        return chat.replaceAll("\\[type:[0-9]]","");
    }
    public static String RemoveSize(String chat){
        return chat.replaceAll("\\[size:[1-9]]","");
    }
    public static String RemoveColor(String chat){
        return chat.replaceAll("\\[color:#[0-9,a-f]{6}]","");
    }
}
