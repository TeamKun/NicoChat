package net.kunmc.lab.nicochat.chatflow.chats;

import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.text.Color;

import java.util.Date;

//上に固定されるタイプのチャット
public class TopNicoChat implements INicoChat{
    Color color;
    int size;
    double y;
    String chat;
    Date chatInsertedTime;

    public TopNicoChat(Color color, int size, double y,String chat) {
        this.color = color;
        this.size = size;
        this.chat = chat;
        this.y = y;
        chatInsertedTime = new Date();
    }
    @Override
    public Vector2f GetPosition(Date nowTime) {
        return null;
    }

    @Override
    public Color GetColor() {
        return null;
    }

    @Override
    public int GetSize() {
        return 0;
    }

    //TODO ここを実装する
    @Override
    public boolean isFlowing() {
        return true;
    }

    @Override
    public String getChat() {
        return chat;
    }
}
