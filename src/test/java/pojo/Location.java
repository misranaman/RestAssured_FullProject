package pojo;

import java.util.List;

public class Location {

	private int id;
	private String city;
	private String country;
	private Address address;
	private List addressList;

	public Location(int id, String city, String country, Address address) {

		this.id = id;
		this.city = city;
		this.country = country;
		this.address = address;

	}
	
	public Location(int id, String city, String country, List addressList) {

		this.id = id;
		this.city = city;
		this.country = country;
		this.addressList = addressList;

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List getAddressList() {
		return addressList;
	}

	public void setAddressList(List addressList) {
		this.addressList = addressList;
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
