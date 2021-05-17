package net.kunmc.lab.nicochat.ChatAnalysis;

public class ChatRemoveTag {
    public static String Remove(String chat){
        return
                chat.replaceAll("\\[type:[0-9]]","").
                        replaceAll("\\[size:[1-9]]","").
                        replaceAll("\\[color:#[0-9,a-f]{6}]","");

    }
}
