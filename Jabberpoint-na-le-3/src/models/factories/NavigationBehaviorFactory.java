package models.factories;

import models.NavigationBehavior;
import models.NavigationBehaviors;
import models.Presentation;

public abstract class NavigationBehaviorFactory {
	public static final NavigationBehaviorFactory getInstance() {
		// Just return the default implementation. We should get the actual type by means of configuration instead.
		return new DefaultNavigationBehaviorFactory();		
	}
	
	public abstract NavigationBehavior createNavigation(NavigationBehaviors behavior, Presentation presentation);
}
