package xdptdr.ulhiunteco.ae;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PUBLISHER_AE")
public class PublisherAE {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PUBLISHER_ID")
	private Long publisherId;

	@Column(name="NAME")
	private String name;

	public PublisherAE() {
	}

	public PublisherAE(String name) {
		this.name = name;
	}

	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
