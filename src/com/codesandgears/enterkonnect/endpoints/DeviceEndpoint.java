package com.codesandgears.enterkonnect.endpoints;


import static com.codesandgears.enterkonnect.service.OfyService.ofy;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;

import com.codesandgears.enterkonnect.beans.Device;
import com.codesandgears.enterkonnect.locationidentifier.LocationIsolator;
import com.codesandgears.enterkonnect.locationidentifier.Point;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.googlecode.objectify.Key;

@Api(name = "deviceEndpoint", version = "v1", namespace = @ApiNamespace(ownerDomain = "mashupmaestros", ownerName = "mashupmaestros", packagePath=""))
public class DeviceEndpoint {


    private static final Logger log = Logger.getLogger(DeviceEndpoint.class.getName());
    
    @ApiMethod(name = "saveDevice")
    public Device saveDevice(Device device) {

           log.entering(DeviceEndpoint.class.getName(),"saveDevice",device);
           log.info(DeviceEndpoint.class.getName()+"saveDevice"+device.toString());
        try {
            Key key = ofy().save().entity(device).now();
            Device newDevice=(Device)ofy().load().key(key).now();
            log.info(DeviceEndpoint.class.getName()+"saveDevice - newDevice"+device.toString());
            log.exiting(DeviceEndpoint.class.getName(), "saveDevice");
            return newDevice;
        }catch (Exception e){

            log.severe(DeviceEndpoint.class.getName()+"saveDevice"+device.toString());
            e.printStackTrace();
            return null;
        }
    }


    @ApiMethod(name = "getPosition")

    public  Device getPosition(@Named("firstname") String firstname) {
        log.entering(DeviceEndpoint.class.getName(),"getPosition",firstname);

        log.info(DeviceEndpoint.class.getName()+"getPosition"+firstname);

        try{
        	Device device=ofy().load().type(Device.class).filter("firstname >=", firstname).filter("firstname <=", firstname+"\uFFFD").list().get(0);

         //   device.getPosition();

            LocationIsolator iso = new LocationIsolator("Vulcan", -55, "Ascendant2", -65);

            Point p = iso.findCentriod();

            device.setXcord(p.getxCoordinate());

            device.setYcord(p.getyCoordinate()); 


            log.info(device.toString());

            log.exiting(DeviceEndpoint.class.getName(),"getPosition");

            return device;

        }catch (Exception e){



            log.severe(DeviceEndpoint.class.getName()+"getPosition"+firstname);

            e.printStackTrace();

            return null;

        }
    
        
       
    
}
}











