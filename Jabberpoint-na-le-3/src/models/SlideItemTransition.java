package models;

import models.factories.DrawBehaviorFactory;
import models.factories.NavigationBehaviorFactory;

public class SlideItemTransition extends Transition {	
	@Override
	protected NavigationBehavior getNavigationBehavior(Presentation presentation) {
		return NavigationBehaviorFactory.getInstance().createNavigation(NavigationBehaviors.SLIDE_ITEM, presentation);
	}

	@Override
	public DrawBehavior getDrawBehavior() {
		return DrawBehaviorFactory.getInstance().createDrawBehavior(DrawBehaviors.SLIDE_ITEM);
	}
}
