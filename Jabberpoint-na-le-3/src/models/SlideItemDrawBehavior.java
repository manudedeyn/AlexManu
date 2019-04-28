package models;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

public class SlideItemDrawBehavior extends DrawBehavior {


	public void draw(Slide slide, Graphics g, Rectangle area, ImageObserver view) {
		float scale = getScale(area);
	    int y = area.y;
	    Vector<SlideItem> items = slide.getSlideItems();
	    int currentSlideItemNumber = items.indexOf(slide.getCurrentItem());
		
	    //De titel hoeft niet meer apart behandeld te worden 
	    SlideItem slideItem = slide.title;
	    
	    Style style = Style.getStyle(slideItem.getLevel());
	    
	    slideItem.draw(area.x, y, scale, g, style, view);
	    
	    y += slideItem.getBoundingBox(g, view, scale, style).height;
	    //Enkel slideitems laten zien waarvan de index kleiner is dan currentSlideItem
	    for (int number = 0; number < currentSlideItemNumber; number++) {
	   
	      slideItem = (SlideItem)items.elementAt(number);
	      
	      style = Style.getStyle(slideItem.getLevel());
	      
	      slideItem.draw(area.x, y, scale, g, style, view);
	      
	      y += slideItem.getBoundingBox(g, view, scale, style).height;
	    }
	  }	
	

	
	// geef de schaal om de slide te kunnen tekenen
	private float getScale(Rectangle area) {
		return Math.min(((float)area.width) / ((float)Slide.WIDTH), ((float)area.height) / ((float)Slide.HEIGHT));
	}

}
