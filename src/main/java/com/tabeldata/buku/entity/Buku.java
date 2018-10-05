/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.buku.entity;

import com.sun.tracing.dtrace.ArgsAttributes;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Aktivisual
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Buku {
    
    private String id;
    private String kode;
    private String judul;
    private String namapengarang;
    private int tahunterbit;
    private BigDecimal harga;
    private int qty;
}
