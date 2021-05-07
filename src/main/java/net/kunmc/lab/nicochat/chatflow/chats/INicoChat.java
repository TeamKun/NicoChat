package net.kunmc.lab.nicochat.chatflow.chats;

import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.text.Color;

import java.util.Date;

public interface INicoChat {

    Vector2f GetPosition(Date nowTime);

    Color GetColor();

    int GetSize();

    boolean isFlowing();

    String getChat();
}
