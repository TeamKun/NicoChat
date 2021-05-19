package net.kunmc.lab.nicochat.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.client.gui.widget.ExtendedButton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomChatScreen extends ChatScreen {
    public CustomChatScreen(String defaultText) {
        super(defaultText);
    }

    private static final Logger LOGGER = LogManager.getLogger();
    public CustomChatScreen(ChatScreen chatScreen){
        super("");
    }

    @Override
    protected void init(){
        super.init();
        addButton(new ExtendedButton(10, 10, 30, 10, new StringTextComponent("aa"), new Button.IPressable() {
            @Override
            public void onPress(Button p_onPress_1_) {
                LOGGER.info("aaaaaaaaaaa");
            }
        }));
    }
}
