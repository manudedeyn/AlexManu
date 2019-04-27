package tests.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.Presentation;
import models.Slide;
import models.SlideTransition;
import models.TextItem;

class SlideTransitionTests {
	private SlideTransition target;
	private Presentation presentation;
	
	public SlideTransitionTests() {
		target = new SlideTransition();
		
		presentation = new Presentation();
		presentation.append(new Slide());
		presentation.append(new Slide());
	}
	
	@Test
	void forward_returns_true_when_transitions_forwards() {
		assertTrue(target.forward(presentation));
	}
	
	@Test
	void forward_returns_false_when_at_last_slide() {
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
	void backward_returns_false_when_at_first_slide() {
		target.forward(presentation);
		target.backward(presentation);
		
		boolean actual = target.backward(presentation);
		assertFalse(actual);
	}

}
