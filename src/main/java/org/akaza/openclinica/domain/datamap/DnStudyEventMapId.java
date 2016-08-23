package org.akaza.openclinica.domain.datamap;

// default package
// Generated Aug 8, 2013 11:32:37 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DnStudyEventMapId generated by hbm2java
 */
@Embeddable
public class DnStudyEventMapId extends DataMapDomainObject {

	private Integer studyEventId;
	private Integer discrepancyNoteId;
	private String columnName;

	public DnStudyEventMapId() {
	}

	public DnStudyEventMapId(Integer studyEventId, Integer discrepancyNoteId,
			String columnName) {
		this.studyEventId = studyEventId;
		this.discrepancyNoteId = discrepancyNoteId;
		this.columnName = columnName;
	}

	@Column(name = "study_event_id")
	public Integer getStudyEventId() {
		return this.studyEventId;
	}

	public void setStudyEventId(Integer studyEventId) {
		this.studyEventId = studyEventId;
	}

	@Column(name = "discrepancy_note_id")
	public Integer getDiscrepancyNoteId() {
		return this.discrepancyNoteId;
	}

	public void setDiscrepancyNoteId(Integer discrepancyNoteId) {
		this.discrepancyNoteId = discrepancyNoteId;
	}

	@Column(name = "column_name")
	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DnStudyEventMapId))
			return false;
		DnStudyEventMapId castOther = (DnStudyEventMapId) other;

		return ((this.getStudyEventId() == castOther.getStudyEventId()) || (this
				.getStudyEventId() != null
				&& castOther.getStudyEventId() != null && this
				.getStudyEventId().equals(castOther.getStudyEventId())))
				&& ((this.getDiscrepancyNoteId() == castOther
						.getDiscrepancyNoteId()) || (this
						.getDiscrepancyNoteId() != null
						&& castOther.getDiscrepancyNoteId() != null && this
						.getDiscrepancyNoteId().equals(
								castOther.getDiscrepancyNoteId())))
				&& ((this.getColumnName() == castOther.getColumnName()) || (this
						.getColumnName() != null
						&& castOther.getColumnName() != null && this
						.getColumnName().equals(castOther.getColumnName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStudyEventId() == null ? 0 : this.getStudyEventId()
						.hashCode());
		result = 37
				* result
				+ (getDiscrepancyNoteId() == null ? 0 : this
						.getDiscrepancyNoteId().hashCode());
		result = 37
				* result
				+ (getColumnName() == null ? 0 : this.getColumnName()
						.hashCode());
		return result;
	}

	
}
