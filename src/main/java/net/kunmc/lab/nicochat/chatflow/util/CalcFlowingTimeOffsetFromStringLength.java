package net.kunmc.lab.nicochat.chatflow.util;

public class CalcFlowingTimeOffsetFromStringLength {
    public static float Calc(String str,int size){
        return str.length() * 40 * size;
    }
}
