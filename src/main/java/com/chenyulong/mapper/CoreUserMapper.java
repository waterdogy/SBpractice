package com.chenyulong.mapper;

import com.chenyulong.entity.CoreUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CoreUserMapper {
    @Select("select u.* from core_user u where u.ID = #{id}")
    public CoreUser queryById(long id);

    @Select("select * from core_user")
    public List<CoreUser> queryAll();

    @Insert("insert into core_user(code, name) values(#{code}, #{name})")
    public int save(CoreUser coreUser);

    @Delete("delete from core_user where code = #{code}")
    public int deleteByCode(String code);
}
