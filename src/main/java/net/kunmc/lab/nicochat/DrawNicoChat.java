package net.kunmc.lab.nicochat;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DrawNicoChat {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void NicoChatUpdate(RenderGameOverlayEvent renderGameOverlayEvent){
        Minecraft mc = Minecraft.getInstance();

        MatrixStack matrixStack = renderGameOverlayEvent.getMatrixStack();
        int w = renderGameOverlayEvent.getWindow().getScaledWidth();
        int h = renderGameOverlayEvent.getWindow().getScaledHeight();

        //Pushとpopの間の変更は無効になる
        matrixStack.push();

        matrixStack.translate(w/2,h/2,0);
        matrixStack.scale(1,1,0);
        //matrixStack.translate(200,0,0);
        mc.fontRenderer.drawString(matrixStack,"Windowsでコンピューターの世界が広がります。1234567890",0,0,0xffffff);

        matrixStack.pop();
    }
}
