package org.akaza.openclinica.domain.datamap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * NullValueType generated by hbm2java
 */
@Entity
@Table(name = "null_value_type")
@GenericGenerator(name = "id-generator", strategy = "native", parameters = { @Parameter(name = "sequence", value = "authorities_id_seq") })
public class NullValueType  extends AbstractMutableDomainObject {

	private int nullValueTypeId;
	private String code;
	private String name;
	private String definition;
	private String reference;

	public NullValueType() {
	}

	public NullValueType(int nullValueTypeId) {
		this.nullValueTypeId = nullValueTypeId;
	}

	public NullValueType(int nullValueTypeId, String code, String name,
			String definition, String reference) {
		this.nullValueTypeId = nullValueTypeId;
		this.code = code;
		this.name = name;
		this.definition = definition;
		this.reference = reference;
	}

	@Id
	@Column(name = "null_value_type_id", unique = true, nullable = false)
	public int getNullValueTypeId() {
		return this.nullValueTypeId;
	}

	public void setNullValueTypeId(int nullValueTypeId) {
		this.nullValueTypeId = nullValueTypeId;
	}

	@Column(name = "code", length = 20)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "definition", length = 1000)
	public String getDefinition() {
		return this.definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	@Column(name = "reference", length = 1000)
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

}
