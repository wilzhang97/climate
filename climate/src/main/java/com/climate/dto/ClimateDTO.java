package com.climate.dto;


import java.util.Date;

public class ClimateDTO {

private int id;

private String stationName;
private String province;
private Date date;
private String meanTemp;
private String hightestMonthlymaxiTemp;
private String lowestMonthlyMinTemp;
private String link;





public String getLink() {
	return link;
}

public void setLink(String link) {
	this.link = link;
}

public int getId() {
 return id;
}

public void setId(int id) {
 this.id = id;
}

public String getStationName() {
 return stationName;
}

public void setStationName(String stationName) {
 this.stationName = stationName;
}

public String getProvince() {
 return province;
}

public void setProvince(String province) {
 this.province = province;
}


public Date getDate() {
 return date;
}

public void setDate(Date date) {
 this.date = date;
}

public String getMeanTemp() {
 return meanTemp;
}

public void setMeanTemp(String meanTemp) {
 this.meanTemp = meanTemp;
}

public String getHightestMonthlymaxiTemp() {
 return hightestMonthlymaxiTemp;
}

public void setHightestMonthlymaxiTemp(String hightestMonthlymaxiTemp) {
 this.hightestMonthlymaxiTemp = hightestMonthlymaxiTemp;
}

public String getLowestMonthlyMinTemp() {
 return lowestMonthlyMinTemp;
}

public void setLowestMonthlyMinTemp(String lowestMonthlyMinTemp) {
 this.lowestMonthlyMinTemp = lowestMonthlyMinTemp;
}

}
