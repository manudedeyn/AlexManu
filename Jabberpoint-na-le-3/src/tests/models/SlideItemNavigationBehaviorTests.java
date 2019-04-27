package tests.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.Presentation;
import models.Slide;
import models.SlideItemNavigationBehavior;
import models.TextItem;

class SlideItemNavigationBehaviorTests {
	private Presentation presentation;
	private SlideItemNavigationBehavior target;
	
	public SlideItemNavigationBehaviorTests() {		
		presentation = new Presentation();		
		target = new SlideItemNavigationBehavior(presentation);
	}
	
	@Test
	void next_returns_false_when_no_slide_items() {
		assertFalse(target.next());
	}
	
	@Test
	void next_returns_false_for_slide_without_items() {
		presentation.append(new Slide());
		
		assertFalse(target.next());
	}
	
	@Test
	void next_returns_true_for_slide_with_items() {
		Slide slide = new Slide();
		slide.append(new TextItem());
		presentation.append(slide);
		presentation.setSlideNumber(0);		
		
		assertTrue(target.next());
	}
	
	@Test
	void previous_returns_false_when_no_slide_items() {
		assertFalse(target.previous());
	}
	
	@Test
	void previous_returns_false_for_slide_without_items() {
		presentation.append(new Slide());
		
		assertFalse(target.previous());
	}
	
	@Test
	void previous_returns_true_for_slide_with_items() {
		Slide slide = new Slide();
		slide.append(new TextItem());
		slide.append(new TextItem());
		slide.nextItem();
		slide.nextItem();		
		presentation.append(slide);
		presentation.setSlideNumber(0);		
		
		assertTrue(target.previous());
	}
}
