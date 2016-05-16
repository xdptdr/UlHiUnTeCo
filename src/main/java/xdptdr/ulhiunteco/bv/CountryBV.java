package xdptdr.ulhiunteco.bv;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CountryBV extends NamedItemBV {

	@Column(name = "POPULATION")
	Integer population;

	public CountryBV() {
		super();
	}

	public CountryBV(String name, Integer population) {
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
