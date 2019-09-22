package cn.qianshu.mybatis.dao;


import org.apache.ibatis.annotations.Mapper;

import cn.qianshu.mybatis.entity.Librarian;

@Mapper
public interface LibrarianMapper {
    Librarian selectLibrarian(int id);
}
