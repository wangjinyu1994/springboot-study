package com.xy.studyboot.util;

/**
 * WJY
 */
public enum MyDayOfWeek {

    MONDAY(1,"MONDAY"),
    TUESDAY(2,"TUESDAY"),
    WEDNESDAY(3,"WEDNESDAY"),
    THURSDAY(4,"THURSDAY"),
    FRIDAY(5,"FRIDAY"),
    SATURDAY(6,"SATURDAY"),
    SUNDAY(7,"SUNDAY");

    private int day;

    private String value;

    private MyDayOfWeek(int day , String value){
        this.day = day;
        this.value = value;
    }

    public static Integer getDayWeek(String value){
        for (MyDayOfWeek dayOfWeek : MyDayOfWeek.values()){
            if (dayOfWeek.getValue().equals(value)){
                return dayOfWeek.getDay();
            }
        }
        return null;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
