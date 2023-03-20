package com.enigma.challengedatapenduduk.service;

import com.enigma.challengedatapenduduk.exception.*;
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
    public Iterable<Penduduk> findAll(Pageable pageable){
        try {
            return pendudukRepo.findAll(pageable);
        }catch (DataEmptyException e){
            throw new DataEmptyException();
        }
    }
    public Penduduk save(Penduduk penduduk){
        try {
            return pendudukRepo.save(penduduk);
        }catch (FailedToRunException e){
            throw new FailedToRunException();
        }
    }
    public Penduduk update(Penduduk penduduk, Long id){
        try {
            Optional<Penduduk> find = pendudukRepo.findById(id);
            Optional<Penduduk> nik = pendudukRepo.findByNikEquals(penduduk.getNik());
            if(nik.isPresent()){
                throw new DuplicateException("Nik " + find.get().getNik() + " is already exist");
            }
            find.get().setNik(penduduk.getNik());
            find.get().setNama(penduduk.getNama());
            find.get().setAlamat(penduduk.getAlamat());
            find.get().setKelurahan(penduduk.getKelurahan());

            return pendudukRepo.save(find.get());
        }catch (FailedToRunException e){
            throw new FailedToRunException();
        }catch (NotFoundException e) {
            throw new NotFoundException("Id " + id + " not found");
        }
    }
    public void delete(Long id){
        try {
            pendudukRepo.deleteById(id);
        }catch (NotFoundException e){
            throw new NotFoundException("Id " + id + " not found");
        }catch (FailedToRunException e){
            throw new FailedToRunException();
        }catch (DataIntegrationException e){
            throw new DataIntegrationException();
        }
    }
    public List<Penduduk> findByName(String name){
        try {
            List<Penduduk> find = pendudukRepo.findByNamaContains(name);
            return find;
        }catch (NotFoundException e){
            throw new NotFoundException("Penduduk " + name + " not found");
        }
    }
    public Optional<Penduduk> findById(Long id){
        try {
            Optional<Penduduk> find = pendudukRepo.findById(id);
            return find;
        }catch (NotFoundException e){
            throw new NotFoundException("Id " + id + " not Found");
        }
    }
    public Optional<Penduduk> findByNik(String nik){
        try {
            Optional<Penduduk> find = pendudukRepo.findByNikEquals(nik);
            return find;
        }catch (NotFoundException e){
            throw new NotFoundException("Nik " + nik + " not found");
        }
    }
}
