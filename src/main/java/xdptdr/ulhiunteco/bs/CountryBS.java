package xdptdr.ulhiunteco.bs;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CountryBS extends NamedItemBS {

	@Column(name = "POPULATION")
	Integer population;

	public CountryBS() {
		super();
	}

	public CountryBS(String name, Integer population) {
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
