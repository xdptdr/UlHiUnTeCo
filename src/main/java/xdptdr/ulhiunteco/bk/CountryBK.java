package xdptdr.ulhiunteco.bk;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CountryBK extends NamedItemBK {

	@Column(name = "POPULATION")
	Integer population;

	public CountryBK() {
		super();
	}

	public CountryBK(String name, Integer population) {
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
