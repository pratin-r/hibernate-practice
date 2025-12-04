package org.example.mobile;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Cacheable // enables L2 caching
public class Mobile {
    @Id
    private int mobileId;
    private String mobileBrand;
    private String mobileModel;
    private int ram;

    public Mobile(){}
    public Mobile(int mobileId, String mobileBrand, String mobileModel, int ram){
        setMobileId(mobileId);
        setMobileBrand(mobileBrand);
        setMobileModel(mobileModel);
        setRam(ram);
    }

    public int getMobileId(){
        return mobileId;
    }

    public void setMobileId(int mobileId){
        this.mobileId=mobileId;
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

    @Override
    public String toString() {
        return "Mobile{" +
                "mobileId=" + mobileId +
                ", mobileBrand='" + mobileBrand + '\'' +
                ", mobileModel='" + mobileModel + '\'' +
                ", ram=" + ram +
                '}';
    }
}
