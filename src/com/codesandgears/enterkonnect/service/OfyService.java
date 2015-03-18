package com.codesandgears.enterkonnect.service;
import com.codesandgears.enterkonnect.beans.Device;
import com.codesandgears.enterkonnect.beans.Feed;
import com.codesandgears.enterkonnect.beans.Person;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class OfyService {

	 static {
	       
	        ObjectifyService.register(Device.class);
	        ObjectifyService.register(Person.class);
	        ObjectifyService.register(Feed.class);
	        
	    }

	    public static Objectify ofy() {
	        return ObjectifyService.ofy();
	    }

	    public static ObjectifyFactory factory() {
	        return ObjectifyService.factory();
	    }
}
