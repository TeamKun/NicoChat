package net.kunmc.lab.nicochat.chatflow.chats;

import net.kunmc.lab.nicochat.NicoChat;
import net.kunmc.lab.nicochat.chatflow.util.CalcDateDifference;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.Color;
import org.apache.logging.log4j.LogManager;

import java.util.Date;


//普通に右から左に流れるチャット
public class NormalNicoChat implements INicoChat{
    private static final float FlowingTime = 3000;

    private final int color;
    private final int size;
    private final float y;
    private final String chat;
    private final Date chatInsertedTime;

    public NormalNicoChat(int color, int size, float y,String chat) {
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
    }

    //TODO ここを実装する
    @Override
    public Vector3f GetPosition(Date nowTime) {
        long sub = CalcDateDifference.Calc(nowTime,chatInsertedTime);

        float tmp = 1-sub / 1000.0f;
        LogManager.getLogger().info(sub);
        return new Vector3f(tmp,y,0);
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
