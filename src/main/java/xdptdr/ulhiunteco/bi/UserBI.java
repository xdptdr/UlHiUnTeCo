package xdptdr.ulhiunteco.bi;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_BI")
public class UserBI {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET", nullable = false)),
			@AttributeOverride(name = "zipcode", column = @Column(name = "BILLING_ZIPCODE", nullable = false)),
			@AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY", nullable = false)) })
	private AddressBI billingAddress;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET", nullable = false)),
			@AttributeOverride(name = "zipcode", column = @Column(name = "HOME_ZIPCODE", nullable = false)),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY", nullable = false)) })
	private AddressBI homeAddress;

	public UserBI() {
	}

	public UserBI(String name, AddressBI billingAddress, AddressBI homeAddress) {
		this.name = name;
		this.billingAddress = billingAddress;
		this.homeAddress = homeAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressBI getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressBI billingAddress) {
		this.billingAddress = billingAddress;
	}

	public AddressBI getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(AddressBI homeAddress) {
		this.homeAddress = homeAddress;
	}

}
