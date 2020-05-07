package com.chenyulong.service;

import com.chenyulong.entity.CoreUser;
import com.chenyulong.mapper.CoreUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoreUserService {
    @Autowired
    private CoreUserMapper coreUserMapper;

    @Transactional
    public CoreUser queryById(long id){
        return coreUserMapper.queryById(id);
    }

    @Transactional
    public List<CoreUser> queryAll(){
        return coreUserMapper.queryAll();
    }

    @Transactional
    public int insertUser(CoreUser coreUser){
//        int i = 0;
//        try {
//            i = coreUserMapper.save(coreUser);
//        }catch (DuplicateKeyException e){
//            e.printStackTrace();
//        }
        return coreUserMapper.save(coreUser);
    }

    @Transactional
    public int deleteByCode(String code) {
        return coreUserMapper.deleteByCode(code);
    }

}
