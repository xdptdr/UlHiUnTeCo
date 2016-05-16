package xdptdr.ulhiunteco.bx;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@DiscriminatorValue("MOLBX")
@SecondaryTable(name = "MOLECULE_BX", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID"))
public class MoleculeBX extends NamedItemBX {

	@Column(name = "MOLAR_MASS", table="MOLECULE_BX")
	Integer molarMass;

	public MoleculeBX() {
		super();
	}

	public MoleculeBX(String name, Integer molarMass) {
		super(name);
		this.molarMass = molarMass;
	}

	public Integer getMolarMass() {
		return molarMass;
	}

	public void setMolarMass(Integer molarMass) {
		this.molarMass = molarMass;
	}

}
