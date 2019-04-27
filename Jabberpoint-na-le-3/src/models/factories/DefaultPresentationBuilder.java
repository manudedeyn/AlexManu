package models.factories;

import models.BitmapItem;
import models.Presentation;
import models.Slide;
import models.SlideItem;
import models.TextItem;

public class DefaultPresentationBuilder extends PresentationBuilder{
	
	
	@Override
	public Presentation createPresentation() {
	 return new Presentation();
	}

	@Override
	public Slide createSlide(String title) {
		Slide slide = new Slide();
		slide.setTitle(this.createSlideItem("text", title, 0));
		return slide;
	}

	@Override
	public SlideItem createSlideItem(String type, String text, int level) {

		switch(type) {
		case "bitmap":
			return new BitmapItem(level, text);
		case "text":
			return new TextItem(level, text);
			//aangezien text items het meest standaard zijn..
		default: return new TextItem(level, text);
		}
		
	}


}
