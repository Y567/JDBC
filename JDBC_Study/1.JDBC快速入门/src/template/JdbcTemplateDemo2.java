package template;

import information.Info;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;

import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {
    /**
     * Junit单元测试
     */
    //设置一个公共的JdbcTemplate对象
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    @Test
    public void test1(){
        //删除一条记录
        String sql = "delete from account where id=?";
        //执行语句
        int i = template.update(sql, 3);
        System.out.println(i);
    }

    /**
     *查询一条记录封装到Map集合
     */
    @Test
    public void Test2(){
        //1.写sql语句
        String sql = "select * from account where id =?";
        //2.执行语句
        Map<String, Object> stringObjectMap = template.queryForMap(sql,2);
        for (String s : stringObjectMap.keySet()) {
            System.out.println(s+":"+stringObjectMap.get(s));
        }
    }

    /**
     * 封装称List集合
     */
    @Test
    public void test3(){
        //1.写sql语句
        String sql = "select * from account where id =? or id = ?";
        List<Map<String, Object>> list = template.queryForList(sql, 1, 2);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 封装成标准类（JavaBean）
     */
    @Test
    public void test4(){
        //1.定义sql语句
        String sql = "select * from student";
        //2.执行
        List<Info> query = template.query(sql, new BeanPropertyRowMapper<>(Info.class));
        for (Info info : query) {
            System.out.println(info);
        }
    }

    /**
     * 一般用于聚合函数求值
     */
    @Test
    public void test5(){
        String sql = "select count(id) from student";
        Integer integer = template.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }
}
