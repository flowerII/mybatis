package cn.qianshu.mybatis.dao;


import java.util.List;
import org.apache.ibatis.annotations.Select;

import cn.qianshu.mybatis.entity.Librarian;

public interface CountryMapper {
    @Select("SELECT id, userName, password, age, position FROM t_librarian ")
    List<Librarian> findAll();
}
