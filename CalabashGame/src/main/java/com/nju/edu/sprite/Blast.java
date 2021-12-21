package com.nju.edu.sprite;

import com.nju.edu.util.ReadImage;
import com.nju.edu.world.World;

import java.awt.image.BufferedImage;

/**
 * 爆炸特效类
 * @author Zyi
 */
public class Blast extends Sprite{

    public Blast(World world, int x, int y) {
        super(world, 100, 100, ReadImage.blast);
        setX(x - 20);
        setY(y - 20);
        world.put(this, getX(), getY());
    }
}
