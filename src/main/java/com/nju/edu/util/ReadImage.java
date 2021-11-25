package com.nju.edu.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Zyi
 */
public class ReadImage {

    public static BufferedImage MonsterOne;
    public static BufferedImage MonsterTwo;
    public static BufferedImage MonsterThree;

    public static BufferedImage Calabash;
    public static BufferedImage GrandFather;

    public static BufferedImage MonsterBullet;
    public static BufferedImage CalabashBullet;

    public static BufferedImage startBackground;
    public static BufferedImage runningBackground;

    public static BufferedImage blast;

    static {
        try {
            MonsterOne = ImageIO.read(new FileInputStream("D:\\Java\\Programs\\JavaAdvancedProgramming\\CalabashGame\\image\\monster1.png"));
            MonsterTwo = ImageIO.read(new FileInputStream("D:\\Java\\Programs\\JavaAdvancedProgramming\\CalabashGame\\image\\monster2.png"));
            MonsterThree = ImageIO.read(new FileInputStream("D:\\Java\\Programs\\JavaAdvancedProgramming\\CalabashGame\\image\\monster3.png"));
            Calabash = ImageIO.read(new FileInputStream("D:\\Java\\Programs\\JavaAdvancedProgramming\\CalabashGame\\image\\calabash.png"));
            GrandFather = ImageIO.read(new FileInputStream("D:\\Java\\Programs\\JavaAdvancedProgramming\\CalabashGame\\image\\grandfather.png"));
            MonsterBullet = ImageIO.read(new FileInputStream("D:\\Java\\Programs\\JavaAdvancedProgramming\\CalabashGame\\image\\monsterBullet.png"));
            CalabashBullet = ImageIO.read(new FileInputStream("D:\\Java\\Programs\\JavaAdvancedProgramming\\CalabashGame\\image\\calabashBullet.png"));
            // TODO: find a background image
            startBackground = ImageIO.read(new FileInputStream("D:\\Java\\Programs\\JavaAdvancedProgramming\\CalabashGame\\image\\startBg.png"));
            runningBackground = ImageIO.read(new FileInputStream("D:\\Java\\Programs\\JavaAdvancedProgramming\\CalabashGame\\image\\runningBg.png"));
            blast = ImageIO.read(new FileInputStream("D:\\Java\\Programs\\JavaAdvancedProgramming\\CalabashGame\\image\\blast.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
