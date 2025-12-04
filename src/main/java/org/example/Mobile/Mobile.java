package org.example.Mobile;

import jakarta.persistence.Entity;

@Entity
public class Mobile {
    private String mobileBrand;
    private String mobileModel;
    private int ram;

    public Mobile(){}
    public Mobile(String mobileBrand, String mobileModel, int ram){
        setMobileBrand(mobileBrand);
        setMobileModel(mobileModel);
        setRam(ram);
    }
    public String getMobileBrand() {
        return mobileBrand;
    }

    public void setMobileBrand(String mobileBrand) {
        this.mobileBrand = mobileBrand;
    }

    public String getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
