package com.linmj.service;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Data
public class KeyParameter {
    /*
     * 杆塔所有关键状态量
     * tower：杆塔号
     * K**_**: 关键参量
     */
    private String towerName;
    public List<Double> keyParameterList = new ArrayList<Double>();
    // 基础单元
    /*
     * 1基础混凝土表面有水泥脱落、露石、麻面、裂缝或钢筋外露
     * 2砼杆、铁塔基础周围被取土
     * 3基础保护范围内被冲刷、滑坡、坍塌
     * 4拉线基础埋深不满足设计值
     */
    private double k1_1_biaomian;
    public static final String K1_STR = "钢筋混凝土表面修复（Ⅲ类检修）";
    private double k2_1_qutu;
    public static final String K2_STR = "恢复铁塔基础周围原貌（Ⅲ类检修）";
    private double k3_1_baohu;
    public static final String K3_STR = "修复基础护坡（Ⅲ类检修）";

    private double k4_1_laxiansheji;
    public static final String K4_STR = "更换杆塔拉线（Ⅲ类检修）";
    // 杆塔单元
    /*
     * 5拉线锈蚀、损伤情况
     * 6杆塔倾斜度
     * 7镀锌层锈蚀情况
     * 8螺栓紧固情况
     * 9塔材缺失
     * 10塔身主材弯曲度
     * 11杆顶最大挠度
     * 12砼杆裂缝宽度
     * 13水泥杆水泥脱落情况
     */
    private double k5_2_laxiansunshang;
    public static final String K5_STR1 = "对拉线进行缠绕、绑扎修补（Ⅲ类检修）";
    public static final String K5_STR2 = "更换杆塔拉线（Ⅲ类检修）";
    private double k6_2_qingxiedu;
    public static final String K6_STR = "进行反向拉线加固（Ⅲ类检修）";
    private double k7_2_duxinceng;
    public static final String K7_STR = "进行铁塔防腐处理（Ⅲ类检修）";
    private double k8_2_luoshuan;
    public static final String K8_STR = "进行杆塔螺栓紧固（Ⅲ类检修）";
    private double k9_2_tacai;
    public static final String K9_STR = "补装塔材（Ⅲ类检修）";
    private double k10_2_tashen;
    public static final String K10_STR = "更换塔材（Ⅲ类检修）";
    private double k11_2_ganding;
    public static final String K11_STR = "扶正及加固杆塔（Ⅰ类检修）";
    private double k12_2_liefeng;
    public static final String K12_STR = "裂缝修复（Ⅲ类检修）";
    private double k13_2_shuinigan;
    public static final String K13_STR = "水泥杆修复及加固（Ⅲ类检修）";

    // 导地线单元
    /*
     * 14导地线损伤截面占总截面面积比例
     * 15导地线异物占总截面面积比例
     * 16导地线绝缘子破损、污秽、漏电情况
     * 17OPGW光缆磨损、断股、漏油等
     * 18OPGW光缆金具磨损、锈蚀等
     */
    private double k14_3_sunshang;
    public static final String K14_STR = "对导线进行带电缠绕修补（Ⅲ类检修）";
    private double k15_3_yiwu;
    public static final String K15_STR = "带电清除异物（Ⅲ类检修）";
    private double k16_3_xiushi;
    public static final String K16_STR = "带电更换绝缘子（Ⅲ类检修）";
    private double k17_3_guanglanduangu;
    public static final String K17_STR1 = "对OPGW光缆进行带电缠绕修补（Ⅲ类检修）";
    public static final String K17_STR2 = "OPGW光缆更换（Ⅰ类检修）";
    private double k18_3_guanglanxiushi;
    public static final String K18_STR = "带电更换金具（Ⅲ类检修）";

