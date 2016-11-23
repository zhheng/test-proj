package org.mybatis.example.dao.impl;

import org.mybatis.example.dao.PersonDao;
import org.mybatis.example.domain.Person;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/11/23.
 */
public class PersonDao2Impl implements PersonDao {
    String ns = "org.mybatis.example.dao.PersonMapper.";

    @Autowired
    private SqlSessionTemplate session;

    public int deleteByPrimaryKey(Integer id) {
        return session.delete(ns + "deleteByPrimaryKey", id);
    }

    public int insert(Person record) {
        return session.insert(ns + "insert", record);
    }

    public int insertSelective(Person record) {
        return session.insert(ns + "insertSelective", record);
    }

    public Person selectByPrimaryKey(Integer id) {
        return session.selectOne(ns + "selectByPrimaryKey", id);
    }

    public int updateByPrimaryKeySelective(Person record) {
        return session.update(ns + "updateByPrimaryKeySelective", record);
    }

    public int updateByPrimaryKey(Person record) {
        return session.update(ns + "updateByPrimaryKey", record);
    }
}
