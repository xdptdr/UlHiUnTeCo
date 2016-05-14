package xdptdr.ulhiunteco.am;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_AM")
public class BookAM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ElementCollection(targetClass = String.class)
	@JoinTable(name = "CHAPTER_AM", joinColumns = @JoinColumn(name = "BOOK_ID"))
	@MapKeyColumn(name = "CHAPTER_KEY")
	@MapKeyClass(value = String.class)
	@Column(name = "CHAPTER")
	private Map<String, String> chapters;

	public BookAM() {
	}

	public BookAM(String name, Map<String, String> chapters) {
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

	public Map<String, String> getChapters() {
		return chapters;
	}

	public void setChapters(Map<String, String> chapters) {
		this.chapters = chapters;
	}

}
