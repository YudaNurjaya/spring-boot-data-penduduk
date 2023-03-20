package com.enigma.challengedatapenduduk.repository;

import com.enigma.challengedatapenduduk.model.Penduduk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PendudukRepo extends JpaRepository<Penduduk, Long> {
    List<Penduduk> findByNamaContains(String name);
}
