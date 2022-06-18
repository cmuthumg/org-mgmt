package com.org.mgmt.mapper;

import com.org.mgmt.dto.AssetDTO;
import com.org.mgmt.entity.Asset;

public class AssetMapper {

	public static AssetDTO entityToDTO(Asset asset) {
		AssetDTO assetDTO = new AssetDTO();
		assetDTO.setAssetId(asset.getAssetId());
		assetDTO.setAssetName(asset.getAssetName());
		assetDTO.setTotalAsset(asset.getTotalAsset());
		return assetDTO;
	}

	public static Asset dtoToEntity(AssetDTO assetDTO) {
		Asset asset = new Asset();
		asset.setAssetName(assetDTO.getAssetName());
		asset.setTotalAsset(assetDTO.getTotalAsset());
		return asset;
	}
}
