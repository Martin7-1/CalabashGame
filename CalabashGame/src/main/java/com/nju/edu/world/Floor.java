package com.nju.edu.world;

import com.nju.edu.sprite.GameObject;
import com.nju.edu.util.ReadImage;

import java.awt.image.BufferedImage;

/**
 * @author Zyi
 */
public class Floor extends GameObject {

    private static BufferedImage image = ReadImage.floor;

    public Floor(World world) {
        super(world, 50, 50, image);
    }

    @Override
    public void move(long time) {
        // nothing to do
    }
}
