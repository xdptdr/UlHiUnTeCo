package xdptdr.ulhiunteco.bu;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="DA_COUNTRY")
public class CountryBU extends NamedItemBU {

	@Column(name = "POPULATION")
	Integer population;

	public CountryBU() {
		super();
	}

	public CountryBU(String name, Integer population) {
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
