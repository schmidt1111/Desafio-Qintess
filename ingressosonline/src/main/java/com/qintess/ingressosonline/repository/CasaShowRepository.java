package com.qintess.ingressosonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.qintess.ingressosonline.entity.CasaShow;

//@RepositoryRestResource(collectionResourceRel="casaShow", path="casa-show")
@Repository
public interface CasaShowRepository extends JpaRepository<CasaShow, Long> {

}

