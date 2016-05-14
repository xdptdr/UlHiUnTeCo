package xdptdr.ulhiunteco.ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "BOOK_AD")
public class BookAD {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long bookId;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	private PublisherAD publisher;

	public BookAD() {
	}

	public BookAD(String name, PublisherAD publisher) {
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

	public PublisherAD getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherAD publisher) {
		this.publisher = publisher;
	}

}
