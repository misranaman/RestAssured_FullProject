package pojo;

import java.util.List;

public class Location_MultipleAddress {

	private int id;
	private String city;
	private String country;
	String type;
	private List<Address> address;

	public Location_MultipleAddress(int id, String city, String country, List<Address> address) {

		this.id = id;
		this.city = city;
		this.country = country;
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

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}
