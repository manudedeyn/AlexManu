package models.factories;

import models.DrawBehavior;
import models.DrawBehaviors;
import models.SlideDrawBehavior;
import models.SlideItemDrawBehavior;

public class DefaultDrawBehaviorFactory extends DrawBehaviorFactory {
	@Override
	public DrawBehavior createDrawBehavior(DrawBehaviors behavior) {
		switch(behavior) {
			case SLIDE: return new SlideDrawBehavior();
			case SLIDE_ITEM: return new SlideItemDrawBehavior();
				
			default:
				return new SlideDrawBehavior();
		}
	}
}
