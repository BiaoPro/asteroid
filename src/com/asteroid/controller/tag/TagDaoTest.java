/**
 * 文件创建时间：2014年6月3日
 */
package com.asteroid.controller.tag;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.asteroid.model.Tag;
import com.asteroid.model.User;
import com.asteroid.util.QueryResult;

/**
 * @author 吴泽标
 *
 */
public class TagDaoTest {

  private TagDao tagDao = new TagDao();
  
  /**
   * Test method for {@link com.TagDao.tag.TagDaoImpl#save(com.model.Tag)}.
   */
  @Test
  public void testSave() {
    Tag tag=new Tag("电影","/images/tagImg/video.jpg");
    tagDao.save(tag);
  }

  /**
   * Test method for {@link com.TagDao.tag.TagDaoImpl#update(com.model.Tag)}.
   */
  @Test
  public void testUpdate() {
    Tag tag=new Tag(1,"电影","/images/tagImg/vd.jpg");
    tagDao.update(tag);
  }



  @Test
  public void testSave_5() {
      for (int i = 1; i <= 5; i++) {
          Tag tag = new Tag("tag"+i,"/images/tagImg/tag+"+i+".jpg");
          tagDao.save(tag); 
      }
  }
  
  
  /**
   * Test method for {@link com.TagDao.tag.TagDaoImpl#findAll()}.
   */
  @Test
  public void testFindAll() {
    List<Tag> list=tagDao.findAll();
    
    for(Tag tag:list){
      System.out.println(tag);
    }
  }

  /**
   * Test method for {@link com.TagDao.tag.TagDaoImpl#findAll(int, int)}.
   */
  @Test
  public void testFindAllIntInt() {
    
    QueryResult qr=tagDao.findAll(0,10);
    System.out.println("总记录数：" + qr.getCount());
    for(Tag tag:(List<Tag>)qr.getList()){
      System.out.println(tag);
      
    }
  }

}
