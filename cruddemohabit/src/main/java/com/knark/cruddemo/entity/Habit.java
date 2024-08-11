package com.knark.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "habit")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "habit_title")
    private String habitTitle;

    @Column(name = "habit_desciption")
    private String habitDesciption;

    @Column(name = "habit_status")
    private boolean habitStatus;

    public Habit(){

    }
    public Habit(String habitTitle, String habitDesciption, boolean habitStatus) {
        this.habitTitle = habitTitle;
        this.habitDesciption = habitDesciption;
        this.habitStatus = habitStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHabitTitle() {
        return habitTitle;
    }

    public void setHabitTitle(String habitTitle) {
        this.habitTitle = habitTitle;
    }

    public String getHabitDesciption() {
        return habitDesciption;
    }

    public void setHabitDesciption(String habitDesciption) {
        this.habitDesciption = habitDesciption;
    }

    public boolean isHabitStatus() {
        return habitStatus;
    }

    public void setHabitStatus(boolean habitStatus) {
        this.habitStatus = habitStatus;
    }

    @Override
    public String toString() {
        return "Habit{" +
                "id=" + id +
                ", habitTitle='" + habitTitle + '\'' +
                ", habitDesciption='" + habitDesciption + '\'' +
                ", habitStatus=" + habitStatus +
                '}';
    }
}