    // 绝缘子单元
//    19伞裙出现破损、老化、变硬
//    20零值绝缘子片数超标
//    21芯棒通过紫外探伤仪检测异常
//    22盐密、灰密值超标
//    23悬垂绝缘子串偏斜角
//    24伞裙粉化、电蚀、树枝状放电痕迹等
//    25芯棒护套破损
//    26伞裙脱落
//    27憎水性等级
//    28瓷绝缘子釉面损伤情况
    private double k19_4_sanqun;
    public static final String K19_STR = "更换绝缘子（Ⅲ类检修）";
    private double k20_4_chaobiao;
    public static final String K20_STR = "更换零值绝缘子（Ⅱ类检修）";
    private double k21_4_xinbang;
    public static final String K21_STR = "更换绝缘子（Ⅲ类检修）";
    private double k22_4_yanmi;
    public static final String K22_STR = "进行绝缘子清扫（Ⅲ类检修）";
    private double k23_4_pianxiejiao;
    public static final String K23_STR = "更换绝缘子（Ⅲ类检修）";
    private double k24_4_dianshi;
    public static final String K24_STR = "更换绝缘子（Ⅲ类检修）";
    private double k25_4_hutao;
    public static final String K25_STR = "更换绝缘子（Ⅲ类检修）";
    private double k26_4_tuoluo;
    public static final String K26_STR = "更换绝缘子（Ⅲ类检修）";
    private double k27_4_zengshui;
    public static final String K27_STR = "更换绝缘子（Ⅲ类检修）";
    private double k28_4_youmian;
    public static final String K28_STR = "更换绝缘子（Ⅲ类检修）";

    //金具单元
//        29金具锌层（银层）损失情况、腐蚀情况
//        30挂板、联板、球头挂环等金具变形对电气、机械强度影响程度
//        31金具是否出现断裂
//        32压接管处相对温差
//        33间隔棒出现松动、滑移等安装缺陷
//        34金具螺栓的紧固情况
    private double k29_5_xinceng;
    public static final String K29_STR = "带电更换金具（Ⅲ类检修）";
    private double k30_5_guaban;
    public static final String K30_STR = "带电更换金具（Ⅲ类检修）";
    private double k31_5_duanlie;
    public static final String K31_STR = "带电更换金具（Ⅲ类检修）";
    private double k32_5_yajieguan;
    public static final String K32_STR = "对温差处进行带电处理（Ⅲ类检修）";
    private double k33_5_jiangebang;
    public static final String K33_STR = "更换间隔棒（Ⅱ类检修）";
    private double k34_5_luoshuan;
    public static final String K34_STR = "进行金具螺栓紧固（Ⅲ类检修）";

    //    接地装置单元
//    35接地体埋深不满足设计值
//    36接地引下线锈蚀情况
    private double k35_6_maishen;
    public static final String K35_STR = "对接地体进行填土重埋（Ⅲ类检修）";
    private double k36_6_xiushi;
    public static final String K36_STR = "修复或更换接地引下线（Ⅲ类检修）";

    //    通道环境单元
//    37交跨距离（与建筑物、道路、）不足，与规定值之比
//    38防鸟设施配置情况
//    39通道临近开山采石、爆破点等
    private double k37_7_jiaokuajuli;
    public static final String K37_STR = "交跨距离暂不处理，结合Ⅱ类检修走线检查进行";
    private double k38_7_fangniao;
    public static final String K38_STR = "防鸟设施修补";
    private double k39_7_baopo;
    public static final String K39_STR = "通道临近开山采石、爆破点暂不处理，结合Ⅱ类检修走线检查进行";

    //    附属设施单元
//    40杆号、相序牌图文不清、破损
//    41杆号、相序牌丢失或未设
//    42避雷器松动、脱落或缺螺栓
    private double k40_8_tuwen;
    public static final String K40_STR = "更换杆号、相序牌（Ⅲ类检修）";
    private double k41_8_diushi;
    public static final String K41_STR = "安装杆号、相序牌（Ⅲ类检修）";
    private double k42_8_songdong;
    public static final String K42_STR = "避雷器加固（Ⅲ类检修）";

