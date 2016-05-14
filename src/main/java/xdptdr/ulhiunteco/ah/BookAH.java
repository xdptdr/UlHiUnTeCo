package xdptdr.ulhiunteco.ah;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_AH")
public class BookAH {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ElementCollection(targetClass = String.class)
	@JoinTable(name = "CHAPTER_AH", joinColumns = @JoinColumn(name = "BOOK_ID"))
	@Column(name="CHAPTER")
	private Set<String> chapters;

	public BookAH() {
	}

	public BookAH(String name, Set<String> chapters) {
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

	public Set<String> getChapters() {
		return chapters;
	}

	public void setChapters(Set<String> chapters) {
		this.chapters = chapters;
	}

}
