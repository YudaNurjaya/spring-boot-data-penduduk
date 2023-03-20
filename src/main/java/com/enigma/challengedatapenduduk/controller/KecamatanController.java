package com.enigma.challengedatapenduduk.controller;

import com.enigma.challengedatapenduduk.model.Kecamatan;
import com.enigma.challengedatapenduduk.model.request.KecamatanRequest;
import com.enigma.challengedatapenduduk.model.response.SuccessResponse;
import com.enigma.challengedatapenduduk.service.KecamatanService;
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
@RequestMapping("/kecamatan")
@Validated
public class KecamatanController {
    @Autowired
    KecamatanService kecamatanService;
    @Autowired
    ModelMapper modelMapper;
    @PostMapping("/{size}/{page}/{sort}")
    public ResponseEntity findAll(@PathVariable int size, @PathVariable int page, @PathVariable("sort") String sort){
        Pageable pageable = PageRequest.of(page-1, size, Sort.by("id").ascending());
        if(sort.equalsIgnoreCase("desc")){
            pageable = PageRequest.of(page-1, size, Sort.by("id").descending());
        }
        Iterable<Kecamatan> get = kecamatanService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Iterable<Kecamatan>>("Success",get));
    }
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody KecamatanRequest request){
        Kecamatan kecamatan = modelMapper.map(request,Kecamatan.class);
        Kecamatan insert = kecamatanService.save(kecamatan);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<Kecamatan>("Created",insert));
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @RequestBody KecamatanRequest kecamatanRequest,@RequestParam Long id){
        Kecamatan kecamatan = modelMapper.map(kecamatanRequest,Kecamatan.class);
        Kecamatan insert = kecamatanService.update(kecamatan,id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Kecamatan>("Updated",insert));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@RequestParam Long id){
        kecamatanService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Long>("Deleted",id));
    }
}
