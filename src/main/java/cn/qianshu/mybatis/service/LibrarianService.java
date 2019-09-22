package cn.qianshu.mybatis.service;

import java.util.List;

import cn.qianshu.mybatis.entity.Librarian;

public interface LibrarianService {
    Librarian selectLibrarian(int id);
    
   List<Librarian> findAll();
}