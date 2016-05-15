package xdptdr.ulhiunteco.bc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ISBORNIN_BC")
public class IsBornInBC {

	@Embeddable
	public static class Pk implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "PERSON_ID", nullable = false, updatable = false)
		private Long personId;

		@Column(name = "CITY_ID", nullable = false, updatable = false)
		private Long cityId;

		public Pk() {
		}

		public Pk(Long personId, Long cityId) {
			this.personId = personId;
			this.cityId = cityId;
		}

		public Long getPersonId() {
			return personId;
		}

		public void setPersonId(Long personId) {
			this.personId = personId;
		}

		public Long getCityId() {
			return cityId;
		}

		public void setCityId(Long cityId) {
			this.cityId = cityId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((personId == null) ? 0 : personId.hashCode());
			result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
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
			Pk other = (Pk) obj;
			if (personId == null) {
				if (other.personId != null)
					return false;
			} else if (!personId.equals(other.personId))
				return false;
			if (cityId == null) {
				if (other.cityId != null)
					return false;
			} else if (!cityId.equals(other.cityId))
				return false;

			return true;
		}

	}

	@EmbeddedId
	Pk pk;

	@ManyToOne
	@JoinColumn(name = "PERSON_ID", insertable = false, updatable = false)
	private PersonBC person;

	@ManyToOne
	@JoinColumn(name = "CITY_ID", insertable = false, updatable = false)
	private CityBC city;

	@Column(name = "BIRTH_YEAR")
	Integer birthYear;

	public IsBornInBC() {
	}

	public IsBornInBC(PersonBC person, CityBC city, Integer birthYear) {
		this.person = person;
		this.city = city;
		this.birthYear = birthYear;
		pk = new Pk(person.getId(), city.getId());
	}

	public Pk getPk() {
		return pk;
	}

	public void setPk(Pk pk) {
		this.pk = pk;
	}

	public PersonBC getPerson() {
		return person;
	}

	public void setPerson(PersonBC person) {
		this.person = person;
	}

	public CityBC getCity() {
		return city;
	}

	public void setCity(CityBC city) {
		this.city = city;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

}
