package xdptdr.ulhiunteco.ae;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import xdptdr.ulhiunteco.ad.PublisherAD;

@Entity
@Table(name = "Book")
public class BookAE {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long bookId;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinTable(name = "BOOK_PUBLISHER", joinColumns = @JoinColumn(name = "BOOK_ID"), inverseJoinColumns = @JoinColumn(name = "PUBLISHER_ID"))
	private PublisherAE publisher;

	public BookAE() {
	}

	public BookAE(String name, PublisherAE publisher) {
		this.name = name;
		this.publisher = publisher;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PublisherAE getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherAE publisher) {
		this.publisher = publisher;
	}

}
