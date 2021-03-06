package xdptdr.ulhiunteco.bj;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CountryBJ extends NamedItemBJ {

	@Column(name = "POPULATION")
	Integer population;

	public CountryBJ() {
		super();
	}

	public CountryBJ(String name, Integer population) {
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
