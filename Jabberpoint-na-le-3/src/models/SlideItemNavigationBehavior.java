package models;

public class SlideItemNavigationBehavior extends NavigationBehavior {
	public SlideItemNavigationBehavior(Presentation presentation) {
		super(presentation);
	}

	@Override
	public boolean next(Presentation presentation) {
		Slide slide = presentation.getCurrentSlide();
		return false;
	}

	@Override
	public boolean previous(Presentation presentation) {
		// TODO Auto-generated method stub
		return false;
	}
}
