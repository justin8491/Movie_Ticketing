package com.box.small.admin.comment;

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
public class AdminCommentController {
	
	@Autowired
	AdminCommentService commentService;
	
	@ResponseBody
	@RequestMapping(value = "/admin/comment/adminCommentAdd" , method = RequestMethod.POST)
	public  Map<String, Object> adminCommentAdd(AdminCommentDto cDto){
		System.out.println("코멘트창에 들어왔습니다.");
		ModelAndView mav = new ModelAndView();
		commentService.adminCommentAdd(cDto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cDto", cDto);
		map.put("location", "/admin/comment/selectFreeBoard?bo_no=" + cDto.getBo_no());
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/comment/adminCommentUpdate", method = RequestMethod.POST)
    public  Map<String, Object> adminCommentUpdate(AdminCommentDto cDto , int com_no) {
        commentService.adminCommentUpdate(cDto);
        System.out.println("내용 : "+cDto.getCom_content());
        System.out.println("번호 : " + com_no);
        Map<String, Object> map = new HashMap<>();
        map.put("com_no", com_no);
        map.put("cDto", cDto);
        map.put("location", "/admin/comment/selectFreeBoard?bo_no=" + cDto.getBo_no());
        return map;
    }
	
	@ResponseBody
    @RequestMapping(value = "/admin/comment/adminCommentDelete", method = RequestMethod.POST)
    public  Map<String, Object> adminCommentDelete(AdminCommentDto cDto , int com_no) {
       commentService.adminCommentDelete(com_no);
        Map<String, Object> map = new HashMap<>();
        map.put("com_no", com_no);
        map.put("cDto", cDto);
        map.put("location", "/admin/comment/selectFreeBoard?bo_no=" + cDto.getBo_no());
        map.put("status", commentService);
        return map;
    }

	

}
