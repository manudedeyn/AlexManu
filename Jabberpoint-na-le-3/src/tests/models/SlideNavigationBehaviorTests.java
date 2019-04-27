package tests.models;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.Presentation;
import models.Slide;
import models.SlideNavigationBehavior;

class SlideNavigationBehaviorTests {
	private Presentation presentation;
	private SlideNavigationBehavior target;
	
	public SlideNavigationBehaviorTests() {
		presentation = new Presentation();
		target = new SlideNavigationBehavior(presentation);
	}
	
	@Test
	void next_returns_false_for_no_slides() {
		assertFalse(target.next());
	}
	
	@Test
	void previous_returns_false_for_no_slides() {
		assertFalse(target.previous());
	}
	
	@Test
	void next_returns_true_for_slides() {
		presentation.append(new Slide());
		
		assertTrue(target.next());		
	}
	
	@Test
	void previous_returns_true_for_slides() {
		presentation.append(new Slide());
		presentation.append(new Slide());
		presentation.setSlideNumber(1);
		
		assertTrue(target.previous());		
	}

}
