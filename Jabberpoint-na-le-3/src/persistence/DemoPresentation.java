package persistence;

import models.Presentation;
import models.Slide;
import models.factories.DefaultPresentationBuilder;
import models.factories.PresentationBuilder;

/** Een ingebouwde demo-presentatie
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class DemoPresentation extends Accessor {

	PresentationBuilder presentationBuilder;

    public DemoPresentation() {
    	this.presentationBuilder = new DefaultPresentationBuilder();
    }
	
	public Presentation loadFile(String unusedFilename) {
		presentationBuilder = presentationBuilder.createPresentation("Demo Presentation");
		presentationBuilder = presentationBuilder.createSlide("JabberPoint");
		presentationBuilder = presentationBuilder.createSlideItem("text", "Het Java Presentatie Tool", 1);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Copyright (c) 1996-2000: Ian Darwin", 2);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Copyright (c) 2000-now:", 2);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Gert Florijn en Sylvia Stuurman", 2);
		presentationBuilder = presentationBuilder.createSlideItem("text", "JabberPoint aanroepen zonder bestandsnaam", 4);
		presentationBuilder = presentationBuilder.createSlideItem("text", "laat deze presentatie zien", 4);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Navigeren:", 1);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Volgende slide: PgDn of Enter", 3);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Vorige slide: PgUp of up-arrow", 3);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Stoppen: q or Q", 3);


		presentationBuilder = presentationBuilder.createSlide("Demonstratie van levels en stijlen");
		presentationBuilder = presentationBuilder.createSlideItem("text", "Level 1", 1);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Level 2",2);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Nogmaals level 1",1);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Level 1 heeft stijl nummer 1",1);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Level 2 heeft stijl nummer 2",2);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Zo ziet level 3 er uit",3);
		presentationBuilder = presentationBuilder.createSlideItem("text", "En dit is level 4",4);

		presentationBuilder = presentationBuilder.createSlide("De derde slide");
		presentationBuilder = presentationBuilder.createSlideItem("text", "Om een nieuwe presentatie te openen,", 1);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Om een nieuwe presentatie te openen,", 1);
		presentationBuilder = presentationBuilder.createSlideItem("text", "gebruik File->Open uit het menu.", 2);
		presentationBuilder = presentationBuilder.createSlideItem("text", " ", 1);
		presentationBuilder = presentationBuilder.createSlideItem("text", "Dit is het einde van de presentatie.", 1);
		presentationBuilder = presentationBuilder.createSlideItem("bitmap", "JabberPoint.jpg", 1);

		return presentationBuilder.getPresentation();

	}

	public void saveFile(Presentation presentation, String unusedFilename) {
		throw new IllegalStateException("Save As->Demo! aangeroepen");
	}

}
