package com.org.mgmt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long assetId;
	@NotNull
	private String assetName;
	@NotNull
	private Double totalAsset;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "org_Id", referencedColumnName = "orgId")
	private Organization organization;

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public Double getTotalAsset() {
		return totalAsset;
	}

	public void setTotalAsset(Double totalAsset) {
		this.totalAsset = totalAsset;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
}
