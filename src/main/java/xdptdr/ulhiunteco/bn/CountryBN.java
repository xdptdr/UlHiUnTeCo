package xdptdr.ulhiunteco.bn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CountryBN extends NamedItemBN {

	@Id
	@GeneratedValue
	@Column(name = "COUNTRY_ID")
	private Long countryId;

	@Column(name = "POPULATION")
	Integer population;

	public CountryBN() {
		super();
	}

	public CountryBN(String name, Integer population) {
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
