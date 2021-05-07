package net.kunmc.lab.nicochat.chatflow;

import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.text.Color;

import java.util.Date;

public interface INicoChat {

    public Vector2f GetPosition(Date nowTime);

    public Color GetColor();

    public int GetSize();
}
