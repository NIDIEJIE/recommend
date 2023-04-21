package com.linmj.common;

public class LineStatus {
    public static final String URGENT = "严重状态";
    public static final String URGENT_STR = "需停电处理的严重或危急缺陷，应立即向调度部门申请\"非计划停电\"" +
            "并在28.5小时内根据具体缺陷开展Ⅰ类-Ⅲ类检修";
    public static final String SERIOUS = "异常状态";
    public static final String SERIOUS_STR = "根据评价结果具体扣分项确定检修项目，并在7天内完成检修";
    public static final String NOTICE = "注意状态";
    public static final String NOTICE_STR = "优先安排Ⅲ类检修，若不能满足需要，则1年内开展Ⅱ类检修";
    public static final String NORMAL = "正常状态";
    public static final String NORMAL_STR = "可以根据实际运行情况、针对具体的一般缺陷开展Ⅲ类检修";
}

