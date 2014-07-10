/**
 * 文件创建时间：2014年6月23日
 */
package com.asteroid.action;

import com.asteroid.controller.letter.PrivateLetterDao;
import com.asteroid.model.PrivateLetter;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 吴泽标
 *
 */
public class LetterAction extends ActionSupport{
  
  private int user_id;
  private String content;
  private PrivateLetterDao dao=new PrivateLetterDao();
  
  public String execute(){
    if(content==null||content.equals("")) {
      addActionError("没信息哦~写几句吧~");
      return SUCCESS;
    }
    PrivateLetter pl=new PrivateLetter(getUser_id(), 0, getContent());
    dao.save(pl);
    addActionError("您的信息已收到，感谢您对Aseroid的支持~");
    return SUCCESS;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
