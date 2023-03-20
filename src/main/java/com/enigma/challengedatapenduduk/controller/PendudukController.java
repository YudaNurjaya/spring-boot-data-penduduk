package com.enigma.challengedatapenduduk.controller;

import com.enigma.challengedatapenduduk.model.Penduduk;
import com.enigma.challengedatapenduduk.model.request.PendudukRequest;
import com.enigma.challengedatapenduduk.model.response.SuccessResponse;
import com.enigma.challengedatapenduduk.service.PendudukService;
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

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/penduduk")
@Validated
public class PendudukController {
    @Autowired
    PendudukService pendudukService;
    @Autowired
    ModelMapper modelMapper;
    @PostMapping("/{size}/{page}/{sort}")
    public ResponseEntity getAll(@PathVariable int size, @PathVariable int page, @PathVariable("sort") String sort)throws Exception{
        Pageable pageable = PageRequest.of(page,size, Sort.by("nik").ascending());
        if(sort.equals("desc")){
            pageable = PageRequest.of(page-1,size, Sort.by("nik").descending());
        }
        Iterable<Penduduk> get = pendudukService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Iterable<Penduduk>>("Success",get));
    }
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody PendudukRequest request) throws Exception{
        Penduduk penduduk = modelMapper.map(request,Penduduk.class);
        Penduduk input = pendudukService.save(penduduk);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<Penduduk>("Created",input));
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @RequestBody PendudukRequest request, Long id)throws Exception{
        Penduduk penduduk = modelMapper.map(request,Penduduk.class);
        Penduduk insert = pendudukService.update(penduduk,id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Penduduk>("Updated",insert));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(Long id)throws Exception{
        pendudukService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Long>("Deleted",id));
    }
    @GetMapping("/search")
    public ResponseEntity findBy(@RequestParam Map<String, String> searchParam) throws Exception{
        if(searchParam.containsKey("nik")){
            Optional<Penduduk> find = pendudukService.findById(Long.parseLong(searchParam.get("nik")));
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Optional<Penduduk>>("Success",find));
        }
        if(searchParam.containsKey("name")){
            List<Penduduk> find = pendudukService.findByName(searchParam.get("name"));
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<List<Penduduk>>("Success",find));
        }
        return null;
    }
}
