package xdptdr.ulhiunteco.bq;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CountryBQ extends NamedItemBQ {

	@Column(name = "POPULATION")
	Integer population;

	public CountryBQ() {
		super();
	}

	public CountryBQ(String name, Integer population) {
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
