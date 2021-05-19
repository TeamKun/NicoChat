package net.kunmc.lab.nicochat.chatflow;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.kunmc.lab.nicochat.chatflow.chats.INicoChat;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.gui.widget.ExtendedButton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

public class DrawNicoChat {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void NicoChatUpdate(RenderGameOverlayEvent renderGameOverlayEvent){

        MatrixStack matrixStack = renderGameOverlayEvent.getMatrixStack();
        Minecraft mc = Minecraft.getInstance();
        int w = renderGameOverlayEvent.getWindow().getScaledWidth();
        int h = (int) (renderGameOverlayEvent.getWindow().getScaledHeight() * 0.8f);


        List<INicoChat> nicoChatList = NicoChatsFlowListManager.getNicoChats();

        matrixStack.push();
        for (INicoChat nicoChat : nicoChatList) {
            matrixStack.push();

            Vector3f pos = nicoChat.GetPosition(new Date());
            matrixStack.translate(pos.getX() * w,pos.getY() * h,pos.getZ());

            Vector3f size = nicoChat.GetSize();
            matrixStack.scale(size.getX(), size.getY(), size.getZ());

            Minecraft.getInstance().fontRenderer.drawString(matrixStack, nicoChat.getChat(), 0, 0, nicoChat.GetColor());

            matrixStack.pop();
        }
        matrixStack.pop();

        //Pushとpopの間の変更は無効になる
    }
}
