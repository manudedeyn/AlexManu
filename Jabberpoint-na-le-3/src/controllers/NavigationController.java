package controllers;

import models.Presentation;

public class NavigationController {
	Presentation presentation;
	
	public NavigationController(Presentation presentation) {
		this.presentation = presentation;
	}
	public void forward() {
		
	}
	
	public void backward() {}
	
	public void nextSlide() {}
	
	public void previousSlide() {}
	
	public void nextSlideItem() {}
	
	public void previousSlideItem() {}
	
}
