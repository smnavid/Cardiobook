package com.example.cardiobook;

import android.os.Parcelable;
import android.text.format.Time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Measurement extends Object implements Serializable, MyObservable {

    private int sys;
    private int dia;
    private int hr;
    private Date date;
    private Date time;
    private String comment = " ";



    public Measurement(Date date, Date time, int sys, int dia, int hr){

        this.date = date;
        this.time = time;
        this.sys = sys;
        this.dia = dia;
        this.hr = hr;

    }

    public int getSys(){
        return this.sys;
    }

    public int getDia(){
        return this.dia;
    }

    private Date getDate(){
        return this.date;
    }

    public int getHr(){
        return this.hr;
    }

    public Date getTime(){
        return this.time;
    }

    public void setSys(int sys){
        this.sys = sys;
    }

    public void setDia(int dia){
        this.dia = dia;
    }
    public void setHr(int hr){
        this.hr = hr;
    }
    public void setDate(Date date){
        this.date = date;
    }

    public void setTime(Date time){
        this.time = time;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    @Override
    public String toString() {

        String sys = Integer.toString(this.sys);
        String dia = Integer.toString(this.dia);
        String hr = Integer.toString(this.hr);
        String date = this.date.toString();
        String measurement = date + " | " + sys + " | " + dia + " | " + hr + "\n" + "comment: " + comment;
        return measurement;
    }

    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for (MyObserver observer : observers) {
            observer.myNotify(this);
        }
    }

}
