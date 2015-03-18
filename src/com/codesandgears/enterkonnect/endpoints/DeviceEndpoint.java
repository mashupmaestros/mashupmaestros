package com.codesandgears.enterkonnect.endpoints;


import static com.codesandgears.enterkonnect.service.OfyService.ofy;

import java.util.logging.Logger;

import javax.inject.Named;

import com.codesandgears.enterkonnect.beans.Device;
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


        @ApiMethod(name = "getDevice")
        public  Device getDevice(@Named("id") Long id) {

            log.entering(DeviceEndpoint.class.getName(),"getDevice",id);
            log.info(DeviceEndpoint.class.getName()+"getDevice"+id);
            try{

                Device device=ofy().load().type(Device.class).id(id).now();
                log.info(device.toString());
                log.exiting(DeviceEndpoint.class.getName(),"getDevice");
                return device;
            }catch (Exception e){

                log.severe(DeviceEndpoint.class.getName()+"getDevice"+id);
                e.printStackTrace();
                return null;
            }
    }
    
}











