package com.enigma.challengedatapenduduk.repository;

import com.enigma.challengedatapenduduk.model.Penduduk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PendudukRepo extends JpaRepository<Penduduk, Long> {
    List<Penduduk> findByNamaContains(String name);
    Optional<Penduduk> findByNikEquals(String nik);
}
