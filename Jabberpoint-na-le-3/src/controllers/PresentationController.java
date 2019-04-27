package controllers;

import models.NavigationBehavior;
import models.NavigationBehaviors;
import models.Presentation;
import models.factories.DefaultNavigationBehaviorFactory;
import models.factories.NavigationBehaviorFactory;

public class PresentationController {
	Presentation presentation;
	NavigationBehaviorFactory navigationBehaviorFactory;
	
	public PresentationController(Presentation presentation) {
		this.presentation = presentation;
		navigationBehaviorFactory = new DefaultNavigationBehaviorFactory();
	}
	public void forward() {
		NavigationBehavior navigationBehavior = navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE, presentation);
		navigationBehavior.next();
	}
	
	public void backward() {
		NavigationBehavior navigationBehavior = navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE, presentation);
		navigationBehavior.previous();
	}
	
	public void nextSlide() {
		navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE, presentation);
		presentation.nextSlide();
	}
	
	public void previousSlide() {
		navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE, presentation);
		presentation.prevSlide();
	}
	
	public void nextSlideItem() {
		navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE_ITEM, presentation);
		presentation.getCurrentSlide().nextSlideItem();
	}
	
	public void previousSlideItem() {
		navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE_ITEM, presentation);
		presentation.getCurrentSlide().prevSlideItem();;
	}
	
	public void clearPresentation() {
		presentation.clear();
	}
	
	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}
	
	public void setSlideNumber(int slideNumber) {
		this.presentation.setSlideNumber(slideNumber);
	}
	
	public Presentation getPresentation() {
		return this.presentation;
	}
	
	public void exitPresentation() {
		this.presentation.exit(0);
	}
	
}
