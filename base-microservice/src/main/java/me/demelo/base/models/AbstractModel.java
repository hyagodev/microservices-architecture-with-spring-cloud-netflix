package me.demelo.base.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import me.demelo.base.enums.IEnum;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public abstract class AbstractModel<ID, STATUS extends IEnum<?>> {
	
	public abstract ID getId();
	public abstract STATUS getInitialStatus();
	protected abstract STATUS getDeletedStatus();
	
	@CreatedDate
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updatedAt;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private STATUS status;
	
	@PrePersist
	public void prePersist() {
		this.status = this.getInitialStatus();
	}
	
	public void setDeletedStatus() {
		this.status = this.getDeletedStatus();
	}
}
