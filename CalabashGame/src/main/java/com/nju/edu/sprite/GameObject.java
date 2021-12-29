package com.nju.edu.sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Zyi
 */
public abstract class GameObject implements Serializable {

    private static final long serialVersionUID = 2841309359403190861L;
    /**
     * 物体的x坐标
     */
    protected Integer x;
    /**
     * 物体的y坐标
     */
    protected Integer y;
    /**
     * 物体的宽度
     */
    protected Integer width;
    /**
     * 物体的高度
     */
    protected Integer height;
    /**
     * 物体的图片
     */
    transient BufferedImage image;

    public GameObject() {

    }

    public GameObject(int x, int y, int width, int height, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    /**
     * 游戏物体的移动
     */
    public abstract void move(long time);

    /**
     * 渲染此GameObject
     * @param g 目标graphics
     */
    public void draw(Graphics g) {

    }

    /**
     * 判断两个游戏物体是否相碰
     * @param g1 游戏物体1
     * @param g2 游戏物体2
     * @return true if the two gameObject is collided, false otherwise
     */
    public static boolean isCollide(GameObject g1, GameObject g2) {
        //step1: 求出两个矩形的中心点
        int f1x = g1.x + g1.width / 2;
        int f1y = g1.y + g1.height / 2;
        int f2x = g2.x + g2.width / 2;
        int f2y = g2.y + g2.height / 2;

        //step2: 横向和纵向碰撞检测
        boolean H = Math.abs(f1x - f2x) < (g1.width + g2.width)/2;
        boolean V = Math.abs(f1y -f2y) < (g1.height + g2.height)/2;

        //step3: 必须两个方向同时碰撞
        return H && V;
    }

    /**
     * 设置坐标
     * @param x 新的x坐标
     * @param y 新的y坐标
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 移动指定偏移的坐标
     * @param dx x坐标的偏移量
     * @param dy y坐标的偏移量
     */
    public void transfer(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        // 存储照片
        ImageIO.write(this.image, "jpg", out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.image = ImageIO.read(in);
    }
}
