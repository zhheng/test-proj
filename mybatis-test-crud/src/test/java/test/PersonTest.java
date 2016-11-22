package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.example.domain.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/17.
 */
public class PersonTest {

    private SqlSessionFactory build;
    private String ns = "org.mybatis.example.domain.PersonMapper.";

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        build = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test001(){
        SqlSession session = build.openSession();
        Person p = session.selectOne(ns + "selectPerson", 1);
        System.out.println(p);
    }

    @Test
    public void test002() {
        Person p = new Person(0, "王五5", "admin", "admin@admin.com", 22);
        SqlSession session = build.openSession();
        session.insert(ns + "insertPerson", p);
        session.commit();
    }

    @Test
    public void test003(){
        SqlSession session = build.openSession();
        Person p = new Person(5, "赵六", "admin", "admin@admin.com", 22);
        int update = session.update(ns + "updatePeson", p);
        session.commit();
        System.out.println(update);
    }

    @Test
    public void test004(){
        SqlSession session = build.openSession();
        int delete = session.delete(ns + "deletePerson", 6);
        session.commit();
        System.out.println(delete);
    }

    @Test
    public void test005(){
        SqlSession session = build.openSession();
        Person p = new Person(6, "赵六", "admin", "admin@admin.com", 22);
        int delete = session.delete(ns + "deletePerson", p);
        session.commit();
        System.out.println(delete);
    }

    @Test
    public void test006(){
        SqlSession session = build.openSession();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("id", 6);
        int delete = session.delete(ns + "deletePerson", map);
        session.commit();
        System.out.println(delete);
    }

    @Test
    public void test007(){
        SqlSession session = build.openSession();
        List<Person> personList = new ArrayList<Person>();
        Person p = new Person(0,"周齐2", "pass", "zhouqi@qq.com", 33);
        personList.add(p);
        p = new Person(11,"吴用2", "ppss", "wuyong@qq.com", 32);
        personList.add(p);
        Map<String, List<Person>> map = new HashMap<String, List<Person>>();
        map.put("personList", personList);
        int insert = session.insert(ns + "insertPersonList", map);
        session.commit();
        System.out.println(insert);
    }

    @Test
    public void test008(){
        SqlSession session = build.openSession();
        Person p = new Person(0, "哈哈", null, null, 11);
        int insert = session.insert(ns + "insertPerson", p);
        session.commit();
        System.out.println(insert);

        Person person = session.selectOne(ns + "selectPerson", 21);
        System.out.println(person);
    }
}
