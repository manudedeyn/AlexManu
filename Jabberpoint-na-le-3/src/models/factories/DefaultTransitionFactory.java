package models.factories;

import models.SlideTransition;
import models.SlideItemTransition;
import models.Transition;
import models.TransitionTypes;

public class DefaultTransitionFactory extends TransitionFactory {

	@Override
	public Transition createTransition(TransitionTypes type) {
		switch(type) {		
			case SLIDE: return new SlideTransition();
			case SLIDE_ITEM: return new SlideItemTransition();			
		
			default:
				return new SlideTransition();							
		}
	}
}
