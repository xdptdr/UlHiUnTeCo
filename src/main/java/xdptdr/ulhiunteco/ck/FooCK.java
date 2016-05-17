package xdptdr.ulhiunteco.ck;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Foo_CK")
public class FooCK {

	@Id
	@GeneratedValue
	@Column(name = "FOO_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FOO_BAR_CK", joinColumns = @JoinColumn(name = "FOO_ID"), inverseJoinColumns = @JoinColumn(name = "BAR_ID"))
	@GenericGenerator(name="idgen",strategy="hilo")
	@CollectionId(columns = @Column(name = "FOO_BAR_ID"), type = @Type(type = "long"), generator = "idgen")
	private Collection<BarCK> bars = new ArrayList<>();

	public FooCK() {
	}

	public FooCK(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<BarCK> getBars() {
		return Collections.unmodifiableCollection(bars);
	}

	public void addBar(BarCK bar) {
		this.bars.add(bar);
	}

}
