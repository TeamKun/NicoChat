package net.kunmc.lab.nicochat.ChatAnalysis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatAnalysisColor {
    private static final int DEFAULT_COLOR = 0xffffff;
    public static int GetColor(String chat){

        try {
            //[color:#ffffff]みたいなサイズタグが含まれてないかチェック
            Matcher matcher = Pattern.compile("\\[color:#[0-9,a-f]{6}]").matcher(chat);

            if (!matcher.find()) return DEFAULT_COLOR;

            //あったらさらにカラーコードだけ抽出
            Matcher matcherSize = Pattern.compile("[0-9,a-f]{6}").matcher(matcher.group());

            //数字があったらintに変換して返す
            if(matcherSize.find()){
                return Integer.parseInt(matcherSize.group(),16);
            }
        }catch (Exception e){
            return DEFAULT_COLOR;
        }
        return DEFAULT_COLOR;
    }
}
