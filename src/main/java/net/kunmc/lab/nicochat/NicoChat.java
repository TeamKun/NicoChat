package net.kunmc.lab.nicochat;

import net.kunmc.lab.nicochat.chatflow.DrawNicoChat;
import net.kunmc.lab.nicochat.gui.CustomChatGui;
import net.kunmc.lab.nicochat.gui.CustomChatScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("nicochat")
public class NicoChat {



    //HUD表示時にイベントをキャッチしてチャットをチャットアップデートする
    @SubscribeEvent
    public void drawHUD(RenderGameOverlayEvent.Chat event){
        DrawNicoChat.NicoChatUpdate(event);
    }

    //チャットGUIを専用クラスに置き換える
    @SubscribeEvent
    public void onOpneGUI(GuiOpenEvent event){
        if(event.getGui() instanceof ChatScreen && !(event.getGui() instanceof CustomChatScreen)){

            new Thread(() -> {
                try {
                    ChatScreen chatScreen = (ChatScreen)event.getGui();
                    String  str  = ObfuscationReflectionHelper.getPrivateValue(ChatScreen.class,chatScreen,"field_146409_v");
                    LOGGER.info(str);
                    Thread.sleep(60);

                    event.getGui().onClose();

                    Minecraft.getInstance().displayGuiScreen(new CustomChatScreen(str));
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }).start();

        }

        if (Minecraft.getInstance().ingameGUI.getChatGUI() instanceof CustomChatGui) {
            return;
        }
        try {
            Minecraft minecraft = Minecraft.getInstance();
            IngameGui ingameGUI = minecraft.ingameGUI;
            Field field = ObfuscationReflectionHelper.findField(IngameGui.class, "field_73840_e");
            field.setAccessible(true);
            field.set(ingameGUI, new CustomChatGui(minecraft));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public NicoChat() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
