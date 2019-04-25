package models.factories;

import models.Presentation;
import models.Slide;
import models.SlideItem;

public abstract class PresentationBuilder {
	public abstract Presentation createPresentation();
	public abstract Slide createSlide(String title);
	public abstract SlideItem createSlideItem(String type, String text, int level);
	public abstract Presentation getPresentation();
}
