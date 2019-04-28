package controllers;

import models.NavigationBehaviors;
import models.Presentation;
import models.Transition;
import models.factories.DefaultNavigationBehaviorFactory;
import models.factories.NavigationBehaviorFactory;
import views.SlideViewerComponent;

public class PresentationController {
	Presentation presentation;
	NavigationBehaviorFactory navigationBehaviorFactory;
	SlideViewerComponent slideViewerComponent;
	
	public PresentationController(Presentation presentation) {
		this.presentation = presentation;
		this.navigationBehaviorFactory = new DefaultNavigationBehaviorFactory();
		presentation.setPresentationController(this);
	}
	
	public void setSlideViewerComponent(SlideViewerComponent slideViewerComponent) {
		this.slideViewerComponent = slideViewerComponent;
	}
	
	public void forward() {
		Transition transition = presentation.getCurrentSlide().getTransition();
		
		if (!transition.forward(presentation)) {
			nextSlide();
		}
		
		slideViewerComponent.update();
	}
	
	public void backward() {
		Transition transition = presentation.getCurrentSlide().getTransition();
		
		if (!transition.backward(presentation)) {
			previousSlide();
		}
		
		slideViewerComponent.update();
	}
	
	public void nextSlide() {
		navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE, presentation).next();
	}
	
	public void previousSlide() {
		navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE, presentation).previous();
	}
	
	public void nextSlideItem() {
		navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE_ITEM, presentation).next();
	}
	
	public void previousSlideItem() {
		navigationBehaviorFactory.createNavigation(NavigationBehaviors.SLIDE_ITEM, presentation).previous();
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
	
	public String getTitle() {
		return presentation.getTitle();
	}
	
	public void updateView() {
		slideViewerComponent.update();
	}
	
	public void exitPresentation() {
		this.presentation.exit(0);
	}	
}
