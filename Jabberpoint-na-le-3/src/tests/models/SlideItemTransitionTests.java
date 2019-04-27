package tests.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.DrawBehavior;
import models.NavigationBehavior;
import models.Presentation;
import models.Slide;
import models.SlideItemTransition;
import models.SlideTransition;
import models.TextItem;

class SlideItemTransitionTests {
	private SlideItemTransition target;
	private Presentation presentation;
	
	public SlideItemTransitionTests() {
		target = new SlideItemTransition();
		
		Slide slide1 = new Slide();
		slide1.append(new TextItem());
		slide1.append(new TextItem());
		
		Slide slide2 = new Slide();
		slide2.append(new TextItem());
		slide2.append(new TextItem());
		
		presentation = new Presentation();
		presentation.append(slide1);
		presentation.append(slide2);
		presentation.setSlideNumber(0);
	}
	
	@Test
	void forward_returns_true_when_transitions_forwards() {		
		assertTrue(target.forward(presentation));
	}
	
	@Test
	void forward_returns_false_when_at_last_slide_item() {
		target.forward(presentation);
		target.forward(presentation);
		boolean actual = target.forward(presentation);
		
		assertFalse(actual);
	}
	
	@Test
	void backward_returns_true_when_transitions_backwards() {
		target.forward(presentation);
		target.forward(presentation);
		
		boolean actual = target.backward(presentation);
		assertTrue(actual);
	}
	
	@Test
	void backward_returns_false_when_at_first_slide_item() {
		target.forward(presentation);
		target.backward(presentation);
		
		boolean actual = target.backward(presentation);
		assertFalse(actual);
	}
}
