package ag.agriconnectCapteur.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "acdataschedule")
public interface SchedulerServiceClient {
    @RequestMapping(value = "/scheduler/schedule/{capteurId}", method = RequestMethod.POST)
    void scheduleSensorDataCollection(@PathVariable("capteurId") Long capteurId);
}