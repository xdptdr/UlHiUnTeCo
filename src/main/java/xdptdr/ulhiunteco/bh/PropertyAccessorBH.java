package xdptdr.ulhiunteco.bh;

import org.hibernate.PropertyNotFoundException;
import org.hibernate.property.Getter;
import org.hibernate.property.PropertyAccessor;
import org.hibernate.property.Setter;

public class PropertyAccessorBH implements PropertyAccessor {

	@Override
	public Getter getGetter(@SuppressWarnings("rawtypes") Class theClass, String propertyName) throws PropertyNotFoundException {
		throw new PropertyNotFoundException("I'm dumb");
	}

	@Override
	public Setter getSetter(@SuppressWarnings("rawtypes") Class theClass, String propertyName) throws PropertyNotFoundException {
		throw new PropertyNotFoundException("I'm dumb");
	}

}
