package com.xy.studyboot.util;

/**
 * WJY
 */
public enum MyMonth {

    JANUARY(1,"JANUARY"),
    FEBRUARY(2,"FEBRUARY"),
    MARCH(3,"MARCH"),
    APRIL(4,"APRIL"),
    MAY(5,"MAY"),
    JUNE(6,"JUNE"),
    JULY(7,"JULY"),
    AUGUST(8,"AUGUST"),
    SEPTEMBER(9,"SEPTEMBER"),
    OCTOBER(10,"OCTOBER"),
    NOVEMBER(11,"NOVEMBER"),
    DECEMBER(12,"DECEMBER");

    private int month;

    private String value;

    private MyMonth(int month,String value){
        this.month = month;
        this.value = value;
    }

    public static Integer getMonth(String value){
        for (MyMonth myMonth: MyMonth.values()){
            if (myMonth.getValue().equals(value)){
                return myMonth.getMonth();
            }
        }
        return null;
    }

    public int getMonth() {
        return month;
    }

    public String getValue() {
        return value;
    }
}
