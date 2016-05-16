package xdptdr.ulhiunteco.bx;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CountryBX extends NamedItemBX {

	@Column(name = "POPULATION")
	Integer population;

	public CountryBX() {
		super();
	}

	public CountryBX(String name, Integer population) {
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
