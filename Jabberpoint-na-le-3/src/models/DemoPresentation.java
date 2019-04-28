package models;

import models.factories.DefaultPresentationBuilder;
import models.factories.PresentationBuilder;

public class DemoPresentation {
	PresentationBuilder presentationBuilder;

    public DemoPresentation() {
    	this.presentationBuilder = new DefaultPresentationBuilder();
    }
    
    public static Presentation getPresentation() {
    	PresentationBuilder presentationBuilder = PresentationBuilder.getInstance();
    	
    	presentationBuilder.createPresentation("Demo Presentation")
			.createSlide("JabberPoint", "SLIDE")
				.createSlideItem("text", "Het Java Presentatie Tool", 1)
				.createSlideItem("text", "Copyright (c) 1996-2000: Ian Darwin", 2)
				.createSlideItem("text", "Copyright (c) 2000-now:", 2)
				.createSlideItem("text", "Gert Florijn en Sylvia Stuurman", 2)
				.createSlideItem("text", "JabberPoint aanroepen zonder bestandsnaam", 4)
				.createSlideItem("text", "laat deze presentatie zien", 4)
				.createSlideItem("text", "Navigeren:", 1)
				.createSlideItem("text", "Volgende slide: PgDn of Enter", 3)
				.createSlideItem("text", "Vorige slide: PgUp of up-arrow", 3)
				.createSlideItem("text", "Stoppen: q or Q", 3)
			.createSlide("Demonstratie van levels en stijlen", "SLIDE")
				.createSlideItem("text", "Level 1", 1)
				.createSlideItem("text", "Level 2",2)
				.createSlideItem("text", "Nogmaals level 1",1)
				.createSlideItem("text", "Level 1 heeft stijl nummer 1",1)
				.createSlideItem("text", "Level 2 heeft stijl nummer 2",2)
				.createSlideItem("text", "Zo ziet level 3 er uit",3)
				.createSlideItem("text", "En dit is level 4",4)
			.createSlide("De derde slide", "SLIDE")
				.createSlideItem("text", "Om een nieuwe presentatie te openen,", 1)
				.createSlideItem("text", "Om een nieuwe presentatie te openen,", 1)
				.createSlideItem("text", "gebruik File->Open uit het menu.", 2)
				.createSlideItem("text", " ", 1)
				.createSlideItem("text", "Dit is het einde van de presentatie.", 1)
				.createSlideItem("bitmap", "JabberPoint.jpg", 1);
    	
    	return presentationBuilder.getPresentation();
    }
}
