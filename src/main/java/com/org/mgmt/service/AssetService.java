package com.org.mgmt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.mgmt.dto.AssetDTO;
import com.org.mgmt.entity.Asset;
import com.org.mgmt.mapper.AssetMapper;
import com.org.mgmt.repo.AssetRepository;

@Service
public class AssetService {

	@Autowired
	private AssetRepository assetRepository;

	public List<AssetDTO> getAssets() {
		List<AssetDTO> assetsDTO = new ArrayList<>();
		assetRepository.findAll().forEach(assetDTO -> {
			assetsDTO.add(AssetMapper.entityToDTO(assetDTO));
		});
		return assetsDTO;
	}

	public AssetDTO getAsset(Long assetId) {
		Optional<Asset> assetOp = assetRepository.findById(assetId);
		if (assetOp.isPresent()) {
			return AssetMapper.entityToDTO(assetOp.get());
		}
		return null;
	}

	public AssetDTO saveOrUpdate(AssetDTO assetDTO) {
		Asset asset = assetRepository.save(AssetMapper.dtoToEntity(assetDTO));
		return AssetMapper.entityToDTO(asset);
	}

	public void delete(Long assetId) {
		assetRepository.deleteById(assetId);
	}

}
