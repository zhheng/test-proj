import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.example.domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/22.
 */
public class Tester
{
    private SqlSessionFactory sessionFactory;
    private String ns = "org.mybatis.example.domain.PersonMapper.";
    @Before
    public void init(){
        sessionFactory = new SqlSessionFactoryBuilder().build(Tester.class.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void testIf(){
        SqlSession session = sessionFactory.openSession();
        Person p = new Person();
        p.setUsername("");
        List<Object> list = session.selectList(ns + "findPersonWithNameLike", p);
        Assert.assertNotNull(list);

        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void testIf2(){
        SqlSession session = sessionFactory.openSession();
        Person p = new Person();
//        p.setUsername();
//        p.setPassword(");
        session.selectList(ns + "findPersonLike", p);

    }

    @Test
    public void testIf3(){
        SqlSession session = sessionFactory.openSession();
        Person p = new Person();
        p.setAge(10);
//        p.setUsername("");
        List<Object> objects = session.selectList(ns + "findPersonLike2", p);
    }

    @Test
    public void testTrim(){
        SqlSession session = sessionFactory.openSession();
        Person p = new Person();
        p.setAge(1);
        p.setUsername("a");
        p.setPassword("b");

        List<Object> objects = session.selectList(ns + "findPersonLike3", p);
    }

    @Test
    public void testUpdate(){
        SqlSession session = sessionFactory.openSession();
        Person p = new Person();
        p.setId(10);
        p.setUsername("a");
        p.setPassword("b");
        p.setEmail("aaa@dd.com");
        int objects = session.update(ns + "updatePersonNece", p);
        session.commit();
        System.out.println(objects);
    }

    @Test
    public void testUpdate2(){
        SqlSession session = sessionFactory.openSession();
        Person p = new Person();
        p.setId(11);
        p.setUsername("a");
        p.setPassword("b");
        p.setEmail("aaa@dd.com");
        int objects = session.update(ns + "updatePersonNece2", p);
        session.commit();
        System.out.println(objects);
    }

    @Test
    public void testForEach() {
        SqlSession session = sessionFactory.openSession();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(10);
        list2.add(12);
        list2.add(13);
        list2.add(14);
        list2.add(15);
        list2.add(16);

        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        map.put("list", list);
        map.put("list2", list2);

        List<Object> list1 = session.selectList(ns + "selectListByIds", map);
        for (Object o : list1) {
            System.out.println(o);
        }
    }

    @Test
    public void testBind(){
        SqlSession session = sessionFactory.openSession();
        Person p = new Person();
        p.setUsername("张");
        List<Object> objects = session.selectList(ns + "selectByBind", p);
        for (Object object : objects) {
            System.out.println(object);
        }
        System.out.println(p);
    }
}
