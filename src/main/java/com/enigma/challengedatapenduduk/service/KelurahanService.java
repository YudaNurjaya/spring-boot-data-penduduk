package com.enigma.challengedatapenduduk.service;

import com.enigma.challengedatapenduduk.exception.DataEmptyException;
import com.enigma.challengedatapenduduk.exception.DataIntegrationException;
import com.enigma.challengedatapenduduk.exception.FailedToRunException;
import com.enigma.challengedatapenduduk.exception.NotFoundException;
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
    public Iterable<Kelurahan> findAll(Pageable pageable){
        try {
            return kelurahanRepo.findAll(pageable);
        }catch (DataEmptyException e){
            throw new DataEmptyException();
        }
    }
    public Kelurahan save(Kelurahan kelurahan){
        try {
            return kelurahanRepo.save(kelurahan);
        }catch (FailedToRunException e){
            throw new FailedToRunException();
        }
    }
    public Kelurahan update(Kelurahan kelurahan, Long id){
        try {
            Optional<Kelurahan> find = kelurahanRepo.findById(id);
            find.get().setNamaKelurahan(kelurahan.getNamaKelurahan());
            find.get().setKodePos(kelurahan.getKodePos());
            find.get().setNamaKelurahan(kelurahan.getNamaKelurahan());
            return kelurahanRepo.save(find.get());
        }catch (FailedToRunException e){
            throw new FailedToRunException();
        }catch (NotFoundException e){
            throw new NotFoundException("Id " + id + " not found");
        }
    }
    public void delete(Long id){
        try {
            kelurahanRepo.deleteById(id);
        }catch (NotFoundException e){
            throw new NotFoundException("Id " + id +"not found");
        }catch (FailedToRunException e){
            throw new FailedToRunException();
        }catch (DataIntegrationException e){
            throw new DataIntegrationException();
        }
    }
}
