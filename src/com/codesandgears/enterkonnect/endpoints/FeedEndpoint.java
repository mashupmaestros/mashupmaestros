package com.codesandgears.enterkonnect.endpoints;


import static com.codesandgears.enterkonnect.service.OfyService.ofy;

import java.util.ArrayList;
import java.util.List;
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
        public  List<Feed> getFeed(@Named("feedDomain") String feedDomain) {

            log.entering(FeedEndpoint.class.getName(),"getFeed",feedDomain);
            log.info(FeedEndpoint.class.getName()+"getFeed"+feedDomain);
            try{
            List<Feed> feedList=new ArrayList<Feed>();          
            if(feedDomain.equalsIgnoreCase("Generic")){
            feedList=ofy().load().type(Feed.class).list();
            }
            else{
            feedList=ofy().load().type(Feed.class).filter("feedDomain >=", feedDomain).filter("feedDomain <=", feedDomain+"\uFFFD").list();
            }
           
                log.info(feedList.toString());
                log.exiting(FeedEndpoint.class.getName(),"getFeed");
                return feedList;
            }catch (Exception e){

                log.severe(FeedEndpoint.class.getName()+"getFeed"+feedDomain);
                e.printStackTrace();
                return null;
            }
    }
    
}










