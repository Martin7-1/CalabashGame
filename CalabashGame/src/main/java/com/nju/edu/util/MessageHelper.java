package com.nju.edu.util;

import com.nju.edu.bullet.CalabashBullet;
import com.nju.edu.bullet.MonsterBullet;
import com.nju.edu.control.GameController;
import com.nju.edu.sprite.MonsterOne;
import com.nju.edu.sprite.MonsterThree;
import com.nju.edu.sprite.MonsterTwo;
import com.sun.istack.internal.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Zyi
 */
public class MessageHelper {

    private MessageHelper() {

    }

    /**
     * 解析
     * @param bytes 消息字节
     * @param gameController 主界面
     */
    public static void decode(byte[] bytes, GameController gameController) {

    }

    private static byte[] decodeCalabash(GameController gameController) {
        return new byte[1024];
    }

    private static byte[] decodeCalabashBullet() {
        return null;
    }

    /**
     * 传输创建新的葫芦娃的消息
     * @param gameController 主界面
     * @return create new Calabash
     */
    @NotNull
    public static byte[] encodeNewClient(GameController gameController) {
        return "createCalabash".getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 传输移动的消息
     * @param gameController 主界面
     * @return message
     */
    @NotNull
    public static byte[] encodeMove(GameController gameController) {
        int x = gameController.getCalabashOne().getX();
        int y = gameController.getCalabashOne().getY();

        // format: x, y, calabashMove
        return ("" + x + ",y" + ",CalabashMove ").getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 传输射击的消息
     * @param gameController 主界面
     * @return message
     */
    @NotNull
    public static byte[] encodeShoot(GameController gameController) {
        List<CalabashBullet> list = gameController.getCalabashBulletList();
        StringBuilder message = new StringBuilder();
        message.append(list.size()).append(",");

        for (CalabashBullet bullet : list) {
            int x = bullet.getX();
            int y = bullet.getY();
            message.append(x).append(",").append(y).append(",");
        }
        message.append("CalabashBullet ");

        return message.toString().getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 传输怪物一的数量消息
     * @param gameController 主界面
     * @return message
     */
    @NotNull
    public static byte[] encodeMonsterOne(GameController gameController) {
        List<MonsterOne> list = gameController.getMonsterOneList();
        StringBuilder message = new StringBuilder();
        message.append(list.size()).append(",");

        for (MonsterOne monsterOne : list) {
            int x = monsterOne.getX();
            int y = monsterOne.getY();
            message.append(x).append(",").append(y).append(",");
        }
        message.append("MonsterOne ");

        return message.toString().getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 传输妖怪二的数量消息
     * @param gameController 主界面
     * @return message
     */
    @NotNull
    public static byte[] encodeMonsterTwo(GameController gameController) {
        List<MonsterTwo> list = gameController.getMonsterTwoList();
        StringBuilder message = new StringBuilder();
        message.append(list.size()).append(",");

        for (MonsterTwo monsterTwo : list) {
            int x = monsterTwo.getX();
            int y = monsterTwo.getY();
            message.append(x).append(",").append(y).append(",");
        }
        message.append("MonsterTwo ");

        return message.toString().getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 传输妖怪三的数量消息
     * @param gameController 主界面
     * @return message
     */
    @NotNull
    public static byte[] encodeMonsterThree(GameController gameController) {
        // format: i,x1,y1,x2,y2,...,xi,yi,monsterThree
        List<MonsterThree> list = gameController.getMonsterThreeList();
        // 还要返回位置
        StringBuilder message = new StringBuilder();
        message.append(list.size()).append(",");

        for (MonsterThree monsterThree : list) {
            int x = monsterThree.getX();
            int y = monsterThree.getY();
            message.append(x).append(",").append(y).append(",");
        }

        message.append("MonsterThree ");
        return message.toString().getBytes(StandardCharsets.UTF_8);
    }

    @NotNull
    public static byte[] encodeMonsterBullet(GameController gameController) {
        List<MonsterBullet> list = gameController.getMonsterBulletList();
        StringBuilder message = new StringBuilder();
        message.append(list.size()).append(",");

        for (MonsterBullet bullet : list) {
            int x = bullet.getX();
            int y = bullet.getY();
            message.append(x).append(",").append(y).append(",");
        }

        message.append("MonsterBullet ");
        return (message.toString()).getBytes(StandardCharsets.UTF_8);
    }
}
