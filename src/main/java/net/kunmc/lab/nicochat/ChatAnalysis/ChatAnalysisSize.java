package net.kunmc.lab.nicochat.ChatAnalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatAnalysisSize {
    private static final int DEFAULT_SIZE = 1;

    //チャットからサイズタグを抽出する
    public static int GetSize(String chat){
        try {
            //[size:1]みたいなサイズタグが含まれてないかチェック
            Matcher matcher = Pattern.compile("\\[size:[1-9]]").matcher(chat);

            if (!matcher.find()) return DEFAULT_SIZE;

            //あったらさらに数字だけ抽出
            Matcher matcherSize = Pattern.compile("[1-9]").matcher(matcher.group());

            //数字があったらintに変換して返す
            if(matcherSize.find()){
                return Integer.parseInt(matcherSize.group());
            }
        }catch (Exception e){
            return DEFAULT_SIZE;
        }
        return DEFAULT_SIZE;
    }
}
