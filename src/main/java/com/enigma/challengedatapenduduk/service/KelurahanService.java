package com.enigma.challengedatapenduduk.service;

import com.enigma.challengedatapenduduk.model.Kelurahan;
import com.enigma.challengedatapenduduk.repository.KelurahanRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class KelurahanService {
    @Autowired
    KelurahanRepo kelurahanRepo;
    public Iterable<Kelurahan> findAll(Pageable pageable)throws Exception{
        try {
            return kelurahanRepo.findAll();
        }catch (Exception e){
            throw new Exception("Data is empty");
        }
    }
    public Kelurahan save(Kelurahan kelurahan) throws Exception{
        try {
            return kelurahanRepo.save(kelurahan);
        }catch (Exception e){
            throw new Exception("Failed to input");
        }
    }
    public Kelurahan update(Kelurahan kelurahan, Long id) throws Exception{
        try {
            Optional<Kelurahan> find = kelurahanRepo.findById(id);
            find.get().setNamaKelurahan(kelurahan.getNamaKelurahan());
            find.get().setKodePos(kelurahan.getKodePos());
            find.get().setNamaKelurahan(kelurahan.getNamaKelurahan());
            return kelurahanRepo.save(find.get());
        }catch (Exception e){
            throw new Exception("Failed to update");
        }
    }
    public void delete(Long id) throws Exception{
        try {
            kelurahanRepo.deleteById(id);
        }catch (Exception e){
            throw new Exception("Id not found");
        }
    }
}
