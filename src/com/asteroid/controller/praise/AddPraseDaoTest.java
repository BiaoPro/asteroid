package com.asteroid.controller.praise;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.asteroid.controller.praise.AddPraiseDao;
import com.asteroid.model.AddPraise;

public class AddPraseDaoTest {

  AddPraiseDao comDao=new AddPraiseDao();

  @Test
  public void testSave() {
    AddPraise obj=new AddPraise(1,1,1);
    comDao.save(obj);
  
  }

  @Test
  public void testUpdate() {
    AddPraise obj=new AddPraise(3,2,3);
    obj.setPraise_id(2);
    comDao.update(obj);
  }

  @Test
  public void testDelete() {
    comDao.delete(2);
  }
  
  @Test
  public void testSave10() {
   for(int i=0;i<10;i++){
     AddPraise comment=new AddPraise(i-1, i,i+1);
     comDao.save(comment);
   }
    
  
  }

  @Test
  public void testFindAll() {
    List<AddPraise> list=comDao.findAll();
    System.out.println("findAll :");
    for(AddPraise obj:list){
    
      System.out.println(obj);
    }
    
  }
  
  @Test
  public void testFindAll1() {
    List<AddPraise> list=comDao.find("user_id", 5);
    System.out.println("testFind :");
    for(AddPraise obj:list){
      
      System.out.println(obj);
    }
    
  }

}
