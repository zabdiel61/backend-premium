package com.zd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zd.entities.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
