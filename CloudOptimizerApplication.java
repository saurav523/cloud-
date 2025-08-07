package com.oracleoptimizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudOptimizerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOptimizerApplication.class, args);
        System.out.println("✅ Cloud Cost Optimizer Application Started Successfully!");
    }
}
@SpringBootApplication
@EnableScheduling
public class CloudOptimizerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudOptimizerApplication.class, args);
    }
}

