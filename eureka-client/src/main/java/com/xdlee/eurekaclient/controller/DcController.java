package com.xdlee.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sheldon
 * User: sheldon
 * Date: 18-8-10
 * Time: 下午3:06
 *
 * @author Sheldon Lee <xdlee110@gmail.com>
 * @link https://www.yeelight.com
 */
@RestController
public class DcController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
        //Thread.sleep(5000L);
        String services = "Services:" + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
