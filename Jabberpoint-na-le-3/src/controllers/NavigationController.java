package controllers;

import models.Presentation;

public class NavigationController {
	Presentation presentation;
	
	public NavigationController(Presentation presentation) {
		this.presentation = presentation;
	}
	public void forward() {
		//voorlopig aangezien nieuwe feature voor slideitems nog gemaakt moet worden
		this.nextSlide();
	}
	
	public void backward() {
		this.previousSlide();
	}
	
	public void nextSlide() {
		presentation.nextSlide();
	}
	
	public void previousSlide() {
		presentation.prevSlide();
	}
	
	public void nextSlideItem() {
		presentation.getCurrentSlide().nextSlideItem();
	}
	
	public void previousSlideItem() {
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
