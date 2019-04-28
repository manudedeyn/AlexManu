package persistence.factories;

import persistence.Accessor;

//This is the AbstractFactory class

public abstract class AccessorFactory {
	public static final AccessorFactory getInstance() {
		// Just return the default implementation. We should get the actual type by means of configuration instead.
		return new DefaultAccessorFactory();		
	}
	
	public abstract Accessor createAccessor(String fileName);
}
