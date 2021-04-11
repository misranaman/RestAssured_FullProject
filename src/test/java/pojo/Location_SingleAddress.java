package pojo;

import java.util.List;

public class Location_SingleAddress {

	private int id;
	private String city;
	private String country;
	private Address address;

	public Location_SingleAddress(int id, String city, String country, Address address) {

		this.id = id;
		this.city = city;
		this.country = country;
		this.address = address;

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
