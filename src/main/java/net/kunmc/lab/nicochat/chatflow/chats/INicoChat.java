package net.kunmc.lab.nicochat.chatflow.chats;

import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.Color;

import java.util.Date;

public interface INicoChat {

    Vector3f GetPosition(Date nowTime);

    Color GetColor();

    Vector3f GetSize();

    boolean isFlowing(Date nowTime);

    String getChat();
}
