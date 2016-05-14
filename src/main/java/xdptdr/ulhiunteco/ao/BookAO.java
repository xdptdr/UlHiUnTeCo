package xdptdr.ulhiunteco.ao;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "BOOK_AO")
public class BookAO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(targetEntity = ChapterAO.class, orphanRemoval = true)
	@JoinColumn(name = "BOOK_ID")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	private Set<ChapterAO> chapters;

	public BookAO() {
	}

	public BookAO(String name, Set<ChapterAO> chapters) {
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

	public Set<ChapterAO> getChapters() {
		return chapters;
	}

	public void setChapters(Set<ChapterAO> chapters) {
		this.chapters = chapters;
	}

}
