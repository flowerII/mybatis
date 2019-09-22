package cn.qianshu.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianshu.mybatis.dao.SPermissionDao;
import cn.qianshu.mybatis.dao.SRoleDao;
import cn.qianshu.mybatis.dao.SUserDao;
import cn.qianshu.mybatis.entity.SPermission;
import cn.qianshu.mybatis.entity.SRole;
import cn.qianshu.mybatis.entity.SUser;

@Service  
public class SecurityDataService {  
    @Autowired  
    private SUserDao sUserDao;  
    @Autowired  
    private SRoleDao sRoleDao;  
    @Autowired  
    private SPermissionDao sPermissionDao;  
  
    public SUser findSUserByName(String name) {  
        return sUserDao.findSUserByName(name);  
    }  
  
    public List<SRole> findSRoleListBySUserId(int sUserId) {  
        return sRoleDao.findSRoleListBySUserId(sUserId);  
    }  
  
    public List<SRole> findSRoleListBySPermissionUrl(String sPermissionUrl) {  
        return sRoleDao.findSRoleListBySPermissionUrl(sPermissionUrl);  
    }  
  
    public List<SPermission> findSPermissionListBySUserId(int sUserId) {  
        return sPermissionDao.findSPermissionListBySUserId(sUserId);  
    }  
  
    public List<SPermission> findSPermissionListBySPermissionUrl(String sPermissionUrl) {  
        return sPermissionDao.findSPermissionListBySPermissionUrl(sPermissionUrl);  
    }  
}