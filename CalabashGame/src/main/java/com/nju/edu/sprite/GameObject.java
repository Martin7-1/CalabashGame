package com.nju.edu.sprite;

import com.nju.edu.world.Tile;
import com.nju.edu.world.World;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Zyi
 */
public abstract class GameObject {

    /**
     * 物体的宽度
     */
    protected int width;
    /**
     * 物体的高度
     */
    protected int height;
    /**
     * 物体的图片
     */
    BufferedImage image;

    protected World world;
    public Tile<? extends GameObject> tile;

    public void setTile(Tile<? extends GameObject> tile) {
        this.tile = tile;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public GameObject(World world, int width, int height, BufferedImage image) {
        this.world = world;
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
        int f1x = g1.tile.getxPos() + g1.width / 2;
        int f1y = g1.tile.getyPos() + g1.height / 2;
        int f2x = g2.tile.getxPos() + g2.width / 2;
        int f2y = g2.tile.getyPos() + g2.height / 2;

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
        this.tile.setxPos(x);
        this.tile.setyPos(y);
    }

    /**
     * 移动指定偏移的坐标
     * @param dx x坐标的偏移量
     * @param dy y坐标的偏移量
     */
    public void transfer(int dx, int dy) {
        this.tile.setxPos(this.tile.getxPos() + dx);
        this.tile.setyPos(this.tile.getyPos() + dy);
    }

    /**
     * TODO: 将游戏物体的移动替换成调用以下两个方法
     * @param dx 移动的距离
     */
    public void transferX(int dx) {
        this.tile.setxPos(getX() + dx);
    }

    public void transferY(int dy) {
        this.tile.setyPos(getY() + dy);
    }

    public int getX() {
        return this.tile.getxPos();
    }

    public void setX(int newX) {
        this.tile.setxPos(newX);
    }

    public int getY() {
        return this.tile.getyPos();
    }

    public void setY(int newY) {
        this.tile.setyPos(newY);
    }
}
