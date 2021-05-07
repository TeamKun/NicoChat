package net.kunmc.lab.nicochat.chatflow.chats;

import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.text.Color;

import java.util.Date;

//普通に右から左に流れるチャット
public class NormalNicoChat implements INicoChat{
    Color color;
    int Size;
    double y;
    Date chatInsertedTime;

    public NormalNicoChat(Color color, int size, double y) {
        this.color = color;
        Size = size;
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
}
