package xdptdr.ulhiunteco.ar;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_AR")
public class BookAR {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "BOOK_CHAPTER_AR", joinColumns = @JoinColumn(name = "BOOK_ID"), inverseJoinColumns = @JoinColumn(name = "CHAPTER_ID"))
	private Set<ChapterAR> chapters;

	public BookAR() {
	}

	public BookAR(String name, Set<ChapterAR> chapters) {
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

	public Set<ChapterAR> getChapters() {
		return chapters;
	}

	public void setChapters(Set<ChapterAR> chapters) {
		this.chapters = chapters;
	}

}
