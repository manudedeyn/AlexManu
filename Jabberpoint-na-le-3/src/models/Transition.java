package models;

public abstract class Transition {
	protected Transition() { }
	
	public boolean forward(Presentation presentation) {
		NavigationBehavior navigation = getNavigationBehavior(presentation);
		return navigation.next();
	}
	
	public boolean backward(Presentation presentation) {
		NavigationBehavior navigation = getNavigationBehavior(presentation);
		return navigation.previous();
	}
	
	protected abstract NavigationBehavior getNavigationBehavior(Presentation presentation);
	
	public abstract DrawBehavior getDrawBehavior();
}
