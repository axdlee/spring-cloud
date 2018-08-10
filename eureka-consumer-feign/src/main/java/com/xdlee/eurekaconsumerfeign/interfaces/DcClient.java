package com.xdlee.eurekaconsumerfeign.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Sheldon
 * User: sheldon
 * Date: 18-8-10
 * Time: 下午5:43
 *
 * @author Sheldon Lee <xdlee110@gmail.com>
 * @link https://www.yeelight.com
 */
@FeignClient("eureka-client")
public interface DcClient {
    @GetMapping("/dc")
    public String consumer();
}
