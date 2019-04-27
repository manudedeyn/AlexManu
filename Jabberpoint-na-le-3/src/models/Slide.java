package models;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;
import java.util.function.BooleanSupplier;

import models.factories.TransitionFactory;

/** <p>Een slide. Deze klasse heeft tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide {
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	protected final static int NO_ITEM = -1;
	/* Geen String meer maar een TextItem */
	protected TextItem title; // de titel wordt apart bewaard
	protected SlideItem currentSlideItem;
	protected Vector<SlideItem> items; // de slide-items worden in een Vector bewaard
	protected String transitionType; 
	protected int currentSlideItemNumber = -1;
	

	public Slide() {
		items = new Vector<SlideItem>();
	}

	public Slide(String transitionType) {
		this();
		this.transitionType = transitionType;
	}

	// Voeg een SlideItem toe
	public void append(SlideItem anItem) {
		items.addElement(anItem);
	}

	// geef de titel van de slide
	public String getTitle() {
		/* Geef nu de tekst van het TextItem terug */
		return title.getText();
	}

	// verander de titel van de slide
	public void setTitle(SlideItem titleItem) {
		/* Creëer nu een TextItem op basis van de nieuwe titel */
		title = (TextItem) titleItem;
	}

	// geef het betreffende SlideItem
	public SlideItem getSlideItem(int number) {
		return (SlideItem)items.elementAt(number);
	}

	// geef alle SlideItems in een Vector
	public Vector<SlideItem> getSlideItems() {
		return items;
	}
	
	public void setCurrentSlideItem(SlideItem item) {
		this.currentSlideItem = item;
	}
	
	public void nextSlideItem() {
		if(items.indexOf(currentSlideItem) <= items.size()) {
			this.setCurrentSlideItem(items.get(items.indexOf(currentSlideItem) + 1));
		}
	}
	
	public void prevSlideItem() {
		if(items.indexOf(currentSlideItem) > 0) {
			this.setCurrentSlideItem(items.get(items.indexOf(currentSlideItem) - 1));
		}
	}
	
	public SlideItem getCurrentSlideItem() {
		return this.currentSlideItem;
	}
	
	// geef de afmeting van de Slide
	public int getSize() {
		return items.size();
	}
	
	public Transition getTransition() {
		TransitionTypes type = transitionType == null ? TransitionTypes.UNSPECIFIED : TransitionTypes.valueOf(transitionType);
		return TransitionFactory.getInstance().createTransition(type);
	}	
	
	//moet aangepast worden om niet alle slideItems te showen
	public void draw(Graphics g, Rectangle area, ImageObserver view) {
		float scale = getScale(area);
	    int y = area.y;
		
	    /* De titel hoeft niet meer apart behandeld te worden */
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
	  }

	// geef de schaal om de slide te kunnen tekenen
	private float getScale(Rectangle area) {
		return Math.min(((float)area.width) / ((float)WIDTH), ((float)area.height) / ((float)HEIGHT));
	}

	public boolean nextItem() {
		if (currentSlideItemNumber + 1 < items.size()) {
			currentSlideItemNumber++;
			return true;
		}
		
		return false;
	}
	
	public SlideItem getCurrentItem() {
		if (currentSlideItemNumber == NO_ITEM) {
			return null;
		}
		
		return items.get(currentSlideItemNumber);
	}

	public boolean previousItem() {
		if (items.size() == 0) {
			return false;
		}
		else if (currentSlideItemNumber - 1 >= 0) {
			currentSlideItemNumber--;
			return true;
		}		
		
		return false;		
	}
}
