package net.kunmc.lab.nicochat.ChatAnalysis.Test;

import net.kunmc.lab.nicochat.ChatAnalysis.ChatAnalysisColor;
import net.kunmc.lab.nicochat.ChatAnalysis.ChatAnalysisSize;
import net.kunmc.lab.nicochat.ChatAnalysis.ChatAnalysisType;
import net.kunmc.lab.nicochat.chatflow.chats.NicoChatType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ChatAnalysisTest {

    @Test
    public void ColorTest(){
        assertEquals(0xffffff,ChatAnalysisColor.GetColor("[color:aa]"));
        assertEquals(0xffffff,ChatAnalysisColor.GetColor(""));
        assertEquals(0xffffff,ChatAnalysisColor.GetColor("ああああ"));
        assertEquals(0xffffff,ChatAnalysisColor.GetColor("[color:#13"));
        assertEquals(0xffffff,ChatAnalysisColor.GetColor("color:#00ff00"));


        assertEquals(0xffffff,ChatAnalysisColor.GetColor("[color:#13]"));
        assertEquals(0x000000,ChatAnalysisColor.GetColor("[color:#000000]"));
        assertEquals(0xff0000,ChatAnalysisColor.GetColor("[color:#ff0000]"));
        assertEquals(0x15f6a1,ChatAnalysisColor.GetColor("[color:#15f6a1]"));
        assertEquals(0x15f6a1,ChatAnalysisColor.GetColor("ああああ[size:1][color:#15f6a1]ああああ"));
        assertEquals(0x15f6a1,ChatAnalysisColor.GetColor("[size:1][type:0][color:#15f6a1]ああああああ"));
    }
    @Test
    public void SizeTest(){
        assertEquals(2,ChatAnalysisSize.GetSize(""));
        assertEquals(2,ChatAnalysisSize.GetSize("ああああああああ"));
        assertEquals(2,ChatAnalysisSize.GetSize("[size:]"));
        assertEquals(2,ChatAnalysisSize.GetSize("size:5"));


        assertEquals(1,ChatAnalysisSize.GetSize("[size:1]"));
        assertEquals(9,ChatAnalysisSize.GetSize("[size:9]"));
        assertEquals(1,ChatAnalysisSize.GetSize("ああああ[size:1][color:#15f6a1]ああああ"));
        assertEquals(5,ChatAnalysisSize.GetSize("[size:5][type:0][color:#15f6a1]ああああああ"));

    }
    @Test
    public void TypeTest(){
        assertEquals(NicoChatType.Normal,ChatAnalysisType.GetType("[type:-1]"));
        assertEquals(NicoChatType.Normal,ChatAnalysisType.GetType("type:2"));
        assertEquals(NicoChatType.Normal,ChatAnalysisType.GetType(""));
        assertEquals(NicoChatType.Normal,ChatAnalysisType.GetType("あああああああああ"));
        assertEquals(NicoChatType.Normal,ChatAnalysisType.GetType("[type:50]"));


        assertEquals(NicoChatType.Normal,ChatAnalysisType.GetType("[type:0]"));
        assertEquals(NicoChatType.Top,ChatAnalysisType.GetType("[type:1]"));
        assertEquals(NicoChatType.Under,ChatAnalysisType.GetType("[type:2]"));
        assertEquals(NicoChatType.Under,ChatAnalysisType.GetType("あ[type:2]あああ[size:1][color:#15f6a1]ああああ"));
        assertEquals(NicoChatType.Normal,ChatAnalysisType.GetType("[size:5][type:0][color:#15f6a1]ああああああ"));

    }
}
