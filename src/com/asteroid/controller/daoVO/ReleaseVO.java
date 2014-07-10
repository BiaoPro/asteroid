/**
 * 文件创建时间：2014年6月12日
 */
package com.asteroid.controller.daoVO;

import java.util.ArrayList;
import java.util.List;

import com.asteroid.controller.comment.CommentDao;
import com.asteroid.controller.tag.TagDao;
import com.asteroid.controller.user.UserDao;
import com.asteroid.model.Comment;
import com.asteroid.model.Tag;
import com.asteroid.model.TagAdd;
import com.asteroid.model.User;
import com.asteroid.model.UserRelease;

/**
 * @author 吴泽标
 *
 */
public class ReleaseVO implements Comparable<ReleaseVO> {
  
  private int release_id;
  
  private int user_id;
  private User user;
  private String user_name;
  private String user_img;
  
  private int tag_id;
  private String tag_name;
  
  private String title;
  private String content;
  private String image;
  private String music;
  private String video; 
  
  private List<TagAdd> tagList;
  private List<CommentVO> commentList;
  
  
  public void setUserRelease(UserRelease ur) {
    this.release_id=ur.getRelease_id();
    this.user_id=ur.getUser_id();
    CommentDao comDao=new CommentDao();
    List<Comment> comList=comDao.findByReleaseId(this.getRelease_id());
    this.setCommentList(comList);
    
    UserDao userDao=new UserDao();
    this.setUser(userDao.findById(ur.getUser_id()));
    this.tag_id=ur.getTag_id();
    TagDao dao=new TagDao();
    this.setTag(dao.findById(ur.getTag_id()));
    
    this.title=ur.getTitle();
    this.content=ur.getContent();
    this.image=ur.getImage();
    this.music=ur.getMusic();
    this.video=ur.getVideo();
    
   
   }
  
  public int compareTo(ReleaseVO o) {
    return this.getRelease_id() < o.getRelease_id() ? 1 : 0;
  }
  
  
  private void setUser(User user){
    this.user=user;
    this.user_name=user.getName();
    this.user_img=user.getImage();
    
    
  }
  public void setTag(Tag tag) {
    this.tag_name=tag.getTag_name();
    
  }
  
  public void setCommentList(Tag tag) {
    this.tag_name=tag.getTag_name();
    
  }
  public List<CommentVO> getCommentList() {
    return commentList;
  }
  public void setCommentList(List<Comment> comList) {
    this.commentList=new ArrayList<CommentVO>();
    for(Comment com:comList){
      CommentVO vo=new CommentVO(com);
      this.commentList.add(vo);
    }
    
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
  public User getUser() {
    return user;
  }
 
  public int getTag_id() {
    return tag_id;
  }
  public void setTag_id(int tag_id) {
    this.tag_id = tag_id;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }
  public String getMusic() {
    return music;
  }
  public void setMusic(String music) {
    this.music = music;
  }
  public String getVideo() {
    return video;
  }
  public void setVideo(String video) {
    this.video = video;
  }
  public List<TagAdd> getTagList() {
    return tagList;
  }
  public void setTagList(List<TagAdd> tagList) {
    this.tagList = tagList;
  }
  public String getName() {
    return getUser_name();
  }
  public void setName(String name) {
    this.setUser_name(name);
  }
  public String getUser_img() {
    return user_img;
  }
  public void setUser_img(String user_img) {
    this.user_img = user_img;
  }
  public String getTag_name() {
    return tag_name;
  }
  public void setTag_name(String tag_name) {
    this.tag_name = tag_name;
  }
  public String getUser_name() {
    return user_name;
  }
  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }


}
