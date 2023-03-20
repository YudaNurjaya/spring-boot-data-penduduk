package com.enigma.challengedatapenduduk.service;

import com.enigma.challengedatapenduduk.model.Kecamatan;
import com.enigma.challengedatapenduduk.repository.KecamatanRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class KecamatanService {
    @Autowired
    KecamatanRepo kecamatanRepo;
    public Iterable<Kecamatan> findAll(Pageable pageable) throws Exception{
        try {
            return kecamatanRepo.findAll();
        }catch (Exception e){
            throw new Exception("Data is empty");
        }
    }
    public Kecamatan save(Kecamatan kecamatan) throws Exception{
        try {
            return kecamatanRepo.save(kecamatan);
        }catch (Exception e){
            throw new Exception("Failed to input");
        }
    }
    public Kecamatan update(Kecamatan kecamatan, Long id) throws Exception{
        try {
            Optional<Kecamatan> find = kecamatanRepo.findById(id);
            find.get().setNamaKecamatan(kecamatan.getNamaKecamatan());
            return kecamatanRepo.save(find.get());
        }catch (Exception e){
            throw new Exception("Failed to update");
        }
    }
    public void delete(Long id) throws Exception{
        try {
            kecamatanRepo.deleteById(id);
        }catch (Exception e){
            throw new Exception("Id not found");
        }
    }
}
