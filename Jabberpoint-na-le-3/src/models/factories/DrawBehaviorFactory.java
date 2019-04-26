package models.factories;

import models.DrawBehavior;
import models.DrawBehaviors;

public abstract class DrawBehaviorFactory {
	public static final DrawBehaviorFactory getInstance() {
		return new DefaultDrawBehaviorFactory();		
	}

	public abstract DrawBehavior createDrawBehavior(DrawBehaviors behavior);
}
