/**
 * 
 * 文件创建时间：2014年6月21日
 */
package com.asteroid.action;

import java.util.List;

import com.asteroid.controller.attention.AttentionDao;
import com.asteroid.model.Attention;
import com.asteroid.model.User;
import com.asteroid.service.ReleaseService;
import com.asteroid.service.UserService;
import com.asteroid.util.SessionManage;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 吴泽标
 *
 */
public class AttentionAction extends ActionSupport  {
  
  private int user_id;
  
  private int a_userid;
  
  public String addAttention(){
    
    this.setUser_id(SessionManage.getUserid());
    
    AttentionDao dao=new AttentionDao();
    
    Attention vo = new Attention(getUser_id(),getA_userid());
    
   if( dao.findById(getUser_id(),getA_userid())){
     addActionError("已关注过！");
     return ERROR;
   }
    
    if (dao.save(vo)){
      addActionError("关注成功");
      upadeUserList();
      return SUCCESS;
    }
     
    else{
      addActionError("关注失败");
      return ERROR;
    }
     
  }
  
  public String delAttention(){
    
    this.setUser_id(SessionManage.getUserid());
    
    AttentionDao dao=new AttentionDao();

    if (dao.delete(getUser_id(), getA_userid())){
      addActionError("取消关注");
      upadeUserList();
    
      return SUCCESS;
    }else{
      return ERROR;
    }
      
  }
  
  private void upadeUserList(){
    ReleaseService service=new ReleaseService();
    List<User> userList=service.getAttentionUserList(SessionManage.getUserid());
    SessionManage.getSession().setAttribute("userList", userList);
  }

 
  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public int getA_userid() {
    return a_userid;
  }

  public void setA_userid(int a_userid) {
    this.a_userid = a_userid;
  }

}
