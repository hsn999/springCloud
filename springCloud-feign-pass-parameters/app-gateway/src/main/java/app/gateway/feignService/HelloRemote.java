package app.gateway.feignService;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "api-service", url = "http://localhost:8097", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @RequestMapping(value = "/api")
    String printDate();

}
