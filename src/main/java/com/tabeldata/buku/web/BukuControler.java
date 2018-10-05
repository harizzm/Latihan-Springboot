/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.buku.web;

import com.tabeldata.buku.dao.BukuDao;
import com.tabeldata.buku.entity.Buku;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aktivisual
 */
@RestController
@RequestMapping("api/buku")
public class BukuControler {
    @Autowired
    private BukuDao dao;
    
    @GetMapping("/{kode}/findById")
    public ResponseEntity<Buku> findById(@PathVariable("kode") String id){
        try{
            Buku buku = dao.findById(id);
            return ResponseEntity.ok(buku);
        }catch(EmptyResultDataAccessException erdae){
            return ResponseEntity.noContent().build();
        }
    }
    
    @GetMapping("/list")
    public List<Buku> findAll(){
        return dao.findAll();
        
    }
    
    @PostMapping("/save")
    public ResponseEntity<Buku> save(@RequestBody Buku buku){
        buku = this.dao.save(buku);
        return ResponseEntity.ok(buku);
        
    }
    
    @PutMapping("/update")
    public ResponseEntity<Buku> update(@RequestBody Buku buku){
        buku = this.dao.save(buku);
        return ResponseEntity.ok(buku);
    }
    
    @DeleteMapping("/{kode}")
    public ResponseEntity<Buku> delete(@PathVariable("kode") String id){
        this.dao.delete(id);
        return ResponseEntity.ok().build();
    }
}
