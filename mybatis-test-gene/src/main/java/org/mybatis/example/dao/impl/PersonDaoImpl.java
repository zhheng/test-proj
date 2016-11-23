package org.mybatis.example.dao.impl;

import org.mybatis.example.dao.PersonDao;
import org.mybatis.example.domain.Person;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Created by Administrator on 2016/11/23.
 */
public class PersonDaoImpl extends SqlSessionDaoSupport implements PersonDao {
    String ns = "org.mybatis.example.dao.PersonMapper.";
    public int deleteByPrimaryKey(Integer id) {
        return this.getSqlSession().delete(ns + "deleteByPrimaryKey", id);
    }

    public int insert(Person record) {
        return this.getSqlSession().insert(ns + "insert", record);
    }

    public int insertSelective(Person record) {
        return this.getSqlSession().insert(ns + "insertSelective", record);
    }

    public Person selectByPrimaryKey(Integer id) {
        return this.getSqlSession().selectOne(ns + "selectByPrimaryKey", id);
    }

    public int updateByPrimaryKeySelective(Person record) {
        return this.getSqlSession().update(ns + "updateByPrimaryKeySelective", record);
    }

    public int updateByPrimaryKey(Person record) {
        return this.getSqlSession().update(ns + "updateByPrimaryKey", record);
    }
}
