package com.asteroid.controller.letter;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.asteroid.controller.letter.PrivateLetterDao;
import com.asteroid.model.PrivateLetter;

public class PrivateLetterDaoTest {

  PrivateLetterDao comDao=new PrivateLetterDao();

  @Test
  public void testSave() {
    PrivateLetter obj=new PrivateLetter(1,1,1,"nihao");
    comDao.save(obj);
  
  }

  @Test
  public void testUpdate() {
    PrivateLetter obj=new PrivateLetter(1,2,1,"你好吗");
    obj.setLetter_id(1);
    comDao.update(obj);
  }

  @Test
  public void testDelete() {
    comDao.delete(2);
  }
  
  @Test
  public void testSave10() {
   for(int i=0;i<10;i++){
     PrivateLetter comment=new PrivateLetter(i-1, i,i+1,"你好"+i);
     comDao.save(comment);
   }
    
  
  }

  @Test
  public void testFindAll() {
    List<PrivateLetter> list=comDao.findAll();
    System.out.println("findAll :");
    for(PrivateLetter obj:list){
    
      System.out.println(obj);
    }
    
  }
  
  @Test
  public void testFindAll1() {
    List<PrivateLetter> list=comDao.find("to_userid", 5);
    System.out.println("testFind :");
    for(PrivateLetter obj:list){
      
      System.out.println(obj);
    }
    
  }


}
