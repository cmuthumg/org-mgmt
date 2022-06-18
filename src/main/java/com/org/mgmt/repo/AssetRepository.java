package com.org.mgmt.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.mgmt.entity.Asset;

@Repository
public interface AssetRepository extends CrudRepository<Asset, Long>{

}
