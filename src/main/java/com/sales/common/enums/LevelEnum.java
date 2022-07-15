//package com.sales.common.enums;
//
//import org.springframework.util.StringUtils;
//
//public enum LevelEnum {
//    AUTOCHANGE("AUTOCHANGE", "cap 1"),
//    WORKFLOW("WORKFLOW", "Luồng workflow");
//
//    private final String code;
//    private final String description;
//
//    ActionTypeEnum(String code, String description) {
//        this.code = code;
//        this.description = description;
//    }
//
//    public static ActionTypeEnum fromCode(String code) {
//        if (StringUtils.hasText(code)) {
//            for (ActionTypeEnum item : values()) {
//                if (item.getCode().equals(code)) {
//                    return item;
//                }
//            }
//        }
//        return null;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//}
