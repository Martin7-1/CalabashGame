package com.nju.edu.world;

import com.nju.edu.sprite.GameObject;
import com.nju.edu.util.ReadImage;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Zyi
 */
public class Wall extends GameObject {

    private static BufferedImage image = ReadImage.wall;

    public Wall(World world) {
        super(world, 50, 50, image);
    }

    @Override
    public void move(long time) {

    }
}
