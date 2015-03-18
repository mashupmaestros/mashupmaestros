package com.codesandgears.enterkonnect.endpoints;


import static com.codesandgears.enterkonnect.service.OfyService.ofy;

import java.util.logging.Logger;

import javax.inject.Named;

import com.codesandgears.enterkonnect.beans.Feed;
import com.codesandgears.enterkonnect.beans.Feed;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.googlecode.objectify.Key;

@Api(name = "feedEndpoint", version = "v1", namespace = @ApiNamespace(ownerDomain = "mashupmaestros", ownerName = "mashupmaestros", packagePath=""))
public class FeedEndpoint {


    private static final Logger log = Logger.getLogger(FeedEndpoint.class.getName());
    
    @ApiMethod(name = "saveFeed")
    public Feed saveFeed(Feed feed) {

           log.entering(FeedEndpoint.class.getName(),"saveFeed",feed);
           log.info(FeedEndpoint.class.getName()+"saveFeed"+feed.toString());
        try {
            Key key = ofy().save().entity(feed).now();
            Feed newfeed=(Feed)ofy().load().key(key).now();
            log.info(FeedEndpoint.class.getName()+"saveFeed - newFeed"+newfeed.toString());
            log.exiting(FeedEndpoint.class.getName(), "saveFeed");
            return newfeed;
        }catch (Exception e){

            log.severe(FeedEndpoint.class.getName()+"saveFeed"+feed.toString());
            e.printStackTrace();
            return null;
        }
    }

 
        @ApiMethod(name = "getFeed")
        public  Feed getFeed(@Named("id") Long id) {

            log.entering(FeedEndpoint.class.getName(),"getFeed",id);
            log.info(FeedEndpoint.class.getName()+"getFeed"+id);
            try{
                Feed feed=ofy().load().type(Feed.class).id(id).now();
                log.info(feed.toString());
                log.exiting(FeedEndpoint.class.getName(),"getFeed");
                return feed;
            }catch (Exception e){

                log.severe(FeedEndpoint.class.getName()+"getFeed"+id);
                e.printStackTrace();
                return null;
            }
    }
    
}











