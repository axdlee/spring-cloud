package com.xdlee.eurekaconsumerribbonhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Sheldon
 * User: sheldon
 * Date: 18-8-14
 * Time: 下午2:59
 *
 * @author Sheldon Lee <xdlee110@gmail.com>
 * @link https://www.yeelight.com
 */
@RestController
public class DcController {
    @Autowired
    ConsumerService consumerService;

    @Bean
    public ConsumerService consumerService() {
        return new ConsumerService();
    }

    @GetMapping("/consumer")
    public String dc() {
        return consumerService.consumer();
    }

    class ConsumerService {
        @Autowired
        RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "fallback")
        public String consumer() {
            return restTemplate.getForObject("http://eureka-client/dc", String.class);
        }

        public String fallback() {
            return "fallback";
        }
    }

}
