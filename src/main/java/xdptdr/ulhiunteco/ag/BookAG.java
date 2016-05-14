package xdptdr.ulhiunteco.ag;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "BOOK_AG")
public class BookAG {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long bookId;

	@Column(name = "NAME")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	private PublisherAG publisher;

	public BookAG() {
	}

	public BookAG(String name, PublisherAG publisher) {
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

	public PublisherAG getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherAG publisher) {
		this.publisher = publisher;
	}

}
