package com.aniketshaw29.exportToExcel.util;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;

//@Entity
public class Boat {
//    @Id
    private Long id;
    private String name;
    private String model;
    private int yearBuilt;
    private double lengthInFeet;

    public Boat(Long id, String name, String model, int yearBuilt, double lengthInFeet) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.yearBuilt = yearBuilt;
		this.lengthInFeet = lengthInFeet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public double getLengthInFeet() {
		return lengthInFeet;
	}

	public void setLengthInFeet(double lengthInFeet) {
		this.lengthInFeet = lengthInFeet;
	}
    
    //no args
    //tostring
}
