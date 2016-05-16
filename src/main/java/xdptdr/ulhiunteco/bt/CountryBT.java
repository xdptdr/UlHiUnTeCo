package xdptdr.ulhiunteco.bt;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CountryBT extends NamedItemBT {

	@Column(name = "POPULATION")
	Integer population;

	public CountryBT() {
		super();
	}

	public CountryBT(String name, Integer population) {
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
