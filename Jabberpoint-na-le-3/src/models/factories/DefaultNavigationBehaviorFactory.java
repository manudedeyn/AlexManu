package models.factories;

import models.NavigationBehavior;
import models.NavigationBehaviors;
import models.Presentation;
import models.SlideNavigationBehavior;
import models.SlideItemNavigationBehavior;

public class DefaultNavigationBehaviorFactory extends NavigationBehaviorFactory {

	@Override
	public NavigationBehavior createNavigation(NavigationBehaviors type, Presentation presentation) {				
		switch(type) {
			case SLIDE: return new SlideNavigationBehavior(presentation);				
			case SLIDE_ITEM: return new SlideItemNavigationBehavior(presentation);
			
			default:
				return new SlideNavigationBehavior(presentation);
		}
	}
}
