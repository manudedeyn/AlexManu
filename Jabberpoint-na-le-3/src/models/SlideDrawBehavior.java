package models;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class SlideDrawBehavior extends DrawBehavior {

	@Override
	public void draw(Slide slide) {
		
		//moet aangepast worden om niet alle slideItems te showen
	/*	public void draw(Graphics g, Rectangle area, ImageObserver view) {
			float scale = getScale(area);
		    int y = area.y;
			
		    //De titel hoeft niet meer apart behandeld te worden 
		    SlideItem slideItem = this.title;
		    
		    Style style = Style.getStyle(slideItem.getLevel());
		    
		    slideItem.draw(area.x, y, scale, g, style, view);
		    
		    y += slideItem.getBoundingBox(g, view, scale, style).height;
		    //Enkel slideitems laten zien waarvan de index kleiner is dan currentSlideItem
		    for (int number=0; number<currentSlideItemNumber; number++) {
		      slideItem = (SlideItem)getSlideItems().elementAt(number);
		      
		      style = Style.getStyle(slideItem.getLevel());
		      
		      slideItem.draw(area.x, y, scale, g, style, view);
		      
		      y += slideItem.getBoundingBox(g, view, scale, style).height;
		    }
		  }		*/
	}

}
