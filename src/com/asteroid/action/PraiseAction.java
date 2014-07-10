/**
 * 
 * 文件创建时间：2014年6月21日
 */
package com.asteroid.action;

import com.asteroid.controller.praise.AddPraiseDao;
import com.asteroid.model.AddPraise;
import com.asteroid.util.SessionManage;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 吴泽标
 *
 */
public class PraiseAction extends ActionSupport  {
  
  private int release_id;
  
  private int user_id;
  
  public String addPraise(){
    this.setUser_id(SessionManage.getUserid());
    
    AddPraiseDao dao=new AddPraiseDao();
    
    AddPraise vo = new AddPraise(getUser_id(),getRelease_id());
    
    dao.save(vo);
    
    return SUCCESS;
  }
  
  public String delPraise(){
 this.setUser_id(SessionManage.getUserid());
    
    AddPraiseDao dao=new AddPraiseDao();

    if (dao.deleteByID2(getUser_id(), getRelease_id()))
      return SUCCESS;
    else
      return ERROR;
  }

  public int getRelease_id() {
    return release_id;
  }

  public void setRelease_id(int release_id) {
    this.release_id = release_id;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

}
