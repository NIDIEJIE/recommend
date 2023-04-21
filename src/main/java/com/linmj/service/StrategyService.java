package com.linmj.service;

import com.linmj.common.Code;
import com.linmj.common.LineStatus;
import com.linmj.controller.dto.ParamDataItemSingleDTO;
import com.linmj.controller.dto.ParamInputDTO;
import com.linmj.controller.dto.ParamInputTowerItemDTO;
import com.linmj.domain.History;
import com.linmj.domain.Strategy;
import com.linmj.exception.ServiceException;
import com.linmj.mapper.HistoryMapper;
import com.linmj.mapper.StrategyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StrategyService {
    @Autowired
    private StrategyMapper strategyMapper;
    @Autowired
    private HistoryMapper historyMapper;

    public List<Integer> getChartData(Integer id) {
        Integer urgent = strategyMapper.getUrgentNum(id);
        Integer serious = strategyMapper.getSeriousNum(id);
        Integer notice = strategyMapper.getNoticeNum(id);
        Integer normal = strategyMapper.getNormalNum(id);
        List<Integer> data = new ArrayList<Integer>();
        data.add(urgent);
        data.add(serious);
        data.add(notice);
        data.add(normal);
        return data;
    }

    public String generateStrategy(ParamInputDTO data) {
        if(data.getTransmissionLineName() == null || data.getTransmissionLineName() == "")
            throw new ServiceException(Code.CODE_400, "无具体线路名");
        HealthStatusAssessment healthStatusAssessment = new HealthStatusAssessment(data.getTransmissionLineName());
        List<List<Double>> statusInfo = new ArrayList<>();
        //具体杆塔的检修策略
        String detail = "";
        //对每一个杆塔进行处理
        for(ParamInputTowerItemDTO item: data.getTowerData()){
            KeyParameter keyParameter = new KeyParameter();
            keyParameter.setTowerName(item.getTowerName());
            for(ParamDataItemSingleDTO i: item.getDataList()){
                //每个进行判断，最后调用getList()方法
                switch (i.getParam()){
                    case "基础 / 基础混凝土表面有水泥脱落、露石、麻面、裂缝或钢筋外露":
                        keyParameter.setK1_1_biaomian(i.getInput());
                        break;
                    case "基础 / 砼杆、铁塔基础周围被取土":
                        keyParameter.setK2_1_qutu(i.getInput());
                        break;
                    case "基础 / 基础保护范围内被冲刷、滑坡、坍塌":
                        keyParameter.setK3_1_baohu(i.getInput());
                        break;
                    case "基础 / 拉线基础埋深不满足设计值":
                        keyParameter.setK4_1_laxiansheji(i.getInput());
                        break;
                    case "杆塔 / 拉线锈蚀、损伤情况":
                        keyParameter.setK5_2_laxiansunshang(i.getInput());
                        break;
                    case "杆塔 / 杆塔倾斜度":
                        keyParameter.setK6_2_qingxiedu(i.getInput());
                        break;
                    case "杆塔 / 镀锌层锈蚀情况":
                        keyParameter.setK7_2_duxinceng(i.getInput());
                        break;
                    case "杆塔 / 螺栓紧固情况":
                        keyParameter.setK8_2_luoshuan(i.getInput());
                        break;
                    case "杆塔 / 塔材缺失":
                        keyParameter.setK9_2_tacai(i.getInput());
                        break;
                    case "杆塔 / 塔身主材弯曲度":
                        keyParameter.setK10_2_tashen(i.getInput());
                        break;
                    case "杆塔 / 杆顶最大挠度":
                        keyParameter.setK11_2_ganding(i.getInput());
                        break;
                    case "杆塔 / 砼杆裂缝宽度":
                        keyParameter.setK12_2_liefeng(i.getInput());
                        break;
                    case "杆塔 / 水泥杆水泥脱落情况":
                        keyParameter.setK13_2_shuinigan(i.getInput());
                        break;
                    case "导地线 / 导地线损伤截面占总截面面积比例":
                        keyParameter.setK14_3_sunshang(i.getInput());
                        break;
                    case "导地线 / 导地线异物悬挂":
                        keyParameter.setK15_3_yiwu(i.getInput());
                        break;
                    case "导地线 / 导地线锈蚀情况":
                        keyParameter.setK16_3_xiushi(i.getInput());
                        break;
                    case "导地线 / OPGW光缆磨损、断股、漏油等":
                        keyParameter.setK17_3_guanglanduangu(i.getInput());
                        break;
                    case "导地线 / OPGW光缆金具磨损、锈蚀等":
                        keyParameter.setK18_3_guanglanxiushi(i.getInput());
                        break;
                    case "绝缘子 / 伞裙出现破损、老化、变硬":
                        keyParameter.setK19_4_sanqun(i.getInput());
                        break;
                    case "绝缘子 / 零值绝缘子片数超标":
                        keyParameter.setK20_4_chaobiao(i.getInput());
                        break;
                    case "绝缘子 / 芯棒通过紫外探伤仪检测异常":
                        keyParameter.setK21_4_xinbang(i.getInput());
                        break;
                    case "绝缘子 / 盐密、灰密值超标":
                        keyParameter.setK22_4_yanmi(i.getInput());
                        break;
                    case "绝缘子 / 悬垂绝缘子串偏斜角":
                        keyParameter.setK23_4_pianxiejiao(i.getInput());
                        break;
                    case "绝缘子 / 伞裙粉化、电蚀、树枝状放电痕迹等":
                        keyParameter.setK24_4_dianshi(i.getInput());
                        break;
                    case "绝缘子 / 芯棒护套破损":
                        keyParameter.setK25_4_hutao(i.getInput());
                        break;
                    case "绝缘子 / 伞裙脱落":
                        keyParameter.setK26_4_tuoluo(i.getInput());
                        break;
                    case "绝缘子 / 憎水性等级":
                        keyParameter.setK27_4_zengshui(i.getInput());
                        break;
                    case "绝缘子 / 瓷绝缘子釉面损伤情况":
                        keyParameter.setK28_4_youmian(i.getInput());
                        break;
                    case "金具 / 金具锌层（银层）损失情况、腐蚀情况":
                        keyParameter.setK29_5_xinceng(i.getInput());
                        break;
                    case "金具 / 挂板、联板、球头挂环等金具变形对电气、机械强度影响程度":
                        keyParameter.setK30_5_guaban(i.getInput());
                        break;
                    case "金具 / 金具是否出现断裂":
                        keyParameter.setK31_5_duanlie(i.getInput());
                        break;
                    case "金具 / 压接管处相对温差":
                        keyParameter.setK32_5_yajieguan(i.getInput());
                        break;
                    case "金具 / 间隔棒出现松动、滑移等安装缺陷":
                        keyParameter.setK33_5_jiangebang(i.getInput());
                        break;
                    case "金具 / 金具螺栓的紧固情况":
                        keyParameter.setK34_5_luoshuan(i.getInput());
                        break;
                    case "接地装置 / 接地体埋深不满足设计值":
                        keyParameter.setK35_6_maishen(i.getInput());
                        break;
                    case "接地装置 / 接地引下线锈蚀情况":
                        keyParameter.setK36_6_xiushi(i.getInput());
                        break;
                    case "通道环境 / 交跨距离（与建筑物、道路、）不足，与规定值之比":
                        keyParameter.setK37_7_jiaokuajuli(i.getInput());
                        break;
                    case "通道环境 / 防鸟设施配置情况":
                        keyParameter.setK38_7_fangniao(i.getInput());
                        break;
                    case "通道环境 / 通道临近开山采石、爆破点等":
                        keyParameter.setK39_7_baopo(i.getInput());
                        break;
                    case "附属设施 / 杆号、相序牌图文不清、破损附属设施":
                        keyParameter.setK40_8_tuwen(i.getInput());
                        break;
                    case "附属设施 / 杆号、相序牌丢失或未设":
                        keyParameter.setK41_8_diushi(i.getInput());
                        break;
                    case "附属设施 / 避雷器松动、脱落或缺螺栓":
                        keyParameter.setK42_8_songdong(i.getInput());
                        break;
                }
            }
            keyParameter.getList();
            detail += keyParameter.getDetailStr();
            statusInfo.add(keyParameter.keyParameterList);
        }
        System.out.println("这是statusInfo:" + statusInfo);
        //线路状态评估值
        double assess =  healthStatusAssessment.assessment(statusInfo);
        System.out.println(assess);
        String status, statusStr;
        if(assess < 0.90){
            status = LineStatus.URGENT;
            statusStr = LineStatus.URGENT_STR;
        } else if (assess < 0.95 && assess >= 0.90) {
            status = LineStatus.SERIOUS;
            statusStr = LineStatus.SERIOUS_STR;
        }else if (assess < 0.99 && assess >= 0.95) {
            status = LineStatus.NOTICE;
            statusStr = LineStatus.NOTICE_STR;
        }else {
            status = LineStatus.NORMAL;
            statusStr = LineStatus.NORMAL_STR;
        }
        String general = data.getTransmissionLineName() + "线路为" + status + "，根据状态检修策略，对" + status +
                "的线路" + statusStr + "，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\n";
        String res = general + detail;
        Strategy strategy = new Strategy();
        strategy.setUser_id(data.getUser_id());
        strategy.setStrategy(res);
        strategy.setStatus_value(assess);
        strategyMapper.insert(strategy);
        History history = new History();
        history.setStrategy_id(strategy.getId());
        history.setLinename(data.getTransmissionLineName());
        history.setUser_id(data.getUser_id());
        historyMapper.insert(history);
        return res;
    }
}
