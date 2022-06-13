package com.example.demo.repositories;

import com.example.demo.models.ProyectoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ProyectoRepository extends CrudRepository<ProyectoModel, Long> {
    public abstract ArrayList<ProyectoModel> findByNombre(String nombre);

}
