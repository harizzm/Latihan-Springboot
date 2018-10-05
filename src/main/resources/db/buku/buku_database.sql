/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Aktivisual
 * Created: Oct 5, 2018
 */

create table buku(
    id varchar(255) not null primary key,
    kode varchar(50) not null unique,
    judul varchar(100) not null,
    NamaPengarang varchar(50) not null,
    TahunTerbit int not null default 0,
    harga decimal not null default 0,
    qty int not null default 0
)engine = Innodb;

insert into buku(id, kode, judul, NamaPengarang, TahunTerbit, harga, qty) values
    ('produk-001', 'produk-001', 'One Piece', 'Eiichiro Oda', 1997, 20000, 5),
    ('produk-002', 'produk-002', 'Sherlock Holmes', 'Arthur Conan Doyle', 1887, 50000, 7),
    ('produk-003', 'produk-003', 'Harry Potter and the Goblet of Fire', 'J.K. Rowling', 2007, 150000, 3),
    ('produk-004', 'produk-004', 'Harry Potter and the Deathly Hallows', 'J.K. Rowling', 2000, 130000, 4);
    