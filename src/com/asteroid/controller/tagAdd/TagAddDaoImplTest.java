package com.asteroid.controller.tagAdd;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.asteroid.model.Tag;
import com.asteroid.model.TagAdd;
import com.asteroid.util.HibernateUtils;
import com.asteroid.util.QueryResult;

public class TagAddDaoImplTest {
  private TagAddDao tagDao = new TagAddDao();
  @Test
  public void testSave() {
    TagAdd tagAdd=new TagAdd(1,1);
    tagDao.save(tagAdd);
  }


  @Test
  public void testDelete() {
    testSave();
    tagDao.delete(1,1);
    
  }
  
  @Test
  public void testSave10() {
    for (int i = 1; i <= 5; i++) {
      TagAdd tag = new TagAdd(i,i+1);
      tagDao.save(tag); 
  }
    for (int i = 1; i <= 5; i++) {
      TagAdd tag = new TagAdd(i+1,i);
      tagDao.save(tag); 
  }
    
  }

  @Test
  public void testFindById() {
 List<TagAdd> list=tagDao.findAllById(3);
    
    for(TagAdd tag:list){
      System.out.println(tag);
    }
  }

  @Test
  public void testFindAll() {
    QueryResult qr=tagDao.findAll(3,10);
    System.out.println("总记录数：" + qr.getCount());
    for(TagAdd tag:(List<TagAdd>)qr.getList()){
      System.out.println(tag);
      
    }

  }
}
