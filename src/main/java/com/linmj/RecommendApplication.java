package com.linmj;

import com.linmj.service.HealthStatusAssessment;
import com.linmj.service.KeyParameter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RecommendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecommendApplication.class, args);
        KeyParameter keyParameter = new KeyParameter("1", 0.9, 0.9, 0.9,
                0.9, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0);
        HealthStatusAssessment healthStatusAssessment = new HealthStatusAssessment("test");
        List<List<Double>> statusInfo = new ArrayList<>();

        statusInfo.add(keyParameter.keyParameterList);
        double assess =  healthStatusAssessment.assessment(statusInfo);
    }
}

