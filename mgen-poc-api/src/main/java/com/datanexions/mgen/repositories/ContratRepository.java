package com.datanexions.mgen.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.datanexions.mgen.models.contrat.Contrat;
@Repository
public interface ContratRepository {
   
    Optional<Contrat> findById(String id);
}
