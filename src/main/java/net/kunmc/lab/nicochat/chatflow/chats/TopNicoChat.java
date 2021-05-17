package net.kunmc.lab.nicochat.chatflow.chats;

import net.kunmc.lab.nicochat.chatflow.util.CalcDateDifference;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.Color;

import java.util.Date;

//上に固定されるタイプのチャット
public class TopNicoChat implements INicoChat{
    private static final float FlowingTime = 3000;
    //TODO Xの値を文字列の長さに合わせて求める
    private final float TopChatXPosition;

    private final int color;
    private final int size;
    private final float y;
    private final String chat;
    private final Date chatInsertedTime;

    public TopNicoChat(int color, int size, float y,String chat) {
        if(y < 0){
            y = 0;
        }else if(1 < y){
            y = 1;
        }
        this.color = color;
        this.size = size;
        this.chat = chat;
        this.y = y;
        chatInsertedTime = new Date();

        this.TopChatXPosition = 0.5f - chat.length()/(140.0f/size);
    }
    @Override
    public Vector3f GetPosition(Date nowTime) {
        return new Vector3f(TopChatXPosition,y,0);
    }

    @Override
    public int GetColor() {
        return color;
    }

    @Override
    public Vector3f GetSize() {
        return new Vector3f(size,size,0);
    }

    //TODO ここを実装する
    @Override
    public boolean isFlowing(Date nowTime) {
        long sub = CalcDateDifference.Calc(nowTime ,chatInsertedTime);

        return sub < FlowingTime;
    }

    @Override
    public String getChat() {
        return chat;
    }
}
