package com.asteroid.controller.release;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.asteroid.controller.tag.TagDao;
import com.asteroid.model.Tag;
import com.asteroid.model.UserRelease;
import com.asteroid.util.QueryResult;

public class UserReleaseDaoTest {
private UserReleaseDao dao = new UserReleaseDao();
  

  @Test
  public void testSave() {
    UserRelease vo=new UserRelease(1,1, "电影","同行的伙伴中有男生坚持要去看同档期的X战警和明日边缘，" +
                                      "向来对美国大片无感的我坚持来看窃3，还好我坚持了。出影院大家满是好评。",
                                      "images/tag/movie/movie1.jpg");
    dao.save(vo);
    System.out.println("success");
  }

// 
//  @Test
//  public void testUpdate() {
//    UserRelease tag=new UserRelease(1,"电影","/images/tagImg/vd.jpg");
//    dao.update(tag);
//  }
//
//  
//  @Test
//  public void testDelete() {
//    UserRelease tag=new UserRelease(2,"音乐","/images/tagImg/music.jpg");
//    dao.save(tag);
//    dao.delete(2);
//  }
//
//  @Test
//  public void testSave_5() {
//      for (int i = 1; i <= 5; i++) {
//          UserRelease tag = new UserRelease("tag"+i,"/images/tagImg/tag+"+i+".jpg");
//          dao.save(tag); 
//      }
//  }
//  
//  
//  @Test
//  public void testFindAll() {
//    List<UserRelease> list=dao.findAll();
//    
//    for(UserRelease tag:list){
//      System.out.println(tag);
//    }
//  }
//
// 
//  @Test
//  public void testFindAllIntInt() {
//    
//    QueryResult qr=dao.findAll(0,10);
//    System.out.println("总记录数：" + qr.getCount());
//    for(Tag tag:(List<Tag>)qr.getList()){
//      System.out.println(tag);
//      
//    }
//  }

}
