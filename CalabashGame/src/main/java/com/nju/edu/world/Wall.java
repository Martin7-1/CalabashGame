package com.nju.edu.world;

import com.nju.edu.util.ReadImage;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Zyi
 */
public class Wall extends Thing {

    private static BufferedImage image = ReadImage.wall;

    public Wall(World world) {
        super(image, world);
    }
}
