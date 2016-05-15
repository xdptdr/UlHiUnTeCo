package xdptdr.ulhiunteco.az;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MEETS_AZ")
public class MeetsAZ {

	@Embeddable
	public static class Pk implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "CLASSROOM_ID", nullable = false, updatable = false)
		private Long classroomId;

		@Column(name = "COURSE_ID", nullable = false, updatable = false)
		private Long courseId;

		@Column(name = "DAY_ID", nullable = false, updatable = false)
		private Long dayId;

		public Pk() {
		}

		public Pk(Long classRoomId, Long courseId, Long dayId) {
			this.classroomId = classRoomId;
			this.courseId = courseId;
			this.dayId = dayId;
		}

		public Long getClassroomId() {
			return classroomId;
		}

		public void setClassroomId(Long classroomId) {
			this.classroomId = classroomId;
		}

		public Long getCourseId() {
			return courseId;
		}

		public void setCourseId(Long courseId) {
			this.courseId = courseId;
		}

		public Long getDayId() {
			return dayId;
		}

		public void setDayId(Long dayId) {
			this.dayId = dayId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((classroomId == null) ? 0 : classroomId.hashCode());
			result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
			result = prime * result + ((dayId == null) ? 0 : dayId.hashCode());
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
			if (classroomId == null) {
				if (other.classroomId != null)
					return false;
			} else if (!classroomId.equals(other.classroomId))
				return false;
			if (courseId == null) {
				if (other.courseId != null)
					return false;
			} else if (!courseId.equals(other.courseId))
				return false;
			if (dayId == null) {
				if (other.dayId != null)
					return false;
			} else if (!dayId.equals(other.dayId))
				return false;
			return true;
		}
	}

	@EmbeddedId
	Pk pk;

	@ManyToOne
	@JoinColumn(name = "CLASSROOM_ID", insertable = false, updatable = false)
	private ClassroomAZ classRoom;

	@ManyToOne
	@JoinColumn(name = "COURSE_ID", insertable = false, updatable = false)
	private CourseAZ course;

	@ManyToOne
	@JoinColumn(name = "DAY_ID", insertable = false, updatable = false)
	private DayAZ day;

	public MeetsAZ() {
	}

	public MeetsAZ(ClassroomAZ classRoom, CourseAZ course, DayAZ day) {
		this.classRoom = classRoom;
		this.course = course;
		this.day = day;
		pk = new Pk(classRoom.getId(), course.getId(), day.getId());
	}

	public ClassroomAZ getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassroomAZ classRoom) {
		this.classRoom = classRoom;
	}

	public CourseAZ getCourse() {
		return course;
	}

	public void setCourse(CourseAZ course) {
		this.course = course;
	}

	public DayAZ getDay() {
		return day;
	}

	public void setDay(DayAZ day) {
		this.day = day;
	}

	public Pk getPk() {
		return pk;
	}

	public void setPk(Pk pk) {
		this.pk = pk;
	}

}
