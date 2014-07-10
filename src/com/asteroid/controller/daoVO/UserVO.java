/**
 * 文件创建时间：2014年6月21日
 */
package com.asteroid.controller.daoVO;

import com.asteroid.controller.attention.AttentionDao;
import com.asteroid.controller.praise.AddPraiseDao;
import com.asteroid.model.User;
import com.asteroid.util.SessionManage;

/**
 * @author 吴泽标
 *
 */
public class UserVO {
  
  
  private User user;
  
  public UserVO(){
    this.user=SessionManage.getUser();
  }
  
  public boolean isAttention(int a_userid){
    AttentionDao dao=new AttentionDao();
    return dao.findById(this.user.getUser_id(),a_userid);
  }
  
  public boolean isPraise(int releae_id){
    AddPraiseDao dao=new AddPraiseDao();
    return dao.findById(this.user.getUser_id(),releae_id);
  }
  
  public void setList(){
    
  }
  
  
  
  
  
  public String toString() {

    return this.user.toString(); 
  }
  public int getUser_id() {
    return user.getUser_id();
  }
  public String getUsername() {
    return user.getUsername();
  }
  public String getName() {
    return user.getName();
  }
  public String getImage() {
    return user.getImage();
  }

  

}