package com.oracleoptimizer.repository;

import com.oracleoptimizer.model.CloudResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloudResourceRepository extends JpaRepository<CloudResource, Long> {

    // Get resources by type (e.g., EC2, VM, Storage)
    List<CloudResource> findByType(String type);

    // Get resources by region
    List<CloudResource> findByRegion(String region);

    // Get resources with high CPU utilization
    @Query("SELECT r FROM CloudResource r WHERE r.cpuUtilization > :threshold")
    List<CloudResource> findResourcesWithHighCpu(double threshold);

    // Get resources with low utilization (wasted resources)
    @Query("SELECT r FROM CloudResource r WHERE r.cpuUtilization < :cpuThreshold AND r.memoryUtilization < :memThreshold")
    List<CloudResource> findUnderutilizedResources(double cpuThreshold, double memThreshold);

    // Get resources sorted by cost
    List<CloudResource> findAllByOrderByCostPerHourDesc();

    // Get top 5 most expensive resources
    @Query("SELECT r FROM CloudResource r ORDER BY r.costPerHour DESC")
    List<CloudResource> findTop5ByCost();
}
