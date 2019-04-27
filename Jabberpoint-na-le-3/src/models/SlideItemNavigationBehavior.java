package models;

public class SlideItemNavigationBehavior extends NavigationBehavior {
	public SlideItemNavigationBehavior(Presentation presentation) {
		super(presentation);
	}

	@Override
	public boolean next() {
		Slide slide = super.adaptee.getCurrentSlide();
		
		if (slide == null) {
			return false;
		}
		
		return slide.nextItem();
	}

	@Override
	public boolean previous() {
		Slide slide = super.adaptee.getCurrentSlide();
		
		if (slide == null) {
			return false;
		}
		
		return slide.previousItem();
	}
}
