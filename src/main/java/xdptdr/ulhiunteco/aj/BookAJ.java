package xdptdr.ulhiunteco.aj;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "BOOK_AJ")
public class BookAJ {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ElementCollection(targetClass = String.class)
	@JoinTable(name = "CHAPTER_AJ", joinColumns = @JoinColumn(name = "BOOK_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = @Column(name = "CHAPTER_ID"), type = @Type(type = "long"), generator = "hilo-gen")
	@Column(name = "CHAPTER")
	private List<String> chapters;

	public BookAJ() {
	}

	public BookAJ(String name, List<String> chapters) {
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

	public List<String> getChapters() {
		return chapters;
	}

	public void setChapters(List<String> chapters) {
		this.chapters = chapters;
	}

}
