package xdptdr.ulhiunteco.bo;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AttributeOverride(name = "name", column = @Column(name = "COUNTRY_NAME"))
public class CountryBO extends NamedItemBO {

	@Id
	@GeneratedValue
	@Column(name = "COUNTRY_ID")
	private Long countryId;

	@Column(name = "POPULATION")
	Integer population;

	public CountryBO() {
		super();
	}

	public CountryBO(String name, Integer population) {
		super(name);
		this.population = population;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

}
