package cn.com.architecture.entity.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("date_created")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date dateCreated;

	@JsonProperty("created_by")
	private String createdBy;


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JsonProperty("date_updated")
	private Date dateUpdated;

	@JsonProperty("updated_by")
	private String updatedBy;

	public Date getDateCreated() {
		return dateCreated;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass()) {
			return false;
		}
		if (!getClass().isAssignableFrom(o.getClass()))
			return false;

		Auditable auditable = (Auditable) o;

		if (createdBy != null ? !createdBy.equals(auditable.createdBy) : auditable.createdBy != null)
			return false;
		if (dateCreated != null ? !dateCreated.equals(auditable.dateCreated) : auditable.dateCreated != null)
			return false;
		if (dateUpdated != null ? !dateUpdated.equals(auditable.dateUpdated) : auditable.dateUpdated != null)
			return false;
		if (updatedBy != null ? !updatedBy.equals(auditable.updatedBy) : auditable.updatedBy != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = dateCreated != null ? dateCreated.hashCode() : 0;
		result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
		result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
		result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Auditable [dateCreated=" + dateCreated + ", createdBy=" + createdBy + ", dateUpdated=" + dateUpdated
				+ ", updatedBy=" + updatedBy + "]";
	}
}
