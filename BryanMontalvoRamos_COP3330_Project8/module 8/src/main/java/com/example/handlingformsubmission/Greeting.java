package com.example.handlingformsubmission;

/*
Bryan Montalvo Ramos
COP 3330C - 24217
4/13/2025
Class: Greeting
Purpose: Model class for user input data.
Inputs: Student ID, Name, Month, Day, Year, Message
Outputs: Stores and provides access to user input.
*/

public class Greeting {

    private Integer id;
    private String name;
    private Integer month;
    private Integer day;
    private Integer year;
//getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getMonth() { return month; }
    public void setMonth(String month) {
        this.month = Integer.parseInt(month); // ✅ Correct
    }

    public Integer getDay() { return day; }
    public void setDay(String day) {
        this.day = Integer.parseInt(day); // ✅ Correct
    }

    public Integer getYear() { return year; }
    public void setYear(String year) {
        this.year = Integer.parseInt(year);
    }
}
