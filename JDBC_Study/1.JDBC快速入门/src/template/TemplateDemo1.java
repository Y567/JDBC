package template;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;

/**
 * JdbcTemplate快速入门
 */
public class TemplateDemo1 {
    public static void main(String[] args) {
        //1.导入Jar包
        //2.创建JdbcTemlate对象,需要传入一个数据库连接池对象参数
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        //3.写sql语句
        String sql = "update account set balance = ? where id = ?";
        //4.执行语句(template提供的方法可以将sql语句中的？赋值)
        int i = template.update(sql,10002,3);
        System.out.println("影响的行数："+i);
    }
}
