package com.nju.edu.sprite;

import com.nju.edu.world.World;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Zyi
 */
public class Sprite extends GameObject {

    protected int speed = 1;

    public Sprite(World world, int width, int height, BufferedImage image) {
        super(world, width, height, image);
    }

    @Override
    public void move(long time) {

    }

    @Override
    public void draw(Graphics g) {
        // 在(x, y)处绘制图片，width和height参数来进行缩放，注意比例
        g.drawImage(this.image, this.tile.getxPos(), this.tile.getyPos(), width, height, null);
    }
}
