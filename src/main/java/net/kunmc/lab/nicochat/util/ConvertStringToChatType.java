package net.kunmc.lab.nicochat.util;

import net.kunmc.lab.nicochat.chatflow.chats.NicoChatType;
import net.minecraft.util.text.ChatType;

public class ConvertStringToChatType {
    public static NicoChatType Convert(int id){
        // 値から enum 定数を特定して返す処理
        for (NicoChatType value : NicoChatType.values()) {
            if (value.getNumber() == id) {
                return value;
            }
        }
        return NicoChatType.Normal;
    }
}
