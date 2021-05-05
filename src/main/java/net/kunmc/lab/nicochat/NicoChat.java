package net.kunmc.lab.nicochat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IngameGui;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("nicochat")
public class NicoChat {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public NicoChat() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (!(Minecraft.getInstance().gui.getChat() instanceof CustomChatGui)) {
            try {
                Minecraft minecraft = Minecraft.getInstance();
                IngameGui ingameGUI = minecraft.gui;
                Field field = ObfuscationReflectionHelper.findField(IngameGui.class, "field_73840_e");
                field.setAccessible(true);
                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
                field.set(ingameGUI, new CustomChatGui(minecraft));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
