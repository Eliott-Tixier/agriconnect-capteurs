package ag.agriconnectCapteur.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "acdataschedule")
public interface SchedulerServiceClient {
    @PostMapping("/scheduler/schedule/{capteurId}")
    void scheduleSensorDataCollection(@PathVariable("capteurId") Long capteurId);
}