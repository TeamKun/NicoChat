package net.kunmc.lab.nicochat.chatflow;

import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.text.Color;

import java.util.Date;

//普通に右から左に流れるチャット
public class NormalNicoChat implements INicoChat{
    Color color;
    int Size;
    double y;

    public NormalNicoChat(Color color, int size, double y) {
        this.color = color;
        Size = size;
        this.y = y;
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
}
