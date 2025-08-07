package com.oracleoptimizer.controller;

import com.oracleoptimizer.model.CloudResource;
import com.oracleoptimizer.service.CloudResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class CloudResourceController {

    @Autowired
    private CloudResourceService resourceService;

    @GetMapping
    public List<CloudResource> getAllResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/{id}")
    public CloudResource getResourceById(@PathVariable Long id) {
        return resourceService.getResourceById(id);
    }

    @PostMapping
    public CloudResource createResource(@RequestBody CloudResource resource) {
        return resourceService.saveResource(resource);
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
    }

    @GetMapping("/type/{type}")
    public List<CloudResource> getByType(@PathVariable String type) {
        return resourceService.getByType(type);
    }

    @GetMapping("/region/{region}")
    public List<CloudResource> getByRegion(@PathVariable String region) {
        return resourceService.getByRegion(region);
    }

    @GetMapping("/underutilized")
    public List<CloudResource> getUnderutilizedResources(
            @RequestParam double cpuThreshold,
            @RequestParam double memoryThreshold) {
        return resourceService.getUnderutilizedResources(cpuThreshold, memoryThreshold);
    }

    @GetMapping("/expensive")
    public List<CloudResource> getMostExpensiveResources() {
        return resourceService.getMostExpensiveResources();
    }

    @GetMapping("/high-cpu")
    public List<CloudResource> getHighCpuUsageResources(@RequestParam double threshold) {
        return resourceService.getHighCpuUsageResources(threshold);
    }
}
