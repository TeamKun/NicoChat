package net.kunmc.lab.nicochat.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.kunmc.lab.nicochat.ChatAnalysis.ChatRemoveTag;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.client.gui.widget.ExtendedButton;
import net.minecraftforge.fml.client.gui.widget.Slider;
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

    static ExtendedButton upButton = null;
    static ExtendedButton centerButton = null;
    static ExtendedButton underButton = null;
    static Slider sizeSlider = null;

    static ExtendedButton whiteButton = null;
    static ExtendedButton redButton = null;
    static ExtendedButton orangeButton = null;
    static ExtendedButton yellowButton = null;
    static ExtendedButton greenButton = null;
    static ExtendedButton blueButton = null;
    static ExtendedButton purpleButton = null;
    static ExtendedButton blackButton = null;

    @Override
    protected void init(){
        super.init();

        //流れる場所を指定するボタン
        if(upButton == null){
            upButton = new ExtendedButton(5, 5, 50, 20, new StringTextComponent("▲ AAAA ▲"), p_onPress_1_ -> {
                upButton.active = false;
                centerButton.active = true;
                underButton.active = true;
                type = 1;
            });
        }
        if(centerButton == null){
            centerButton = new ExtendedButton(60, 5, 50, 20, new StringTextComponent("◀ AAAA"), p_onPress_1_ -> {
                upButton.active = true;
                centerButton.active = false;
                underButton.active = true;
                type = 0;
            });
        }
        if(underButton == null){
            underButton = new ExtendedButton(115, 5, 50, 20, new StringTextComponent("▼ AAAA ▼"), p_onPress_1_ -> {
                upButton.active = true;
                centerButton.active = true;
                underButton.active = false;
                type = 2;
            });
            centerButton.active = false;
        }
        addButton(upButton);
        addButton(centerButton);
        addButton(underButton);

        //サイズ変更スライダー
        if(sizeSlider == null){
            sizeSlider = new Slider(5,30,new StringTextComponent("文字サイズ:"),1,9,1, p_onPress_1_ -> {},slider -> size = slider.getValueInt());
            sizeSlider.showDecimal = false;
        }

        sizeSlider.dragging = false;
        sizeSlider.updateSlider();
        addButton(sizeSlider);


        //色変更ボタン
        if(whiteButton == null){
            whiteButton = new ExtendedButton(5, 55, 15, 15, new StringTextComponent("■"), p_onPress_1_ -> {
                whiteButton.active = false;
                redButton.active = true;
                orangeButton.active = true;
                yellowButton.active = true;
                greenButton.active = true;
                blueButton.active = true;
                purpleButton.active = true;
                blackButton.active = true;
                color = "#ffffff";
            });
            whiteButton.setFGColor(0xffffff);
        }
        if(redButton == null){
            redButton = new ExtendedButton(20, 55, 15, 15, new StringTextComponent("■"), p_onPress_1_ -> {
                whiteButton.active = true;
                redButton.active = false;
                orangeButton.active = true;
                yellowButton.active = true;
                greenButton.active = true;
                blueButton.active = true;
                purpleButton.active = true;
                blackButton.active = true;
                color = "#ff0000";
            });
            redButton.setFGColor(0xff0000);
        }
        if(orangeButton == null){
            orangeButton = new ExtendedButton(35, 55, 15, 15, new StringTextComponent("■"), p_onPress_1_ -> {
                whiteButton.active = true;
                redButton.active = true;
                orangeButton.active = false;
                yellowButton.active = true;
                greenButton.active = true;
                blueButton.active = true;
                purpleButton.active = true;
                blackButton.active = true;
                color = "#ff7c00";
            });
            orangeButton.setFGColor(0xff7c00);
        }
        if(yellowButton == null){
            yellowButton = new ExtendedButton(50, 55, 15, 15, new StringTextComponent("■"), p_onPress_1_ -> {
                whiteButton.active = true;
                redButton.active = true;
                orangeButton.active = true;
                yellowButton.active = false;
                greenButton.active = true;
                blueButton.active = true;
                purpleButton.active = true;
                blackButton.active = true;
                color = "#edee00";
            });
            yellowButton.setFGColor(0xedee00);
        }
        if(greenButton == null){
            greenButton = new ExtendedButton(65, 55, 15, 15, new StringTextComponent("■"), p_onPress_1_ -> {
                whiteButton.active = true;
                redButton.active = true;
                orangeButton.active = true;
                yellowButton.active = true;
                greenButton.active = false;
                blueButton.active = true;
                purpleButton.active = true;
                blackButton.active = true;
                color = "#00ff00";
            });
            greenButton.setFGColor(0x00ff00);
        }
        if(blueButton == null){
            blueButton = new ExtendedButton(80, 55, 15, 15, new StringTextComponent("■"), p_onPress_1_ -> {
                whiteButton.active = true;
                redButton.active = true;
                orangeButton.active = true;
                yellowButton.active = true;
                greenButton.active = true;
                blueButton.active = false;
                purpleButton.active = true;
                blackButton.active = true;
                color = "#0000ff";
            });
            blueButton.setFGColor(0x0000ff);
        }
        if(purpleButton == null){
            purpleButton = new ExtendedButton(95, 55, 15, 15, new StringTextComponent("■"), p_onPress_1_ -> {
                whiteButton.active = true;
                redButton.active = true;
                orangeButton.active = true;
                yellowButton.active = true;
                greenButton.active = true;
                blueButton.active = true;
                purpleButton.active = false;
                blackButton.active = true;
                color = "#af00ff";
            });
            purpleButton.setFGColor(0xaf00ff);
        }
        if(blackButton == null){
            blackButton = new ExtendedButton(110, 55, 15, 15, new StringTextComponent("■"), p_onPress_1_ -> {
                whiteButton.active = true;
                redButton.active = true;
                orangeButton.active = true;
                yellowButton.active = true;
                greenButton.active = true;
                blueButton.active = true;
                purpleButton.active = true;
                blackButton.active = false;
                color = "#000000";
            });
            blackButton.setFGColor(0x000000);
            whiteButton.active = false;
        }

        addButton(whiteButton);
        addButton(redButton);
        addButton(orangeButton);
        addButton(yellowButton);
        addButton(greenButton);
        addButton(blueButton);
        addButton(purpleButton);
        addButton(blackButton);
    }

    @Override
    public void sendMessage(String text,boolean addToChat){
        text = net.minecraftforge.event.ForgeEventFactory.onClientSendMessage(text);
        if (text.isEmpty()) return;
        if (addToChat) {
            this.minecraft.ingameGUI.getChatGUI().addToSentMessages(text);
        }
        //if (net.minecraftforge.client.ClientCommandHandler.instance.executeCommand(mc.player, msg) != 0) return; //Forge: TODO Client command re-write

        LOGGER.info(text);
        if (text.charAt(0) == '/') {
            this.minecraft.player.sendChatMessage(text);
        }else {
            this.minecraft.player.sendChatMessage(text + AddTag());
        }
    }

    static int type = 0;
    static String color = "#ffffff";
    static int size = 1;


    private String AddTag(){
        return String.format("[type:%d]",type) + String.format("[color:%s]",color) + String.format("[size:%d]",size);
    }

}
