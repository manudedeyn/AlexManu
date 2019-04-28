package models;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public abstract class DrawBehavior {

	public abstract void draw(Slide slide, Graphics g, Rectangle area, ImageObserver view);

}
