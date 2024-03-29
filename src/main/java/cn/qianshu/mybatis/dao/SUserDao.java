package cn.qianshu.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.qianshu.mybatis.entity.SUser;

@Mapper
public interface SUserDao {

	/** 
     * 根据用户名获取用户 
     *  
     * @param name 
     * @return 
     */
	@Select(value = " SELECT su.* FROM s_user su WHERE su.name = #{name} ")  
    public SUser findSUserByName(String name);
}
