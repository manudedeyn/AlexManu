package persistence.factories;

import persistence.Accessor;
import persistence.XMLAccessor;

public class ConcreteAccessorFactory extends AccessorFactory{

	@Override
	public Accessor createAccessor(String fileName) {
		switch(getExtension(getExtension(fileName))) {
		case "xml":
			return new XMLAccessor();
		case "txt":
			//TODO
			return null;
			//return new TxtAccessor();
		}
		
		//DEFAULT
		return new XMLAccessor();
	}
	
	public String getExtension(String fileName) {
		
		String[] values = fileName.split("\\.");
		return values[values.length-1];
	}
}