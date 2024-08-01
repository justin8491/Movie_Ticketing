package com.box.small.user.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
   @Autowired
   private CommentDAO dao;
   
   @Override
   public int commentAdd(CommentDto cDto) {
      // TODO Auto-generated method stub
      return dao.commentAdd(cDto);
   }

   @Override
   public int commentUpdate(CommentDto cDto) {
      // TODO Auto-generated method stub
      return dao.commentUpdate(cDto);
   }

   @Override
   public int commentDelete(int com_no) {
      // TODO Auto-generated method stub
      return dao.commentDelete(com_no);
   }

   @Override
   public List<CommentDto> commentList(int bo_no) {
      // TODO Auto-generated method stub
      return dao.commentList(bo_no);
   }

}
