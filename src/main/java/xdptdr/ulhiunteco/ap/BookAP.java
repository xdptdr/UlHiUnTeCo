package xdptdr.ulhiunteco.ap;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "BOOK_AP")
public class BookAP {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(targetEntity = ChapterAP.class, orphanRemoval = true, mappedBy = "book")
	
	@Cascade(value = CascadeType.SAVE_UPDATE)
	private Set<ChapterAP> chapters;

	public BookAP() {
	}

	public BookAP(String name, Set<ChapterAP> chapters) {
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

	public Set<ChapterAP> getChapters() {
		return chapters;
	}

	public void setChapters(Set<ChapterAP> chapters) {
		this.chapters = chapters;
	}

}
