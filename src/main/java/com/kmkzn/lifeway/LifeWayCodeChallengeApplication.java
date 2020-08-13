package com.kmkzn.lifeway;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LifeWayCodeChallengeApplication {

    private static final Set<Integer> processedIds = Collections.newSetFromMap(new ConcurrentHashMap<Integer, Boolean>());
    private static final AtomicInteger totalWordCount = new AtomicInteger();
    
    
    public static void main(String[] args) {
        SpringApplication.run(LifeWayCodeChallengeApplication.class, args);
    }

    @RequestMapping(value = "/countWords", method = RequestMethod.POST)
    public Response countWords(@RequestBody Request request) {
        
        int requestId = request.getId();
        
        if (processedIds.contains(requestId)) {
            return null;
        }
        
        totalWordCount.addAndGet(request.getMessage().split(" ").length);
        
        Response response = new Response();
        response.setCount(totalWordCount.get());
        
        processedIds.add(requestId);
        
        return response;
    }
    
}
