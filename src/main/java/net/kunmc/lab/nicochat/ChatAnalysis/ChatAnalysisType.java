package net.kunmc.lab.nicochat.ChatAnalysis;

import net.kunmc.lab.nicochat.chatflow.chats.NicoChatType;
import net.kunmc.lab.nicochat.util.ConvertStringToChatType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatAnalysisType {
    //チャットからタイプタグを抽出して返す
    public static NicoChatType GetType(String chat){
        try {
            //[type:1]みたいなサイズタグが含まれてないかチェック
            Matcher matcher = Pattern.compile("\\[type:[1-9]]").matcher(chat);

            if (!matcher.find()) return NicoChatType.Normal;

            Matcher matcherSize = Pattern.compile("[1-9]").matcher(matcher.group());

            //数字があったらintに変換し、NicoChatTypeに変換
            if(matcherSize.find()){
                return ConvertStringToChatType.Convert(Integer.parseInt(matcherSize.group()));
            }
        }catch (Exception e){
            return NicoChatType.Normal;
        }
        return NicoChatType.Normal;
    }
}
