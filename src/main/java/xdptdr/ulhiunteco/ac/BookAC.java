package xdptdr.ulhiunteco.ac;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class BookAC {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long bookId;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	private PublisherAC publisher;

	public BookAC() {
	}

	public BookAC(String name, PublisherAC publisher) {
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

	public PublisherAC getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherAC publisher) {
		this.publisher = publisher;
	}

}
