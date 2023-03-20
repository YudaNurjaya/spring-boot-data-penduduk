package com.enigma.challengedatapenduduk.service;

import com.enigma.challengedatapenduduk.model.Penduduk;
import com.enigma.challengedatapenduduk.repository.PendudukRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PendudukService {
    @Autowired
    PendudukRepo pendudukRepo;
    public Iterable<Penduduk> findAll(Pageable pageable)throws Exception{
        try {
            return pendudukRepo.findAll();
        }catch (Exception e){
            throw new Exception("Data is empty");
        }
    }
    public Penduduk save(Penduduk penduduk) throws Exception{
        try {
            return pendudukRepo.save(penduduk);
        }catch (Exception e){
            throw new Exception("Failed to input");
        }
    }
    public Penduduk update(Penduduk penduduk, Long id) throws Exception{
        try {
            Optional<Penduduk> find = pendudukRepo.findById(id);
            find.get().setNama(penduduk.getNama());
            find.get().setAlamat(penduduk.getAlamat());
            find.get().setKelurahan(penduduk.getKelurahan());
            return pendudukRepo.save(find.get());
        }catch (Exception e){
            throw new Exception("Failed to update");
        }
    }
    public void delete(Long id) throws Exception{
        try {
            pendudukRepo.deleteById(id);
        }catch (Exception e){
            throw new Exception("Id not found");
        }
    }
    public List<Penduduk> findByName(String name) throws Exception{
        try {
            List<Penduduk> find = pendudukRepo.findByNamaContains(name);
            return find;
        }catch (Exception e){
            throw new Exception("Name not found");
        }
    }
    public Optional<Penduduk> findById(Long id) throws Exception{
        try {
            Optional<Penduduk> find = pendudukRepo.findById(id);
            return find;
        }catch (Exception e){
            throw new Exception("Id not found");
        }
    }
}
