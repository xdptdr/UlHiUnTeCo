package xdptdr.ulhiunteco.an;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS_AN")
public class ClassAN {

	@Id
	@Column(name = "CANONICAL_CLASS_NAME")
	private String canonicalClassName;

	@Column(name = "CLASS_NAME")
	String className;

	@Column(name = "PACKAGE_NAME")
	private String packageName;

	@Column(name = "IS_ANNOTATION")
	private boolean isAnnotation;

	@Column(name = "IS_INTERFACE")
	private boolean isInterface;

	@Column(name = "REFERENCE")
	private String reference;

	public ClassAN() {
	}

	public ClassAN(Class<?> clazz) {
		className = clazz.getSimpleName();
		canonicalClassName = clazz.getCanonicalName();
		packageName = clazz.getPackage().getName();
		isAnnotation = clazz.isAnnotation();
		isInterface = clazz.isInterface();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCanonicalClassName() {
		return canonicalClassName;
	}

	public void setCanonicalClassName(String canonicalClassName) {
		this.canonicalClassName = canonicalClassName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public boolean isAnnotation() {
		return isAnnotation;
	}

	public void setAnnotation(boolean isAnnotation) {
		this.isAnnotation = isAnnotation;
	}

	public boolean isInterface() {
		return isInterface;
	}

	public void setInterface(boolean isInterface) {
		this.isInterface = isInterface;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

}
