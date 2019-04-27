package controllers;

import models.NavigationBehavior;
import models.NavigationBehaviors;
import models.Presentation;
import models.factories.DefaultNavigationBehaviorFactory;
import models.factories.NavigationBehaviorFactory;
import views.SlideViewerComponent;

public class PresentationController {
	Presentation presentation;
	NavigationBehaviorFactory navigationBehaviorFactory;
	SlideViewerComponent slideViewerComponent;
	
	public PresentationController(Presentation presentation, SlideViewerComponent slideViewerComponent) {
		this.presentation = presentation;
		this.navigationBehaviorFactory = new DefaultNavigationBehaviorFactory();
		this.slideViewerComponent = slideViewerComponent;
	}
	public void forward() {
		NavigationBehavior slideItemNavigationBehavior = navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE_ITEM, presentation);
		if(slideItemNavigationBehavior.next() == false) {
			NavigationBehavior slideNavigationBehavior = navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE, presentation);
			slideNavigationBehavior.next();
		};
		slideViewerComponent.repaint();
	}
	
	public void backward() {
		NavigationBehavior slideItemnavigationBehavior = navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE_ITEM, presentation);
		if(slideItemnavigationBehavior.previous() == false) {
			NavigationBehavior slideNavigationBehavior = navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE, presentation);
			slideNavigationBehavior.previous();
		};
		slideViewerComponent.repaint();
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
