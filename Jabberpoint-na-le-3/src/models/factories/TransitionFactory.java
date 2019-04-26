package models.factories;

import models.Transition;
import models.TransitionTypes;

public abstract class TransitionFactory {
	private static boolean isEnabled;
	
	public static final TransitionFactory getInstance() {
		// Just return the default implementation. We should get the actual type by means of configuration instead.
		return new DefaultTransitionFactory();		
	}
	
	public static boolean getIsEnabled() {
		return isEnabled;	
	}
	
	public static void setIsEnabled(boolean enabled) {
		isEnabled = enabled;		
	}
	
	public abstract Transition createTransition(TransitionTypes type);
}
