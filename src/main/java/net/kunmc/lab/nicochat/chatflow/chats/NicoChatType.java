package net.kunmc.lab.nicochat.chatflow.chats;

public enum NicoChatType {
    Normal(0),
    Top(1),
    Under(2);

    private final int number;
    NicoChatType(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}
