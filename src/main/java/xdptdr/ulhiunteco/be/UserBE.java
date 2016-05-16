package xdptdr.ulhiunteco.be;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_BE")
public class UserBE {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "BILLING_STREET")
	private String billingStreet;

	@Column(name = "BILLING_ZIPCODE")
	private String billingZipcode;

	@Column(name = "BILLING_CITY")
	private String billingCity;

	@Column(name = "HOME_STREET")
	private String homeStreet;

	@Column(name = "HOME_ZIPCODE")
	private String homeZipCode;

	@Column(name = "HOME_CITY")
	private String homeCity;

	public UserBE() {
	}

	public UserBE(String name, String billingStreet, String billingZipcode, String billingCity, String homeStreet,
			String homeZipCode, String homeCity) {
		this.name = name;
		this.billingStreet = billingStreet;
		this.billingZipcode = billingZipcode;
		this.billingCity = billingCity;
		this.homeStreet = homeStreet;
		this.homeZipCode = homeZipCode;
		this.homeCity = homeCity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBillingStreet() {
		return billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}

	public String getBillingZipcode() {
		return billingZipcode;
	}

	public void setBillingZipcode(String billingZipcode) {
		this.billingZipcode = billingZipcode;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getHomeStreet() {
		return homeStreet;
	}

	public String getHomeZipCode() {
		return homeZipCode;
	}

	public void setHomeZipCode(String homeZipCode) {
		this.homeZipCode = homeZipCode;
	}

	public void setHomeStreet(String homeStreet) {
		this.homeStreet = homeStreet;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

}
