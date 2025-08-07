package com.oracleoptimizer.scheduler;

import com.oracleoptimizer.service.CloudResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CloudCostScheduler {

    @Autowired
    private CloudResourceService cloudResourceService;

    // Run every hour (3600000 ms)
    @Scheduled(fixedRate = 3600000)
    public void optimizeCloudCosts() {
        System.out.println("🔄 Running scheduled cloud cost optimization...");
        cloudResourceService.optimizeCosts();
    }
}
