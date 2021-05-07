package net.kunmc.lab.nicochat;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("nicochat")
public class NicoChat {


    //HUD表示時にイベントをキャッチしてチャットをチャットアップデートする
    @SubscribeEvent
    public void drawHUD(RenderGameOverlayEvent.Post event){
        DrawNicoChat.NicoChatUpdate(event);
    }

    //チャットGUIを専用クラスに置き換える
    @SubscribeEvent
    public void onOpneGUI(GuiOpenEvent e){
        if(e.getGui() instanceof ChatScreen && !(e.getGui() instanceof ChatScreenTest)){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(60);
                        ((ChatScreen)e.getGui()).onClose();
                        Minecraft.getInstance().displayGuiScreen(new ChatScreenTest("aa"));
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            }).start();

        }
    }

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public NicoChat() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
