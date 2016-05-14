package xdptdr.ulhiunteco.al;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

@Entity
@Table(name = "BOOK_AL")
public class BookAL {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ElementCollection(targetClass = String.class)
	@JoinTable(name = "CHAPTER_AL", joinColumns = @JoinColumn(name = "BOOK_ID"))
	@OrderColumn(name = "CHAPTER_INDEX")
	@ListIndexBase(value = 0)
	@Column(name = "CHAPTER")
	private String[] chapters;

	public BookAL() {
	}

	public BookAL(String name, String[] chapters) {
		this.name = name;
		this.chapters = chapters;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getChapters() {
		return chapters;
	}

	public void setChapters(String[] chapters) {
		this.chapters = chapters;
	}

}
