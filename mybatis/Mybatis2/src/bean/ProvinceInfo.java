package bean;

import java.util.Set;

public class ProvinceInfo {
    private Integer id;
    private Integer provinceId;
    private String  province;
    //描述一对多
    private Set<CityInfo>  citySet;

    public ProvinceInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Set<CityInfo> getCitySet() {
        return citySet;
    }

    public void setCitySet(Set<CityInfo> citySet) {
        this.citySet = citySet;
    }
}

