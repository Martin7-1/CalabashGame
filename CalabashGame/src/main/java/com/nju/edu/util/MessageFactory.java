package com.nju.edu.util;

/**
 * @author Zyi
 */
public class MessageFactory {

    private MessageFactory() {

    }

    /**
     * 获得消息类型
     * @param message 消息
     * @return 消息的类型
     */
    public static Message createMessage(String message) {
        String[] temp = message.split(",");
        Message msg = null;
        switch (temp[temp.length - 1]) {
            case "CalabashMove":
                msg = Message.Calabash_Move;
                break;
            case "CalabashBullet":
                msg = Message.Calabash_Shoot;
                break;
            case "MonsterOne":
                msg = Message.Monster_One;
                break;
            case "MonsterTwo":
                msg = Message.Monster_Two;
                break;
            case "MonsterThree":
                msg = Message.Monster_Three;
            case "MonsterBullet":
                msg = Message.Monster_Shoot;
                break;
            default:
        }

        return msg;
    }
}
