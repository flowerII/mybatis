package cn.qianshu.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianshu.mybatis.dao.CountryMapper;
import cn.qianshu.mybatis.dao.LibrarianMapper;
import cn.qianshu.mybatis.entity.Librarian;
import cn.qianshu.mybatis.service.LibrarianService;

@Service
public class LibrarianServiceImpl implements LibrarianService{
    
    @Autowired
    private LibrarianMapper librarianMapper;
    
    @Autowired
    private CountryMapper countryMapper;

    public List<Librarian> findAll() {
        return countryMapper.findAll();
    }
    
    @Override
    public Librarian selectLibrarian(int id) {
        // TODO Auto-generated method stub
        return librarianMapper.selectLibrarian(id);
    }
}
