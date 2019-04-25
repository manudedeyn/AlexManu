package persistence.factories;

import persistence.Accessor;

//This is the AbstractFactory class

public abstract class AccessorFactory {
	public abstract Accessor createAccessor(String fileName);
}
