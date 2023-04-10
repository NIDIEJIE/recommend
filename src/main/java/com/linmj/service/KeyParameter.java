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
    private double k2_1_qutu;
    private double k3_1_baohu;
    private double k4_1_laxiansheji;
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
    private double k6_2_qingxiedu;
    private double k7_2_duxinceng;
    private double k8_2_luoshuan;
    private double k9_2_tacai;
    private double k10_2_tashen;
    private double k11_2_ganding;
    private double k12_2_liefeng;
    private double k13_2_shuinigan;

    // 导地线单元
    /*
     * 14导地线损伤截面占总截面面积比例
     * 15导地线异物占总截面面积比例
     * 16导地线绝缘子破损、污秽、漏电情况
     * 17OPGW光缆磨损、断股、漏油等
     * 18OPGW光缆金具磨损、锈蚀等
     */
    private double k14_3_sunshang;
    private double k15_3_yiwu;
    private double k16_3_xiushi;
    private double k17_3_guanglanduangu;
    private double k18_3_guanglanxiushi;

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
    private double k20_4_chaobiao;
    private double k21_4_xinbang;
    private double k22_4_yanmi;
    private double k23_4_pianxiejiao;
    private double k24_4_dianshi;
    private double k25_4_hutao;
    private double k26_4_tuoluo;
    private double k27_4_zengshui;
    private double k28_4_youmian;

    //金具单元
//        29金具锌层（银层）损失情况、腐蚀情况
//        30挂板、联板、球头挂环等金具变形对电气、机械强度影响程度
//        31金具是否出现断裂
//        32压接管处相对温差
//        33间隔棒出现松动、滑移等安装缺陷
//        34金具螺栓的紧固情况
    private double k29_5_xinceng;
    private double k30_5_guaban;
    private double k31_5_duanlie;
    private double k32_5_yajieguan;
    private double k33_5_jiangebang;
    private double k34_5_luoshuan;

    //    接地装置单元
//    35接地体埋深不满足设计值
//    36接地引下线锈蚀情况
    private double k35_6_maishen;
    private double k36_6_xiushi;

    //    通道环境单元
//    37交跨距离（与建筑物、道路、）不足，与规定值之比
//    38防鸟设施配置情况
//    39通道临近开山采石、爆破点等
    private double k37_7_jiaokuajuli;
    private double k38_7_fangniao;
    private double k39_7_baopo;

    //    附属设施单元
//    40杆号、相序牌图文不清、破损
//    41杆号、相序牌丢失或未设
//    42避雷器松动、脱落或缺螺栓
    private double k40_8_tuwen;
    private double k41_8_diushi;
    private double k42_8_songdong;

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
}
