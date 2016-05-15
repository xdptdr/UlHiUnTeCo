package xdptdr.ulhiunteco.ay;

public class AYUtils {

	public static void bindUses(PersonAY person, BuildingAY building) {
		person.getUses().add(building);
		building.getUsedBy().add(person);
	}

	public static void bindOwns(PersonAY person, BuildingAY building) {
		person.getOwns().add(building);
		building.setOwnedBy(person);
	}

	public static boolean doesPersonOwnsBuilding(PersonAY person, BuildingAY daBuilding) {
		for (BuildingAY building : person.getOwns()) {
			if (building.equals(daBuilding)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isBuildingOwnedByPerson(BuildingAY building, PersonAY daPerson) {
		return daPerson.equals(building.getOwnedBy());
	}

}
