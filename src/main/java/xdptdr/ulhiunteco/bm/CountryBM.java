package xdptdr.ulhiunteco.bm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CountryBM extends NamedItemBM {

	@Id
	@GeneratedValue
	@Column(name = "COUNTRY_ID")
	private Long countryId;

	@Column(name = "POPULATION")
	Integer population;

	public CountryBM() {
		super();
	}

	public CountryBM(String name, Integer population) {
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