    public KeyParameter() {
    }

    public KeyParameter(String towerName, double k1_1_biaomian, double k2_1_qutu, double k3_1_baohu, double k4_1_laxiansheji, double k5_2_laxiansunshang, double k6_2_qingxiedu, double k7_2_duxinceng, double k8_2_luoshuan, double k9_2_tacai, double k10_2_tashen, double k11_2_ganding, double k12_2_liefeng, double k13_2_shuinigan, double k14_3_sunshang, double k15_3_yiwu, double k16_3_xiushi, double k17_3_guanglanduangu, double k18_3_guanglanxiushi, double k19_4_sanqun, double k20_4_chaobiao, double k21_4_xinbang, double k22_4_yanmi, double k23_4_pianxiejiao, double k24_4_dianshi, double k25_4_hutao, double k26_4_tuoluo, double k27_4_zengshui, double k28_4_youmian, double k29_5_xinceng, double k30_5_guaban, double k31_5_duanlie, double k32_5_yajieguan, double k33_5_jiangebang, double k34_5_luoshuan, double k35_6_maishen, double k36_6_xiushi, double k37_7_jiaokuajuli, double k38_7_fangniao, double k39_7_baopo, double k40_8_tuwen, double k41_8_diushi, double k42_8_songdong) {
        this.towerName = towerName;
        this.k1_1_biaomian = k1_1_biaomian;
        this.k2_1_qutu = k2_1_qutu;
        this.k3_1_baohu = k3_1_baohu;
        this.k4_1_laxiansheji = k4_1_laxiansheji;
        this.k5_2_laxiansunshang = k5_2_laxiansunshang;
        this.k6_2_qingxiedu = k6_2_qingxiedu;
        this.k7_2_duxinceng = k7_2_duxinceng;
        this.k8_2_luoshuan = k8_2_luoshuan;
        this.k9_2_tacai = k9_2_tacai;
        this.k10_2_tashen = k10_2_tashen;
        this.k11_2_ganding = k11_2_ganding;
        this.k12_2_liefeng = k12_2_liefeng;
        this.k13_2_shuinigan = k13_2_shuinigan;
        this.k14_3_sunshang = k14_3_sunshang;
        this.k15_3_yiwu = k15_3_yiwu;
        this.k16_3_xiushi = k16_3_xiushi;
        this.k17_3_guanglanduangu = k17_3_guanglanduangu;
        this.k18_3_guanglanxiushi = k18_3_guanglanxiushi;
        this.k19_4_sanqun = k19_4_sanqun;
        this.k20_4_chaobiao = k20_4_chaobiao;
        this.k21_4_xinbang = k21_4_xinbang;
        this.k22_4_yanmi = k22_4_yanmi;
        this.k23_4_pianxiejiao = k23_4_pianxiejiao;
        this.k24_4_dianshi = k24_4_dianshi;
        this.k25_4_hutao = k25_4_hutao;
        this.k26_4_tuoluo = k26_4_tuoluo;
        this.k27_4_zengshui = k27_4_zengshui;
        this.k28_4_youmian = k28_4_youmian;
        this.k29_5_xinceng = k29_5_xinceng;
        this.k30_5_guaban = k30_5_guaban;
        this.k31_5_duanlie = k31_5_duanlie;
        this.k32_5_yajieguan = k32_5_yajieguan;
        this.k33_5_jiangebang = k33_5_jiangebang;
        this.k34_5_luoshuan = k34_5_luoshuan;
        this.k35_6_maishen = k35_6_maishen;
        this.k36_6_xiushi = k36_6_xiushi;
        this.k37_7_jiaokuajuli = k37_7_jiaokuajuli;
        this.k38_7_fangniao = k38_7_fangniao;
        this.k39_7_baopo = k39_7_baopo;
        this.k40_8_tuwen = k40_8_tuwen;
        this.k41_8_diushi = k41_8_diushi;
        this.k42_8_songdong = k42_8_songdong;
        this.getList();
    }

