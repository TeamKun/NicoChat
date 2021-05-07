package net.kunmc.lab.nicochat.chatflow;

import net.kunmc.lab.nicochat.NicoChat;
import net.kunmc.lab.nicochat.chatflow.chats.INicoChat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NicoChatsFlowListManager {
    List<INicoChat> nicoChats = new ArrayList<INicoChat>();
    public void AddNicoChats(INicoChat nicoChat){
        nicoChats.add(nicoChat);
    }

    public List<INicoChat> getNicoChats(){
        //既に流れきったチャットを削除する
        nicoChats = nicoChats.stream().filter(INicoChat::isFlowing).collect(Collectors.toList());

        return nicoChats;
    }
}
