package net.kunmc.lab.nicochat.chatflow.chats;

import net.kunmc.lab.nicochat.chatflow.util.CalcDateDifference;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.Color;
import org.w3c.dom.ranges.RangeException;

import java.util.Date;

//下に固定されるタイプのチャット
public class UnderNicoChat  implements INicoChat{
    private static final float FlowingTime = 3000;
    private final float UnderChatXPosition;

    private final int color;
    private final int size;
    private final float y;
    private final String chat;
    private final Date chatInsertedTime;

    public UnderNicoChat(int color, int size, float y,String chat){
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
        this.UnderChatXPosition = 0.5f - chat.length()/(200.0f/size);
    }

    @Override
    public Vector3f GetPosition(Date nowTime) {
        return new Vector3f(UnderChatXPosition,y,0);
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
