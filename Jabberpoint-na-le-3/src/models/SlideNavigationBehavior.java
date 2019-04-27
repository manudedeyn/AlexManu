package models;

public class SlideNavigationBehavior extends NavigationBehavior {
	public SlideNavigationBehavior(Presentation presentation) {
		super(presentation);
	}

	@Override
	public boolean next(Presentation presentation) {
		Slide slide = presentation.getCurrentSlide();		
		presentation.nextSlide();
		
		return slide != presentation.getCurrentSlide();
	}

	@Override
	public boolean previous(Presentation presentation) {
		Slide slide = presentation.getCurrentSlide();
		presentation.prevSlide();
		
		return slide != presentation.getCurrentSlide();
	}
}
