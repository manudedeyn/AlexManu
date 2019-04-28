package controllers;

import java.io.IOException;

import models.Presentation;
import persistence.Accessor;
import persistence.factories.AccessorFactory;

public class PersistenceController {
	public Presentation loadPresentation(String fileName) throws IOException {
		try {
			return getAccessor(fileName).loadFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();

			throw e;
		}
	}
	
	public void savePresentation(Presentation presentation, String fileName) {
		try {
			getAccessor(fileName).saveFile(presentation, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected Accessor getAccessor(String fileName) {
		return AccessorFactory.getInstance().createAccessor(fileName);		
	}
}
