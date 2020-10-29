package com.urest.v1.authoring_module.TF;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urest.v1.authoring_module.TF.TF;

@Repository
public interface TFRepository extends CrudRepository<TF, Integer>{

}
