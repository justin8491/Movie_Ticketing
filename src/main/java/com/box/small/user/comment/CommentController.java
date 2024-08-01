package com.box.small.user.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.user.review.ReviewDto;

@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@ResponseBody
	@RequestMapping(value = "/user/comment/commentAdd" , method = RequestMethod.POST)
	public  Map<String, Object> commentAdd(CommentDto cDto){
		System.out.println("코멘트창에 들어왔습니다.");
		ModelAndView mav = new ModelAndView();
		commentService.commentAdd(cDto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cDto", cDto);
		map.put("location", "user/comment/selectFreeBoard?bo_no=" + cDto.getBo_no());
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/comment/commentUpdate", method = RequestMethod.POST)
    public  Map<String, Object> commentUpdate(CommentDto cDto , int com_no) {
        commentService.commentUpdate(cDto);
        System.out.println("내용 : "+cDto.getCom_content());
        System.out.println("번호 : " + com_no);
        Map<String, Object> map = new HashMap<>();
        map.put("com_no", com_no);
        map.put("cDto", cDto);
        map.put("location", "/user/comment/selectFreeBoard?bo_no=" + cDto.getBo_no());
        return map;
    }
	
	@ResponseBody
    @RequestMapping(value = "/user/comment/commentDelete", method = RequestMethod.POST)
    public  Map<String, Object> commentDelete(CommentDto cDto , int com_no) {
       commentService.commentDelete(com_no);
        Map<String, Object> map = new HashMap<>();
        map.put("com_no", com_no);
        map.put("cDto", cDto);
        map.put("location", "/user/comment/selectFreeBoard?bo_no=" + cDto.getBo_no());
        map.put("status", commentService);
        return map;
    }

	

}
