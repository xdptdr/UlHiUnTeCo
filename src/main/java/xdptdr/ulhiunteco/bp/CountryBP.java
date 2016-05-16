package xdptdr.ulhiunteco.bp;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CountryBP extends NamedItemBP {

	@Column(name = "POPULATION")
	Integer population;

	public CountryBP() {
		super();
	}

	public CountryBP(String name, Integer population) {
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
