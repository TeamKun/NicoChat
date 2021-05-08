package net.kunmc.lab.nicochat.chatflow;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.kunmc.lab.nicochat.chatflow.chats.INicoChat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.client.gui.NewChatGui;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

public class DrawNicoChat {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void NicoChatUpdate(RenderGameOverlayEvent renderGameOverlayEvent){

        MatrixStack matrixStack = renderGameOverlayEvent.getMatrixStack();
        int w = renderGameOverlayEvent.getWindow().getScaledWidth();
        int h = renderGameOverlayEvent.getWindow().getScaledHeight();


        //TODO リストを取得してチャットを表示する処理を書く
        List<INicoChat> nicoChatList = NicoChatsFlowListManager.getNicoChats();

        for (INicoChat nicoChat : nicoChatList) {
            matrixStack.push();

            Vector3f pos = nicoChat.GetPosition(new Date());
            //matrixStack.translate(pos.getX() * w,pos.getY() * h,pos.getZ());
            matrixStack.translate(0,pos.getY() * h,pos.getZ());

            Vector3f size = nicoChat.GetSize();
            matrixStack.scale(size.getX(), size.getY(), size.getZ());

            Minecraft.getInstance().fontRenderer.drawString(matrixStack, nicoChat.getChat(), 0, 0, nicoChat.GetColor());

            matrixStack.pop();
        }

        //Pushとpopの間の変更は無効になる
    }
}
