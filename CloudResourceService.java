package com.oracleoptimizer.service;

import com.oracleoptimizer.model.CloudResource;
import com.oracleoptimizer.repository.CloudResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudResourceService {

    @Autowired
    private CloudResourceRepository resourceRepository;

    public List<CloudResource> getAllResources() {
        return resourceRepository.findAll();
    }

    public CloudResource getResourceById(Long id) {
        return resourceRepository.findById(id).orElse(null);
    }

    public CloudResource saveResource(CloudResource resource) {
        return resourceRepository.save(resource);
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

    public List<CloudResource> getByType(String type) {
        return resourceRepository.findByType(type);
    }

    public List<CloudResource> getByRegion(String region) {
        return resourceRepository.findByRegion(region);
    }

    public List<CloudResource> getUnderutilizedResources(double cpuThreshold, double memoryThreshold) {
        return resourceRepository.findUnderutilizedResources(cpuThreshold, memoryThreshold);
    }

    public List<CloudResource> getMostExpensiveResources() {
        return resourceRepository.findTop5ByCost();
    }

    public List<CloudResource> getHighCpuUsageResources(double cpuThreshold) {
        return resourceRepository.findResourcesWithHighCpu(cpuThreshold);
    }
}
