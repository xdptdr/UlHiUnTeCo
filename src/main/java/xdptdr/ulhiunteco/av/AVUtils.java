package xdptdr.ulhiunteco.av;

public class AVUtils {

	public static void bindUses(PersonAV person, BuildingAV building) {
		person.getUses().add(building);
		building.getUsedBy().add(person);
	}

	public static void bindCleans(PersonAV person, BuildingAV building) {
		person.getCleans().add(building);
		building.getCleanedBy().add(person);
	}

}
