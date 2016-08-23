package org.akaza.openclinica.domain.datamap;

// Generated Jul 31, 2013 2:03:33 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.akaza.openclinica.domain.enumsupport.Status;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * EventDefinitionCrf generated by hbm2java
 */
@Entity
@Table(name = "event_definition_crf")
@GenericGenerator(name = "id-generator", strategy = "native", parameters = { @Parameter(name = "sequence", value = "event_definition_crf_event_definition_crf_id_seq") })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EventDefinitionCrf extends DataMapDomainObject {

	private int eventDefinitionCrfId;
	private UserAccount userAccount;
	private StudyEventDefinition studyEventDefinition;
	private CrfVersion crfVersion;
	private Study study;
	private Integer statusId;
	private CrfBean crf;
	private Boolean requiredCrf;
	private Boolean doubleEntry;
	private Boolean requireAllTextFilled;
	private Boolean decisionConditions;
	private String nullValues;
	private Date dateCreated;
	private Date dateUpdated;
	private Integer updateId;
	private Integer ordinal;
	private Boolean electronicSignature;
	private Boolean hideCrf;
	private Integer sourceDataVerificationCode;
	private String selectedVersionIds;
	private Integer parentId;
	private Set datasetCrfVersionMaps = new HashSet(0);
	private Boolean paricipantForm;
	private Boolean allowAnonymousSubmission;
	private String submissionUrl;

	public EventDefinitionCrf() {
	}

	public EventDefinitionCrf(int eventDefinitionCrfId) {
		this.eventDefinitionCrfId = eventDefinitionCrfId;
	}

	public EventDefinitionCrf(int eventDefinitionCrfId, UserAccount userAccount, StudyEventDefinition studyEventDefinition, CrfVersion crfVersion, Study study, Integer statusId, CrfBean crf,
			Boolean requiredCrf, Boolean doubleEntry, Boolean requireAllTextFilled, Boolean decisionConditions, String nullValues, Date dateCreated, Date dateUpdated, Integer updateId,
			Integer ordinal, Boolean electronicSignature, Boolean hideCrf, Boolean participantForm, Integer sourceDataVerificationCode, String selectedVersionIds, Integer parentId,
			Set datasetCrfVersionMaps) {
		this.eventDefinitionCrfId = eventDefinitionCrfId;
		this.userAccount = userAccount;
		this.studyEventDefinition = studyEventDefinition;
		this.crfVersion = crfVersion;
		this.study = study;
		this.statusId = statusId;
		this.crf = crf;
		this.requiredCrf = requiredCrf;
		this.doubleEntry = doubleEntry;
		this.requireAllTextFilled = requireAllTextFilled;
		this.decisionConditions = decisionConditions;
		this.nullValues = nullValues;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.updateId = updateId;
		this.ordinal = ordinal;
		this.electronicSignature = electronicSignature;
		this.hideCrf = hideCrf;
		this.paricipantForm = participantForm;
		this.sourceDataVerificationCode = sourceDataVerificationCode;
		this.selectedVersionIds = selectedVersionIds;
		this.parentId = parentId;
		this.datasetCrfVersionMaps = datasetCrfVersionMaps;
	}

	@Id
	@Column(name = "event_definition_crf_id", unique = true, nullable = false)
	@GeneratedValue(generator = "id-generator")
	public int getEventDefinitionCrfId() {
		return this.eventDefinitionCrfId;
	}

	public void setEventDefinitionCrfId(int eventDefinitionCrfId) {
		this.eventDefinitionCrfId = eventDefinitionCrfId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id")
	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "study_event_definition_id")
	public StudyEventDefinition getStudyEventDefinition() {
		return this.studyEventDefinition;
	}

	public void setStudyEventDefinition(StudyEventDefinition studyEventDefinition) {
		this.studyEventDefinition = studyEventDefinition;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "default_version_id")
	public CrfVersion getCrfVersion() {
		return this.crfVersion;
	}

	public void setCrfVersion(CrfVersion crfVersion) {
		this.crfVersion = crfVersion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "study_id")
	public Study getStudy() {
		return this.study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	@Column(name = "status_id")
	public Integer getStatusId() {
		if (statusId != null) {
			return statusId;
		} else
			return Status.AVAILABLE.getCode();
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "crf_id")
	public CrfBean getCrf() {
		return this.crf;
	}

	public void setCrf(CrfBean crf) {
		this.crf = crf;
	}

	@Column(name = "required_crf")
	public Boolean getRequiredCrf() {
		return this.requiredCrf;
	}

	public void setRequiredCrf(Boolean requiredCrf) {
		this.requiredCrf = requiredCrf;
	}

	@Column(name = "double_entry")
	public Boolean getDoubleEntry() {
		return this.doubleEntry;
	}

	public void setDoubleEntry(Boolean doubleEntry) {
		this.doubleEntry = doubleEntry;
	}

	@Column(name = "require_all_text_filled")
	public Boolean getRequireAllTextFilled() {
		return this.requireAllTextFilled;
	}

	public void setRequireAllTextFilled(Boolean requireAllTextFilled) {
		this.requireAllTextFilled = requireAllTextFilled;
	}

	@Column(name = "decision_conditions")
	public Boolean getDecisionConditions() {
		return this.decisionConditions;
	}

	public void setDecisionConditions(Boolean decisionConditions) {
		this.decisionConditions = decisionConditions;
	}

	@Column(name = "null_values")
	public String getNullValues() {
		return this.nullValues;
	}

	public void setNullValues(String nullValues) {
		this.nullValues = nullValues;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_created", length = 4)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_updated", length = 4)
	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Column(name = "update_id")
	public Integer getUpdateId() {
		return this.updateId;
	}

	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	@Column(name = "ordinal")
	public Integer getOrdinal() {
		return this.ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

	@Column(name = "electronic_signature")
	public Boolean getElectronicSignature() {
		return this.electronicSignature;
	}

	public void setElectronicSignature(Boolean electronicSignature) {
		this.electronicSignature = electronicSignature;
	}

	@Column(name = "hide_crf")
	public Boolean getHideCrf() {
		return this.hideCrf;
	}

	public void setHideCrf(Boolean hideCrf) {
		this.hideCrf = hideCrf;
	}

	@Column(name = "source_data_verification_code")
	public Integer getSourceDataVerificationCode() {
		return this.sourceDataVerificationCode;
	}

	public void setSourceDataVerificationCode(Integer sourceDataVerificationCode) {
		this.sourceDataVerificationCode = sourceDataVerificationCode;
	}

	@Column(name = "selected_version_ids", length = 150)
	public String getSelectedVersionIds() {
		return this.selectedVersionIds;
	}

	public void setSelectedVersionIds(String selectedVersionIds) {
		this.selectedVersionIds = selectedVersionIds;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "participant_form")
	public Boolean getParicipantForm() {
		return paricipantForm;
	}

	public void setParicipantForm(Boolean paricipantForm) {
		this.paricipantForm = paricipantForm;
	}

	@Column(name = "allow_anonymous_submission")
	public Boolean getAllowAnonymousSubmission() {
		return allowAnonymousSubmission;
	}

	public void setAllowAnonymousSubmission(Boolean allowAnonymousSubmission) {
		this.allowAnonymousSubmission = allowAnonymousSubmission;
	}

	@Column(name = "submission_url")
	public String getSubmissionUrl() {
		return submissionUrl;
	}

	public void setSubmissionUrl(String submissionUrl) {
		this.submissionUrl = submissionUrl;
	}

	
	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "eventDefinitionCrf")
	// public Set getDatasetCrfVersionMaps() {
	// return this.datasetCrfVersionMaps;
	// }
	//
	// public void setDatasetCrfVersionMaps(Set datasetCrfVersionMaps) {
	// this.datasetCrfVersionMaps = datasetCrfVersionMaps;
	// }

}
