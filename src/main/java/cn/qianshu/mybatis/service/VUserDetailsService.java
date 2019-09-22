package cn.qianshu.mybatis.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.qianshu.mybatis.authentication.VUserDetails;
import cn.qianshu.mybatis.entity.SPermission;
import cn.qianshu.mybatis.entity.SRole;
import cn.qianshu.mybatis.entity.SUser;

@Service  
public class VUserDetailsService implements UserDetailsService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
  
    @Autowired  
    SecurityDataService securityDataService;  
    /** 
     * 根据用户输入的用户名返回数据源中用户信息的封装，返回一个UserDetails 
     */  
    @Override  
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  
        SUser sUser = securityDataService.findSUserByName(username);
        if(sUser ==null) {
        	logger.info("用户不存在！");
        }
        //用户角色列表  
        List<SRole> sRoleList = securityDataService.findSRoleListBySUserId(sUser.getId());  
        //用户资源权限列表  
        List<SPermission> sPermissionList = securityDataService.findSPermissionListBySUserId(sUser.getId());  
        return new VUserDetails(sUser, sRoleList, sPermissionList);  
    }  
  
}