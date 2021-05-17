package net.kunmc.lab.nicochat.chatflow.util;

public class CalcSpeedFromStringLength {
    public static float Calc(String str){
        int tmp = 0;
        if(str.length() < 50){
            tmp = 1;
        }else{
            tmp = 1 + (str.length()-50) / 30;
        }
        return tmp;
    }
}
