package tests.models;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.Slide;
import models.SlideItem;
import models.TextItem;

class SlideTests {
	private Slide target;
	
	public SlideTests() {
		target = new Slide();
	}
	
	@Test
	void nextItem_returns_false_for_no_slide_items() {
		assertFalse(target.nextItem());		
	}
	
	@Test
	void nextItem_returns_true_when_next_item_available() {
		target.append(new TextItem());
		
		assertTrue(target.nextItem());		
	}
	
	@Test
	void nextItem_returns_false_when_at_last_item() {
		target.append(new TextItem());
		target.nextItem();
		
		assertFalse(target.nextItem());		
	}
	
	@Test
	void previousItem_returns_false_for_no_slide_items() {	
		assertFalse(target.previousItem());	
	}
	
	@Test
	void previousItem_returns_false_when_at_first_item() {		
		target.append(new TextItem());
		
		assertFalse(target.previousItem());	
	}
	
	@Test
	void previousItem_returns_false_when_at_first_item_after_nextItem_invocation() {		
		target.append(new TextItem());
		// Advance to the first slide item.
		target.nextItem();
		
		assertFalse(target.previousItem());	
	}
	
	@Test
	void previousItem_returns_true_when_previous_item_available() {		
		target.append(new TextItem());
		target.append(new TextItem());
		target.nextItem();
		target.nextItem();
		
		assertTrue(target.previousItem());	
	}
	
	@Test
	void getCurrentItem_returns_expected_SlideItem_after_nextItem_invocation() {
		SlideItem firstItem = new TextItem();
		SlideItem secondItem = new TextItem();
		target.append(firstItem);
		target.append(secondItem);		
		target.nextItem();
		
		SlideItem actual = target.getCurrentItem();
		
		assertEquals(firstItem, actual);
	}
	
	@Test
	void getCurrentItem_returns_expected_SlideItem_after_repeated_nextItem_invocations() {
		SlideItem firstItem = new TextItem();
		SlideItem secondItem = new TextItem();
		target.append(firstItem);
		target.append(secondItem);		
		target.nextItem();
		target.nextItem();
		
		SlideItem actual = target.getCurrentItem();
		
		assertEquals(secondItem, actual);
	}
	
	@Test
	void getCurrentItem_returns_expected_SlideItem_after_next_previous_invocations() {
		SlideItem firstItem = new TextItem();
		SlideItem secondItem = new TextItem();
		target.append(firstItem);
		target.append(secondItem);		
		target.nextItem();
		target.previousItem();
		
		SlideItem actual = target.getCurrentItem();
		
		assertEquals(firstItem, actual);
	}
}
