package com.asteroid.controller.attention;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.asteroid.model.Attention;
import com.asteroid.model.TagAdd;
import com.asteroid.util.QueryResult;

public class AttentionDaoImplTest {

  private AttentionDao dao = new AttentionDao();
  @Test
  public void testSave() {
    Attention atte=new Attention(1,1);
    dao.save(atte);
  }


  @Test
  public void testDelete() {
    testSave();
    dao.delete(1,1);
    
  }
  
  @Test
  public void testSave10() {
    for (int i = 1; i <= 5; i++) {
      Attention atte=new Attention(i,i+1);
      dao.save(atte);
      }
    for (int i = 1; i <= 5; i++) {
      Attention att=new Attention(i+1,i);
      dao.save(att); 
  }
    
  }

  @Test
  public void testFindById() {
 List< Attention> list=dao.findByUserId(3);
    
    for( Attention atte:list){
      System.out.println(atte);
    }
  }

  @Test
  public void testFindAll1() {
    QueryResult qr=dao.findAll(3,10);
    System.out.println("总记录数：" + qr.getCount());
    for(Attention tag:(List<Attention>)qr.getList()){
      System.out.println(tag);
      
    }

  }
  
  @Test
  public void testFindAll() {
    List<Attention> qr=dao.findAll();
      System.out.println("zong lakjdsf;l:::::::"+qr.size());
      

  }

}
