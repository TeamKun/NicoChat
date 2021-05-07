package net.kunmc.lab.nicochat.chatflow;

import net.kunmc.lab.nicochat.NicoChat;
import net.kunmc.lab.nicochat.chatflow.chats.INicoChat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class NicoChatsFlowListManager {
    private static List<INicoChat> nicoChats = new ArrayList<>();
    public static void AddNicoChats(INicoChat nicoChat){
        nicoChats.add(nicoChat);
    }

    public static List<INicoChat> getNicoChats(){
        //既に流れきったチャットを削除する
        nicoChats = nicoChats.stream().filter(i -> i.isFlowing(new Date())).collect(Collectors.toList());

        return nicoChats;
    }
}