    public void getList() {
        this.keyParameterList.add(this.k1_1_biaomian);
        this.keyParameterList.add(this.k2_1_qutu);
        this.keyParameterList.add(this.k3_1_baohu);
        this.keyParameterList.add(this.k4_1_laxiansheji);

        this.keyParameterList.add(this.k5_2_laxiansunshang);
        this.keyParameterList.add(this.k6_2_qingxiedu);
        this.keyParameterList.add(this.k7_2_duxinceng);
        this.keyParameterList.add(this.k8_2_luoshuan);
        this.keyParameterList.add(this.k9_2_tacai);
        this.keyParameterList.add(this.k10_2_tashen);
        this.keyParameterList.add(this.k11_2_ganding);
        this.keyParameterList.add(this.k12_2_liefeng);
        this.keyParameterList.add(this.k13_2_shuinigan);

        this.keyParameterList.add(this.k14_3_sunshang);
        this.keyParameterList.add(this.k15_3_yiwu);
        this.keyParameterList.add(this.k16_3_xiushi);
        this.keyParameterList.add(this.k17_3_guanglanduangu);
        this.keyParameterList.add(this.k18_3_guanglanxiushi);

        this.keyParameterList.add(this.k19_4_sanqun);
        this.keyParameterList.add(this.k20_4_chaobiao);
        this.keyParameterList.add(this.k21_4_xinbang);
        this.keyParameterList.add(this.k22_4_yanmi);
        this.keyParameterList.add(this.k23_4_pianxiejiao);
        this.keyParameterList.add(this.k24_4_dianshi);
        this.keyParameterList.add(this.k25_4_hutao);
        this.keyParameterList.add(this.k26_4_tuoluo);
        this.keyParameterList.add(this.k27_4_zengshui);
        this.keyParameterList.add(this.k28_4_youmian);

        this.keyParameterList.add(this.k29_5_xinceng);
        this.keyParameterList.add(this.k30_5_guaban);
        this.keyParameterList.add(this.k31_5_duanlie);
        this.keyParameterList.add(this.k32_5_yajieguan);
        this.keyParameterList.add(this.k33_5_jiangebang);
        this.keyParameterList.add(this.k34_5_luoshuan);

        this.keyParameterList.add(this.k35_6_maishen);
        this.keyParameterList.add(this.k36_6_xiushi);

        this.keyParameterList.add(this.k37_7_jiaokuajuli);
        this.keyParameterList.add(this.k38_7_fangniao);
        this.keyParameterList.add(this.k39_7_baopo);

        this.keyParameterList.add(this.k40_8_tuwen);
        this.keyParameterList.add(this.k41_8_diushi);
        this.keyParameterList.add(this.k42_8_songdong);


    }

