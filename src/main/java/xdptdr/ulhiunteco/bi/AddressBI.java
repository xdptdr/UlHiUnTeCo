package xdptdr.ulhiunteco.bi;

import javax.persistence.Column;

import org.hibernate.annotations.Parent;

public class AddressBI {

	@Column(name = "STREET", nullable = false)
	private String street;

	@Column(name = "ZIPCODE", nullable = false)
	private String zipcode;

	@Column(name = "CITY", nullable = false)
	private String city;

	@Parent
	UserBI user;

	public AddressBI() {
	}

	public AddressBI(String street, String zipcode, String city) {
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public UserBI getUser() {
		return user;
	}

}
