package com.asteroid.controller.comment;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.asteroid.model.Comment;

public class CommentDaoTest {
  CommentDao comDao=new CommentDao();

  @Test
  public void testSave() {
    Comment com=new Comment(1,1,1,"你好");
    comDao.save(com);
  
  }

  @Test
  public void testUpdate() {
    Comment com=new Comment(1,2,1,"你好吗");
    com.setComment_id(1);
    comDao.update(com);
  }

  @Test
  public void testDelete() {
    comDao.delete(2);
  }
  
  @Test
  public void testSave10() {
   for(int i=0;i<10;i++){
     Comment comment=new Comment(i-1, i,i+1,"你好"+i);
     comDao.save(comment);
   }
    
  
  }

  @Test
  public void testFindAll() {
    List<Comment> list=comDao.findAll();
    System.out.println("findAll :");
    for(Comment com:list){
    
      System.out.println(com);
    }
    
  }
  
  @Test
  public void testFindAll1() {
    List<Comment> list=comDao.find("to_userid", 5);
    System.out.println("testFind :");
    for(Comment com:list){
      
      System.out.println(com);
    }
    
  }

}
