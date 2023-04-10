package com.linmj.service;

import com.linmj.common.Code;
import com.linmj.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HealthStatusAssessment {
    // 输电线路名
    private String transmissionLineName;

    // 状态信息
    // （字典）杆塔号：关键参量
    private List<List<Double>> statusInfo;

    // 模型权重
    // 第一层八个单元权重
    private List<Double> weightLayer1 = Arrays.asList(0.297, 0.2025, 0.1075, 0.1053, 0.1827, 0.0361, 0.0202, 0.0486);
    // 第二次单元下的各参量的权重
    private List<Double> weightLayer2_1 = Arrays.asList(0.1309, 0.0535, 0.4108, 0.4049);
    private List<Double> weightLayer2_2 = Arrays.asList(0.0431, 0.1022, 0.0167, 0.0217, 0.1809, 0.2207, 0.2939, 0.0776, 0.0431);
    private List<Double> weightLayer2_3 = Arrays.asList(0.2123, 0.5225, 0.0837, 0.1085, 0.0729);
    private List<Double> weightLayer2_4 = Arrays.asList(0.0458, 0.0944, 0.1526, 0.1032, 0.0229, 0.0443, 0.1089, 0.0787, 0.0814, 0.2677);
    private List<Double> weightLayer2_5 = Arrays.asList(0.0571, 0.1516, 0.303, 0.3128, 0.1157, 0.0599);
    private List<Double> weightLayer2_6 = Arrays.asList(0.6667, 0.3333);
    private List<Double> weightLayer2_7 = Arrays.asList(0.2123, 0.5225, 0.0837);
    private List<Double> weightLayer2_8 = Arrays.asList(0.187, 0.7153, 0.0977);
    private List<Double> weight = new ArrayList<>(); // 所有关键参量对应的权重

    public HealthStatusAssessment(String transmissionLineName) {
        this.calWeight();
        this.transmissionLineName = transmissionLineName;
    }

    private void calWeight() {
        for (Double w : weightLayer2_1) {
            weight.add(w * weightLayer1.get(0));
        }
        for (Double w : weightLayer2_2) {
            weight.add(w * weightLayer1.get(1));
        }
        for (Double w : weightLayer2_3) {
            weight.add(w * weightLayer1.get(2));
        }
        for (Double w : weightLayer2_4) {
            weight.add(w * weightLayer1.get(3));
        }
        for (Double w : weightLayer2_5) {
            weight.add(w * weightLayer1.get(4));
        }
        for (Double w : weightLayer2_6) {
            weight.add(w * weightLayer1.get(5));
        }
        for (Double w : weightLayer2_7) {
            weight.add(w * weightLayer1.get(6));
        }
        for (Double w : weightLayer2_8) {
            weight.add(w * weightLayer1.get(7));
        }
    }

    public double assessment(List<List<Double>> statusInfo) {
        if(statusInfo != null) {
            double[] weight = new double[this.weight.size()];
            for(int i = 0; i < this.weight.size(); i++){
                weight[i] = this.weight.get(i);
            }
            //线路中各个杆塔对应计算的故障率
            List<Double> failureRates = new ArrayList<Double>();
            //计算线路中各个杆塔障率
            for(List<Double> t: statusInfo){
                double[] towerParams = new double[t.size()];
                for(int i = 0; i < t.size(); i++){
                    towerParams[i] = t.get(i);
                }
                double rate = 0;
                for (int i = 0; i < weight.length; i++) {
                    rate += weight[i] * towerParams[i];
                }
                failureRates.add(rate);
            }
            //计算线路故障率
            double failureRate = Collections.max(failureRates);
            double assess = 1 - failureRate;
            return assess;
        }else{
            throw new ServiceException(Code.CODE_400, "参数错误");
        }
    }
}
