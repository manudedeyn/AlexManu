package models.factories;


import controllers.PresentationController;
import models.BitmapItem;
import models.Presentation;
import models.Slide;
import models.TextItem;

public class DefaultPresentationBuilder extends PresentationBuilder{
	Presentation presentation;
	
	@Override
	public PresentationBuilder createPresentation(String title) {
			this.presentation = new Presentation();
			this.presentation.setTitle(title);
		return this;
	}

	@Override
	public PresentationBuilder createSlide(String title, String transition) {
		Slide slide = new Slide(transition);
		slide.setTitle(new TextItem(0, title));
		presentation.append(slide);
		return this;
	}

	@Override
	public PresentationBuilder createSlideItem(String type, String text, int level) {
		
		switch(type) {
		case "bitmap":
			presentation.getSlides().get(presentation.getSlides().size()-1).append(new BitmapItem(level, text));
		case "text":
			presentation.getSlides().get(presentation.getSlides().size()-1).append(new TextItem(level, text));
		}
		return this;
		
	}

	@Override
	public Presentation getPresentation() {
		return presentation;
	}


}
