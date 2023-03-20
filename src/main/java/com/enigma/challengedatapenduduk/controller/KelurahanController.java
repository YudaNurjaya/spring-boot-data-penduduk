package com.enigma.challengedatapenduduk.controller;

import com.enigma.challengedatapenduduk.model.Kelurahan;
import com.enigma.challengedatapenduduk.model.request.KelurahanRequest;
import com.enigma.challengedatapenduduk.model.response.SuccessResponse;
import com.enigma.challengedatapenduduk.service.KelurahanService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kelurahan")
@Validated
public class KelurahanController {
    @Autowired
    KelurahanService kelurahanService;
    @Autowired
    ModelMapper modelMapper;
    @PostMapping("/{size}/{page}/{sort}")
    public ResponseEntity findAll(@PathVariable int size,@PathVariable int page, @PathVariable("sort") String sort) throws Exception{
        Pageable pageable = PageRequest.of(page-1,size, Sort.by("id").ascending());
        if(pageable.equals("desc")){
            pageable = PageRequest.of(page-1,size, Sort.by("id").descending());
        }
        Iterable<Kelurahan> get = kelurahanService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Iterable<Kelurahan>>("Success",get));
    }
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody KelurahanRequest request) throws Exception{
        Kelurahan kelurahan = modelMapper.map(request,Kelurahan.class);
        Kelurahan insert = kelurahanService.save(kelurahan);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Kelurahan>("Created",insert));
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @RequestBody KelurahanRequest request,Long id)throws Exception{
        Kelurahan kelurahan = modelMapper.map(request,Kelurahan.class);
        Kelurahan insert = kelurahanService.update(kelurahan,id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Kelurahan>("Updated",insert));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(Long id)throws Exception{
        kelurahanService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Long>("Deleted",id));
    }
}
