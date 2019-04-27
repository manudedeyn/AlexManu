package models;

public abstract class NavigationBehavior {
	protected Presentation adaptee;
	
	protected NavigationBehavior(Presentation presentation) {
		adaptee = presentation;
	}

	public abstract boolean next();	
	
	public abstract boolean previous();
}
