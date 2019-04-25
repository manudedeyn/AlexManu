package models.factories;

import models.BitmapItem;
import models.Presentation;
import models.Slide;
import models.SlideItem;
import models.TextItem;

public class ConcretePresentationBuilder extends PresentationBuilder{
	
	Presentation presentation;
	
	@Override
	public Presentation createPresentation() {

		presentation = new Presentation();
		return presentation;
	}

	@Override
	public Slide createSlide(String title) {
		Slide slide = new Slide();
		slide.setTitle(title);
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

	@Override
	public Presentation getPresentation() {
		return presentation;
	}

}
