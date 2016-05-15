package xdptdr.ulhiunteco.aw;

public class AWUtils {

	public static void bindUses(PersonAW person, BuildingAW building) {
		person.getUses().add(building);
		building.getUsedBy().add(person);
	}

	public static void bindOwns(PersonAW person, BuildingAW building) {
		person.getOwns().add(building);
		building.getOwnedBy().add(person);
	}

}
