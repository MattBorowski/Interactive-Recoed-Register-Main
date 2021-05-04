package io.github.MattBorowski.InteractiveList.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
class HelloServlet{
    private final Logger logger= LoggerFactory.getLogger(HelloServlet.class);

    private HelloService service;

    HelloServlet(HelloService service){
        this.service=service;
    }

    @GetMapping(value = "/api", params = {"lang", "name"})
    String welcome(){
        return welcome(null, null);
    }


    @GetMapping("/api")
   String welcome(@RequestParam("lang") Integer langId, @RequestParam String name) {
        logger.info("Got request");
        return service.prepareGreeting(name , langId );
    }


}
