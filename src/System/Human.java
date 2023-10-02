package System;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Human {

    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer id;
    private String name;

    private String date;
    private String address;
    private double height;
    private double weight;


    public Human() {

    }

    public Human(int id, String name, String date, String address, double height, double weight) throws Exception {

        this.id = count.incrementAndGet();
        this.name = name;

        this.date = date;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return
                "id=" + id +
                ", name=" + name +
                ", date=" + date +
                ", address=" + address +
                ", height=" + height +
                ", weight=" + weight
               ;
    }
}