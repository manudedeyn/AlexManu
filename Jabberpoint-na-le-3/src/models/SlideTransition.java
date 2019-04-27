package models;

import models.factories.DrawBehaviorFactory;
import models.factories.NavigationBehaviorFactory;

public class SlideTransition extends Transition {
	@Override
	protected NavigationBehavior getNavigationBehavior(Presentation presentation) {
		return NavigationBehaviorFactory.getInstance().createNavigation(NavigationBehaviors.SLIDE, presentation);
	}

	@Override
	public DrawBehavior getDrawBehavior() {
		return DrawBehaviorFactory.getInstance().createDrawBehavior(DrawBehaviors.SLIDE);
	}
}
