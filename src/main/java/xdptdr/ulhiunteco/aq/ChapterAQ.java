package xdptdr.ulhiunteco.aq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHAPTER_AQ")
public class ChapterAQ {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CHAPTER_ID")
	private Long id;

	@Column(name = "TITLE")
	private String title;

	@ManyToOne
	@JoinTable(name = "BOOK_CHAPTER_AQ", joinColumns = @JoinColumn(name = "CHAPTER_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	private BookAQ book;

	public ChapterAQ() {
	}

	public ChapterAQ(String title, BookAQ book) {
		this.title = title;
		this.book = book;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BookAQ getBook() {
		return book;
	}

	public void setBook(BookAQ book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChapterAQ other = (ChapterAQ) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
