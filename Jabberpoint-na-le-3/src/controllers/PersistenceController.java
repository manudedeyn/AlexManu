package controllers;

import java.io.IOException;

import models.Presentation;
import persistence.Accessor;
import persistence.DemoPresentation;
import persistence.factories.AccessorFactory;
import persistence.factories.DefaultAccessorFactory;

public class PersistenceController {
	
	Accessor accessor;
	
	public PersistenceController(String fileName) {
		AccessorFactory accessorFactory = new DefaultAccessorFactory();
		accessor = accessorFactory.createAccessor(fileName);
	}
	
	public Presentation loadPresentation(String fileName) {
		try {
			return accessor.loadFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
			accessor = new DemoPresentation();
			
			try {
				return accessor.loadFile(fileName);
			} catch (IOException e1) {
				// Kan in principe niet voorvallen, want de DemoPresentation kan altijd geladen worden.
				return null;
			}
		}
	}
	
	public void savePresentation(Presentation presentation, String fileName) {
		try {
			accessor.saveFile(presentation, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
