package com.make.assure.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.make.assure.models.SocialMedia;

@Repository
public interface SocialMediaDao extends CrudRepository<SocialMedia, Integer>{

}
