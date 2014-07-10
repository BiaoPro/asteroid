package com.asteroid.controller.user;

import java.util.List;

import org.junit.Test;

import com.asteroid.service.UserService;
import com.asteroid.util.QueryResult;
import com.asteroid.model.User;

public class UserDaoTest {
  
  private UserDao userDao = new UserDao();

  @Test
  public void testSave() {
    User user = new User();
    user.setUsername("001");
    user.setPassword("001");
    user.setSex("男");
    
    userDao.save(user);
    
  }
  
  @Test
  public void testSave_5() {
      for (int i = 1; i <= 5; i++) {
          User user = new User();
          user.setUsername("test_" + i);
          user.setPassword("test_" + i);
          userDao.save(user); // 保存
      }
  }

  @Test
  public void testUpdate() {
    User user = userDao.findById(10);
    System.out.println("修改前："+user);
    user.setSex("男");
    userDao.update(user);
    user = userDao.findById(10);
    System.out.println("修改后："+user);
  }

  @Test
  public void testDelete() {
    System.out.println("删除id 2："+userDao.delete(2)); 
  }

  @Test
  public void testFindById() {
    User user = userDao.findById(1);
    System.out.println(user);
  }
  
  @Test
  public void testFind() {
    String username="001";
    String password="001";
    System.out.println("testFind username  \n"+userDao.check("0001"));
    System.out.println("testFind username password \n"+userDao.check("001","001"));
    UserService service=new UserService();
   System.out.println("service:"+service.authenticate(username, password));
  }

  @Test
  public void testFindAll() {
    List<User> list = userDao.findAll();
    System.out.println("findAll");
    for (User user : list) {
        System.out.println(user);
    }
   
  
  }

  @Test
  public void testFindAllIntInt() {
      // 查询
      // QueryResult qr = userDao.findAll(0, 10); // 第1页，每页10条
      // QueryResult qr = userDao.findAll(10, 10); // 第2页，每页10条
      QueryResult qr = userDao.findAll(2, 10); // 第3页，每页10条

      // 显示结果
      System.out.println("总记录数：" + qr.getCount());
      for (User user : (List<User>) qr.getList()) {
          System.out.println(user);
      }
  }

}
