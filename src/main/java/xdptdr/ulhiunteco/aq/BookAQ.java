package xdptdr.ulhiunteco.aq;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_AQ")
public class BookAQ {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(orphanRemoval = true, mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ChapterAQ> chapters;

	public BookAQ() {
	}

	public BookAQ(String name, Set<ChapterAQ> chapters) {
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

	public Set<ChapterAQ> getChapters() {
		return chapters;
	}

	public void setChapters(Set<ChapterAQ> chapters) {
		this.chapters = chapters;
	}

}
