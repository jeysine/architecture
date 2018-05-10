package utils.disruptor.test;

/**
 * Created by lst on 2018/5/10.
 */
public class MyInParkingDataEvent {

    private String carLicense; // 车牌号

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

}