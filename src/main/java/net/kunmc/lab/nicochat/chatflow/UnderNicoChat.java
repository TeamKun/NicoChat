package net.kunmc.lab.nicochat.chatflow;

import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.text.Color;

import java.util.Date;

//下に固定されるタイプのチャット
public class UnderNicoChat  implements INicoChat{

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
