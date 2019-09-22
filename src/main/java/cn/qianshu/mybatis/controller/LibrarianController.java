package cn.qianshu.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.qianshu.mybatis.entity.Librarian;
import cn.qianshu.mybatis.service.LibrarianService;

@RestController
public class LibrarianController {
    
    @Autowired
    private LibrarianService librarianService;
    
    //@GetMapping("/getLibrarian")
    @RequestMapping(value = "/getLibrarian", method=RequestMethod.GET)
    public Librarian getALibrarianInfo(int id) {
        //System.out.println("test :id: "+id);
        return librarianService.selectLibrarian(id);
    }
    
    @RequestMapping(value = "/get", method=RequestMethod.GET)
    public List<Librarian> getAll() {
        //System.out.println("test :id: "+id);
        return librarianService.findAll();
    }
}