    public String getDetailStr() {
        String detail = "";
        if(k1_1_biaomian > 0){
            detail = detail + K1_STR + "、";
        }
        if(k2_1_qutu > 0){
            detail = detail + K2_STR + "、";
        }
        if(k3_1_baohu > 0){
            detail = detail + K3_STR + "、";
        }
        if(k4_1_laxiansheji > 0){
            detail = detail + K4_STR + "、";
        }
        if(k5_2_laxiansunshang > 0){
            if(k5_2_laxiansunshang > 0.5)
                detail = detail + K5_STR2 + "、";
            else
                detail = detail + K5_STR1 + "、";
        }
        if(k6_2_qingxiedu > 0){
            detail = detail + K6_STR + "、";
        }
        if(k7_2_duxinceng > 0){
            detail = detail + K7_STR + "、";
        }
        if(k8_2_luoshuan > 0){
            detail = detail + K8_STR + "、";
        }
        if(k9_2_tacai > 0){
            detail = detail + K9_STR + "、";
        }
        if(k10_2_tashen > 0){
            detail = detail + K10_STR + "、";
        }
        if(k11_2_ganding > 0){
            detail = detail + K11_STR + "、";
        }
        if(k12_2_liefeng > 0){
            detail = detail + K12_STR + "、";
        }
        if(k13_2_shuinigan > 0){
            detail = detail + K13_STR + "、";
        }
        if(k14_3_sunshang > 0){
            detail = detail + K14_STR + "、";
        }
        if(k15_3_yiwu > 0){
            detail = detail + K15_STR + "、";
        }
        if(k16_3_xiushi > 0){
            detail = detail + K16_STR + "、";
        }
        if(k17_3_guanglanduangu > 0){
            if(k17_3_guanglanduangu > 0.5)
                detail = detail + K17_STR2 + "、";
            else
                detail = detail + K17_STR1 + "、";
        }
        if(k18_3_guanglanxiushi > 0){
            detail = detail + K18_STR + "、";
        }
        if(k19_4_sanqun > 0){
            detail = detail + K19_STR + "、";
        }
        if(k20_4_chaobiao > 0 && !detail.contains(K20_STR)){
            detail = detail + K20_STR + "、";
        }
        if(k21_4_xinbang > 0 && !detail.contains(K21_STR)){
            detail = detail + K21_STR + "、";
        }
        if(k22_4_yanmi > 0 && !detail.contains(K22_STR)){
            detail = detail + K22_STR + "、";
        }
        if(k23_4_pianxiejiao > 0 && !detail.contains(K23_STR)){
            detail = detail + K23_STR + "、";
        }
        if(k24_4_dianshi > 0 && !detail.contains(K24_STR)){
            detail = detail + K24_STR + "、";
        }if(k25_4_hutao > 0 && !detail.contains(K25_STR)){
            detail = detail + K25_STR + "、";
        }
        if(k26_4_tuoluo > 0 && !detail.contains(K26_STR)){
            detail = detail + K26_STR + "、";
        }
        if(k27_4_zengshui > 0 && !detail.contains(K27_STR)){
            detail = detail + K27_STR + "、";
        }
        if(k28_4_youmian > 0 && !detail.contains(K28_STR)){
            detail = detail + K28_STR + "、";
        }
        if(k29_5_xinceng > 0 && !detail.contains(K29_STR)){
            detail = detail + K29_STR + "、";
        }
        if(k30_5_guaban > 0 && !detail.contains(K30_STR)){
            detail = detail + K30_STR + "、";
        }
        if(k31_5_duanlie > 0 && !detail.contains(K31_STR)){
            detail = detail + K31_STR + "、";
        }
        if(k32_5_yajieguan > 0 && !detail.contains(K32_STR)){
            detail = detail + K32_STR + "、";
        }
        if(k33_5_jiangebang > 0){
            detail = detail + K33_STR + "、";
        }
        if(k34_5_luoshuan > 0){
            detail = detail + K34_STR + "、";
        }
        if(k35_6_maishen > 0){
            detail = detail + K35_STR + "、";
        }
        if(k36_6_xiushi > 0){
            detail = detail + K36_STR + "、";
        }
        if(k37_7_jiaokuajuli > 0){
            detail = detail + K37_STR + "、";
        }
        if(k38_7_fangniao > 0){
            detail = detail + K38_STR + "、";
        }
        if(k39_7_baopo > 0){
            detail = detail + K39_STR + "、";
        }
        if(k40_8_tuwen > 0){
            detail = detail + K40_STR + "、";
        }
        if(k41_8_diushi > 0){
            detail = detail + K41_STR + "、";
        }
        if(k42_8_songdong > 0){
            detail = detail + K42_STR + "、";
        }
        return towerName + "杆塔:" + detail.substring(0,detail.length() - 1) + "\n";
    }
}
