package com.nagarro.flights.models;



import java.text.ParseException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="finalflights")
public class Flights {

    @Id
    @Column(name = "flightNo")
    private String flightNo;

    @Column(name = "depLoc")
    private String depLoc;

    @Column(name = "arrLoc")
    private String arrLoc;

    @Column(name = "validTill")
    private String validTill;
    
    @Column(name = "flightTime")
    private Integer flightTime;
    
    @Column(name = "flightDur")
    private Double flightDur;
    
    
    @Column(name = "fare")
    private Double fare;
    
    @Column(name = "avail")
    private String avail;
    
    @Column(name = "fclass")
    private String fclass;
    
    
    public Flights() {
    }
    
    public Flights(String no,String dep, String arr, String valid, Double dur , Integer ftime, String avail, String fclass, Double fare) throws ParseException {

    	this.arrLoc= arr;
    	this.depLoc = dep;
    	this.flightNo = no;
    	this.flightDur = dur;
    	this.flightTime = ftime;
    	this.avail= avail;
    	this.fclass = fclass;
    	this.fare= fare;
    	this.validTill=  valid;
    }

    public String getflightNo() {
        return this.flightNo;
    }
    
    public String getdep() {
        return this.depLoc;
    }
    public String getarr() {
        return this.arrLoc;
    }
    public String getvalidtill() {
        return this.validTill ;
    }

    public Integer getflightTime() {
        return this.flightTime;
    }

    public Double getflightDur() {
        return this.flightDur;
    }
    
    public Double getfare() {
        return this.fare;
    }
    public String getavail() {
        return this.avail;
    }
       public String getclass() {
        return this.fclass;
    }

}
