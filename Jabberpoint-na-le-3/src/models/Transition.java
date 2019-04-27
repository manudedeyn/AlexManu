package models;

public abstract class Transition {
	protected Transition() { }
	
	public boolean forward(Presentation presentation) {
		NavigationBehavior navigation = getNavigationBehavior(presentation);
		boolean didNavigate = navigation.next(presentation);
		
		if (didNavigate) {			
			DrawBehavior drawing = getDrawBehavior();
			drawing.draw(presentation.getCurrentSlide());
		}
		
		return didNavigate;
	}
	
	public boolean backward(Presentation presentation) {
		NavigationBehavior navigation = getNavigationBehavior(presentation);
		boolean didNavigate = navigation.previous(presentation);
		
		if (didNavigate) {			
			DrawBehavior drawing = getDrawBehavior();
			drawing.draw(presentation.getCurrentSlide());
		}
		
		return didNavigate;
	}
	
	protected abstract NavigationBehavior getNavigationBehavior(Presentation presentation);
	
	protected abstract DrawBehavior getDrawBehavior();
}