package org.example.laptop;

import jakarta.persistence.*;
import org.example.teacher.Teacher;

import java.util.List;

@Entity
public class Laptop {
    @Id
    private int lId;
    private String brand;
    private String model;
    private String gpu;
    private int ram;

//    @ManyToOne
//    private Teacher teacher; // used to create many-to-one relationship
//    @ManyToMany
//    private List<Teacher> teachers;


    public Laptop(){}

    public Laptop(int lId,String brand, String model, String gpu, int ram) {
        setlId(lId);
        setBrand(brand);
        setModel(model);
        setGpu(gpu);
        setRam(ram);
    }

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

//    public List<Teacher> getTeacher() {
//        return teachers;
//    }
//
//    public void setTeacher(List<Teacher> teachers) {
//        this.teachers = teachers;
//    }
    @Override
    public String toString() {
        return "Laptop{" +
                "lId=" + lId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", gpu='" + gpu + '\'' +
                ", ram=" + ram +
                '}';
    }
}
