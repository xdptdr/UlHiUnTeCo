package xdptdr.ulhiunteco.ax;

public class AXUtils {

	public static void bindUses(PersonAX person, BuildingAX building) {
		person.getUses().add(building);
		building.getUsedBy().add(person);
	}

	public static void bindOwns(PersonAX person, BuildingAX building) {
		person.getOwns().add(building);
		building.setOwnedBy(person);
	}

	public static boolean doesPersonOwnsBuilding(PersonAX person, BuildingAX daBuilding) {
		for (BuildingAX building : person.getOwns()) {
			if (building.equals(daBuilding)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isBuildingOwnedByPerson(BuildingAX building, PersonAX daPerson) {
		return daPerson.equals(building.getOwnedBy());
	}

}
