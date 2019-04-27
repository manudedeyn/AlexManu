package models.factories;

import models.Presentation;
import models.Slide;
import models.SlideItem;

public abstract class PresentationBuilder {
	public abstract Presentation createPresentation();
	public abstract Slide createSlide(String title);
	public abstract SlideItem createSlideItem(String type, String text, int level);
//Ik denk niet dat een PresentationBuilder effectief een presentation moet hebben moeten we dus bijwerken in het class diagram
//	public abstract Presentation getPresentation();
}
