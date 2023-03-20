package com.enigma.challengedatapenduduk.service;

import com.enigma.challengedatapenduduk.exception.DataEmptyException;
import com.enigma.challengedatapenduduk.exception.DataIntegrationException;
import com.enigma.challengedatapenduduk.exception.FailedToRunException;
import com.enigma.challengedatapenduduk.exception.NotFoundException;
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
    public Iterable<Kecamatan> findAll(Pageable pageable){
        try {
            return kecamatanRepo.findAll(pageable);
        }catch (DataEmptyException e){
            throw new DataEmptyException("Data is empty");
        }
    }
    public Kecamatan save(Kecamatan kecamatan){
        try {
            return kecamatanRepo.save(kecamatan);
        }catch (FailedToRunException e){
            throw new FailedToRunException();
        }
    }
    public Kecamatan update(Kecamatan kecamatan, Long id){
        try {
            Optional<Kecamatan> find = kecamatanRepo.findById(id);
            find.get().setNamaKecamatan(kecamatan.getNamaKecamatan());
            return kecamatanRepo.save(find.get());
        }catch (FailedToRunException e){
            throw new FailedToRunException();
        }catch (NotFoundException e){
            throw new NotFoundException("id " + id + " not found");
        }
    }
    public void delete(Long id) {
        try {
            kecamatanRepo.deleteById(id);
        }catch (NotFoundException e){
            throw new NotFoundException("Id " + id +"not found");
        }catch (FailedToRunException e){
            throw new FailedToRunException();
        }catch (DataIntegrationException e){
            throw new DataIntegrationException();
        }
    }
}
