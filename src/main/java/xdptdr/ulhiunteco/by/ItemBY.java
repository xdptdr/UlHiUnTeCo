package xdptdr.ulhiunteco.by;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;
import org.hibernate.annotations.SortNatural;

@Entity
@Table(name = "ITEM_BY")
public class ItemBY {

	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ElementCollection
	@JoinTable(name = "ITEM_SET_OF_IMAGE_NAMES_BY", joinColumns = @JoinColumn(name = "ITEM_ID"))
	@Column(name = "SET_OF_IMAGE_NAMES")
	private Set<String> setOfImageNames = new HashSet<String>();

	@ElementCollection
	@JoinTable(name = "ITEM_LIST_OF_IMAGE_NAMES_BY", joinColumns = @JoinColumn(name = "ITEM_ID"))
	@OrderColumn(name = "`ORDER`")
	@ListIndexBase(value = 0)
	@Column(name = "LIST_OF_IMAGE_NAMES")
	private List<String> listOfImageNames = new ArrayList<String>();

	@ElementCollection
	@JoinTable(name = "ITEM_MAP_OF_IMAGE_NAMES_TO_DESCRIPTION_BY", joinColumns = @JoinColumn(name = "ITEM_ID"))
	@MapKeyColumn(name = "DESCRIPTION")
	@Column(name = "LIST_OF_IMAGE_NAMES_TO_DESCRIPTION")
	private Map<String, String> mapOfImageNamesToDescriptions = new HashMap<String, String>();

	@ElementCollection
	@JoinTable(name = "ITEM_SORTED_SET_OF_IMAGE_NAMES_BY", joinColumns = @JoinColumn(name = "ITEM_ID"))
	@SortNatural
	@Column(name = "SORTED_SET_OF_IMAGE_NAMES")
	private SortedSet<String> sortedSetOfImageNames = new TreeSet<String>();

	@ElementCollection
	@JoinTable(name = "ITEM_SET_OF_IMAGES_BY", joinColumns = @JoinColumn(name = "ITEM_ID"))
	@AttributeOverride(name = "element.name", column = @Column(name = "IMAGE_NAME", nullable = false))
	private Set<ImageBY> setOfImages = new HashSet<ImageBY>();

	
//	@ElementCollection
//	@JoinTable(name = "ITEM_COLLECTION_OF_IMAGES_BY", joinColumns = @JoinColumn(name = "ITEM_ID"))
//	@CollectionId(columns = @Column(name = "ITEM_IMAGE_ID"), type = @Type(type = "long"), generator = "table")
//	private Collection<ImageBY> collectionOfImages = new ArrayList<ImageBY>();

	public ItemBY() {
	}

	public ItemBY(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getSetOfImageNames() {
		return setOfImageNames;
	}

	public List<String> getListOfImageNames() {
		return listOfImageNames;
	}

	public Map<String, String> getMapOfImageNamesToDescriptions() {
		return mapOfImageNamesToDescriptions;
	}

	public SortedSet<String> getSortedSetOfImageNames() {
		return sortedSetOfImageNames;
	}

	public Set<ImageBY> getSetOfImages() {
		return setOfImages;
	}

	// public Collection<ImageBY> getCollectionOfImages() {
	// return collectionOfImages;
	// }

}
