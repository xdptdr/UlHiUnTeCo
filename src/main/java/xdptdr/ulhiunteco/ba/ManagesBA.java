package xdptdr.ulhiunteco.ba;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGES_BA")
public class ManagesBA {

	@Embeddable
	public static class Pk implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "MANAGER_ID", nullable = false, updatable = false)
		private Long managerId;

		@Column(name = "SUBORDINATE_ID", nullable = false, updatable = false)
		private Long subordinateId;

		public Pk() {
		}

		public Pk(Long managerId, Long subordinateId) {
			this.managerId = managerId;
			this.subordinateId = subordinateId;
		}

		public Long getSubordinateId() {
			return subordinateId;
		}

		public void setSubordinateId(Long subordinateId) {
			this.subordinateId = subordinateId;
		}

		public Long getManagerId() {
			return managerId;
		}

		public void setManagerId(Long managerId) {
			this.managerId = managerId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
			result = prime * result + ((subordinateId == null) ? 0 : subordinateId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pk other = (Pk) obj;
			if (managerId == null) {
				if (other.managerId != null)
					return false;
			} else if (!managerId.equals(other.managerId))
				return false;
			if (subordinateId == null) {
				if (other.subordinateId != null)
					return false;
			} else if (!subordinateId.equals(other.subordinateId))
				return false;
			return true;
		}

	}

	@EmbeddedId
	Pk pk;

	@ManyToOne
	@JoinColumn(name = "MANAGER_ID", insertable = false, updatable = false)
	private EmployeeBA manager;

	@ManyToOne
	@JoinColumn(name = "SUBORDINATE_ID", insertable = false, updatable = false)
	private EmployeeBA subordinate;

	public ManagesBA() {
	}

	public ManagesBA(EmployeeBA manager, EmployeeBA subordinate) {
		this.manager = manager;
		this.subordinate = subordinate;
		pk = new Pk(manager.getId(), subordinate.getId());
	}

	public Pk getPk() {
		return pk;
	}

	public void setPk(Pk pk) {
		this.pk = pk;
	}

	public EmployeeBA getManager() {
		return manager;
	}

	public void setManager(EmployeeBA manager) {
		this.manager = manager;
	}

	public EmployeeBA getSubordinate() {
		return subordinate;
	}

	public void setSubordinate(EmployeeBA subordinate) {
		this.subordinate = subordinate;
	}

}
