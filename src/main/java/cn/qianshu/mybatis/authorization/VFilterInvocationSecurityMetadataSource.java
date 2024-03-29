package cn.qianshu.mybatis.authorization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import cn.qianshu.mybatis.entity.SPermission;
import cn.qianshu.mybatis.entity.SRole;
import cn.qianshu.mybatis.service.SecurityDataService;

@Component  
public class VFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {  
    Gson gson = new Gson();  
    Logger logger = LoggerFactory.getLogger(this.getClass());  
    @Autowired  
    SecurityDataService securityDataService;  
      
    @Override  
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {  
        //获取请求起源路径  
        String requestUrl = ((FilterInvocation) object).getRequestUrl();  
        logger.info("VFilterInvocationSecurityMetadataSource getAttributes(获取请求资源路径) [requestUrl={}]", requestUrl);  
        //登录页面就不需要权限  
        if ("/login".equals(requestUrl)) {  
            return null;  
        }  
        //用来存储访问路径需要的角色或权限信息  
        List<String> tempPermissionList = new ArrayList<String>();  
        //获取角色列表  
        List<SRole> sRoleList = securityDataService.findSRoleListBySPermissionUrl(requestUrl);  
        logger.info("VFilterInvocationSecurityMetadataSource getAttributes(请求资源路径需要角色) [sRoleList={}]", gson.toJson(sRoleList));  
        for(SRole sRole : sRoleList) {  
            tempPermissionList.add(sRole.getRole());  
        }  
        //径获取资源权限列表  
        List<SPermission> sPermissionList = securityDataService.findSPermissionListBySPermissionUrl(requestUrl);  
        logger.info("VFilterInvocationSecurityMetadataSource getAttributes(请求资源路径所需权限) [sPermissionList={}]", gson.toJson(sPermissionList));  
        for(SPermission sPermission : sPermissionList) {  
            tempPermissionList.add(sPermission.getPermission());  
        }  
        //如果没有权限控制的url，可以设置都可以访问，也可以设置默认不许访问  
        if(tempPermissionList.isEmpty()) {  
            return null;//都可以访问  
            //tempPermissionList.add("DEFAULT_FORBIDDEN");//默认禁止  
        }  
        String[] permissionArray = tempPermissionList.toArray(new String[0]);  
        logger.info("VFilterInvocationSecurityMetadataSource getAttributes(请求资源路径所需权限、角色集合) [permissionArray={}]", gson.toJson(permissionArray));  
        return SecurityConfig.createList(permissionArray);  
    }  
  
    @Override  
    public Collection<ConfigAttribute> getAllConfigAttributes() {  
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    @Override  
    public boolean supports(Class<?> clazz) {  
        return true;  
    }  
  
}
