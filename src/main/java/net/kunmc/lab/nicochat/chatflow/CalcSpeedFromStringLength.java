package net.kunmc.lab.nicochat.chatflow;

public class CalcSpeedFromStringLength {
    public float Calc(String str){
        float tmp = 0;
        if(str.length() < 10){
            tmp = 0.1f;
        }else if(str.length() < 20){
            tmp = (float) ((str.length() - 10)*0.1);
        }else {
            tmp = 1;
        }
        return tmp;
    }
}
