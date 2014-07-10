/**
 * 文件创建时间：2014年6月12日
 */
package com.asteroid.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.asteroid.controller.attention.AttentionDao;
import com.asteroid.controller.daoVO.ReleaseVO;
import com.asteroid.controller.praise.AddPraiseDao;
import com.asteroid.controller.release.UserReleaseDao;
import com.asteroid.controller.tag.TagDao;
import com.asteroid.controller.user.UserDao;
import com.asteroid.model.AddPraise;
import com.asteroid.model.Attention;
import com.asteroid.model.User;
import com.asteroid.model.UserRelease;

/**
 * @author 吴泽标
 *
 */
public class ReleaseService {
  
  UserReleaseDao dao=new UserReleaseDao();
  TagDao daoTag=new TagDao();
  AttentionDao daoAtt=new AttentionDao(); 
  AddPraiseDao daoPra=new AddPraiseDao(); 
  UserDao daoUser=new UserDao();
  
  
  /**根据标签id获取发布内容列表
   */
  public List<ReleaseVO> getReleaseListByTagId(Integer tag_id){
    List<ReleaseVO> list=new ArrayList();
    
    List<UserRelease> urList=dao.findByTagId(tag_id);
    
    for (UserRelease ur : urList) {
      ReleaseVO vo = new ReleaseVO();
      vo.setUserRelease(ur);
      list.add(vo);
    }
    return list;
  }
  /**根据用户id获取发布内容列表
   */
  public List<ReleaseVO> getReleaseListByUserId(Integer user_id){
    List<ReleaseVO> list=new ArrayList();
    
    List<UserRelease> urList=dao.findByUserId(user_id);
    
    for (UserRelease ur : urList) {
      ReleaseVO vo = new ReleaseVO();
      vo.setUserRelease(ur);
      list.add(vo);
    }
    return list;
  }
  
  /**根据用户id获取发布内容列表
   */
  public List<ReleaseVO> getReleaseListByReleaseId(Integer release_id) {
    List<ReleaseVO> list = new ArrayList();
    UserRelease ur = dao.findById(release_id);
    ReleaseVO vo = new ReleaseVO();
    vo.setUserRelease(ur);
    list.add(vo);
    return list;
  }
  
  /**根据用户id获取关注人发布内容列表
   */
  public List<ReleaseVO> getReleaseListByAddUserId(Integer user_id) {
    List<ReleaseVO> list=new ArrayList();
    
    List<Attention> aList=daoAtt.findByUserId(user_id);
    
    for (Attention attention : aList) {
      List<UserRelease> urList = dao.findByUserId(attention.getA_userid());
      for (UserRelease ur : urList) {
        ReleaseVO vo = new ReleaseVO();
        vo.setUserRelease(ur);
        list.add(vo);
      }

    }
    Collections.sort(list);  
    return list;
  }
  
  
  /**根据用户id获取关注人发布内容列表
   */
  public List<ReleaseVO> getReleaseListByAddUserIdKey(Integer user_id) {
    List<ReleaseVO> list=new ArrayList();
    
   
      List<UserRelease> urList = dao.findByUserIdKey(user_id);
      for (UserRelease ur : urList) {
        ReleaseVO vo = new ReleaseVO();
        vo.setUserRelease(ur);
        list.add(vo);
      }

    return list;
  }
  
  
  
  
  public List<ReleaseVO> getReleaseListByLoveUserId(Integer user_love_id) {
    List<ReleaseVO> list=new ArrayList();
    
    List<AddPraise> aList=daoPra.findByUserId(user_love_id);
    
    for (AddPraise praise : aList) {
      UserRelease ur = dao.findById(praise.getRelease_id());
      if(ur!=null){
      ReleaseVO vo = new ReleaseVO();
      vo.setUserRelease(ur);
      list.add(vo);
      }
    }
    return list;
  }
  public List<ReleaseVO> getReleaseListByKey(String key) {
    List<ReleaseVO> list=new ArrayList();
    
    List<UserRelease> urList=dao.findByHql(key);
    
    for (UserRelease ur : urList) {
      ReleaseVO vo = new ReleaseVO();
      vo.setUserRelease(ur);
      list.add(vo);
    }
    return list;
  }
  /**
   * 获取关注人用户信息列表
   * @param user_id
   * @return
   */
  public List<User> getAttentionUserList(int user_id) {
    List<User> list = new ArrayList();
    
    List<Attention> attList = daoAtt.findByUserId(user_id);

    for (Attention att : attList){

      User vo = daoUser.findById(att.getA_userid());
      list.add(vo);
    }
    
    return list;
  }
  

}
