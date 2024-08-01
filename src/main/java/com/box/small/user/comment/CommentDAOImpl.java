package com.box.small.user.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl implements CommentDAO{
   @Autowired
   private SqlSession sqlsession;
   private final static String nameSpace = "com.box.small.commentMapper"; 
   
   @Override
   public int commentAdd(CommentDto cDto) {
      // TODO Auto-generated method stub
      return sqlsession.insert(nameSpace+".commentAdd", cDto);
   }

   @Override
   public int commentUpdate(CommentDto cDto) {
      // TODO Auto-generated method stub
      return sqlsession.update(nameSpace+".commentUpdate", cDto);
   }

   @Override
   public int commentDelete(int com_no) {
      // TODO Auto-generated method stub
      return sqlsession.update(nameSpace+".commentDelete", com_no);
   }

   @Override
   public List<CommentDto> commentList(int bo_no) {
      // TODO Auto-generated method stub
      return sqlsession.selectList(nameSpace+".commentList",bo_no);
   }

}
