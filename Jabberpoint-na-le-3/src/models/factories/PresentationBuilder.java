package models.factories;

import models.Presentation;
import models.Slide;
import models.SlideItem;

public abstract class PresentationBuilder {
	public static PresentationBuilder getInstance() {
		// In de echte wereld zouden we dit configureerbaar maken.
		return new DefaultPresentationBuilder();
	}
	
	public abstract PresentationBuilder createPresentation(String title);
	public abstract PresentationBuilder createSlide(String title, String transition);
	public abstract PresentationBuilder createSlideItem(String type, String text, int level);

//Ik denk niet dat een PresentationBuilder effectief een presentation moet hebben moeten we dus bijwerken in het class diagram
	public abstract Presentation getPresentation();
}
