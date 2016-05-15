package xdptdr.ulhiunteco.ay;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BUILDING_AY")
public class BuildingAY implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", unique = true)
	private String name;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "PERSON_USES_BUILDING_AY", joinColumns = @JoinColumn(name = "BUILDING_ID"), inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
	private Set<PersonAY> usedBy = new HashSet<>();

	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "PERSON_OWNS_BUILDING_AY", joinColumns = @JoinColumn(name = "BUILDING_ID"), inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
	private PersonAY ownedBy;

	public BuildingAY() {
	}

	public BuildingAY(String name) {
		this.name = name;
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

	public Set<PersonAY> getUsedBy() {
		return usedBy;
	}

	public void setUsedBy(Set<PersonAY> usedBy) {
		this.usedBy = usedBy;
	}
	
	public PersonAY getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(PersonAY ownedBy) {
		this.ownedBy = ownedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		BuildingAY other = (BuildingAY) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
