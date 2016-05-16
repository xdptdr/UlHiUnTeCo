package xdptdr.ulhiunteco.bw;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "COUNTRY_ID")
public class CountryBW extends NamedItemBW {

	@Column(name = "POPULATION")
	Integer population;

	public CountryBW() {
		super();
	}

	public CountryBW(String name, Integer population) {
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
