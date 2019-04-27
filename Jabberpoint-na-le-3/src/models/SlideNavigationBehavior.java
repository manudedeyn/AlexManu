package models;

public class SlideNavigationBehavior extends NavigationBehavior {
	public SlideNavigationBehavior(Presentation presentation) {
		super(presentation);
	}

	@Override
	public boolean next() {
		Slide slide = adaptee.getCurrentSlide();		
		adaptee.nextSlide();
		
		return slide != adaptee.getCurrentSlide();
	}

	@Override
	public boolean previous() {
		Slide slide = adaptee.getCurrentSlide();
		adaptee.prevSlide();
		
		return slide != adaptee.getCurrentSlide();
	}
}
