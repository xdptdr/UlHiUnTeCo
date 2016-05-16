package xdptdr.ulhiunteco.br;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CountryBR extends NamedItemBR {

	@Column(name = "POPULATION")
	Integer population;

	public CountryBR() {
		super();
	}

	public CountryBR(String name, Integer population) {
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
