package net.kunmc.lab.nicochat;

import net.kunmc.lab.nicochat.chatflow.DrawNicoChat;
import net.kunmc.lab.nicochat.chatflow.util.NicoChatFactory;
import net.kunmc.lab.nicochat.chatflow.NicoChatsFlowListManager;
import net.kunmc.lab.nicochat.chatflow.chats.NicoChatType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.data.BlockModeInfo;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

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
    public void onOpneGUI(GuiOpenEvent e){
        if(e.getGui() instanceof ChatScreen && !(e.getGui() instanceof ChatScreenTest)){

            new Thread(() -> {
                try {
                    Thread.sleep(60);
                    e.getGui().onClose();
                    Minecraft.getInstance().displayGuiScreen(new ChatScreenTest(""));
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }).start();

        }
    }

    private String lastChat = "null";
    @SubscribeEvent
    public void worldTickEvent(TickEvent.WorldTickEvent event){
        List<String> chats = Minecraft.getInstance().ingameGUI.getChatGUI().getSentMessages();

        LOGGER.info(chats.size());
        if(chats.size() < 1)return;

        LOGGER.info(chats.get(chats.size()-1));
        if(!chats.get(chats.size()-1).equals(lastChat)){
            lastChat = chats.get(chats.size()-1);

            float y = ((new Random()).nextInt(100) + 5) /100.0f;
            y = easeInQuad(y);
            NicoChatsFlowListManager.AddNicoChats(lastChat,y);
        }
    }

    @SubscribeEvent
    public void chatEvent(ClientChatEvent event){
        //TODO y座標を取得するメソッドの追加
        float y = ((new Random()).nextInt(100) + 5) /100.0f;
        y = easeInQuad(y);
        NicoChatsFlowListManager.AddNicoChats(
                NicoChatFactory.NewNicoChat(
                        event.getMessage(),y));
    }

    private float easeInQuad(float x){
        return  x * x * x;
    }

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public NicoChat() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
