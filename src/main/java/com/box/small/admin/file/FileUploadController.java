package com.box.small.admin.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    @Autowired
    private ServletContext servletContext;

    @PostMapping("/admin/movie/adminMovie/upload")
    public String uploadFile(MultipartFile file, RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "파일을 업로드해주세요!");
            return "redirect:/uploadStatus";
        }

        try {
            // 웹 애플리케이션의 실제 경로 가져오기
            String uploadDir = servletContext.getRealPath("/resources/images/");

            // 파일 이름과 경로 설정
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(uploadDir, fileName);

            // 파일을 지정된 폴더로 복사
            Files.copy(file.getInputStream(), path);

            redirectAttributes.addFlashAttribute("message", "성공적으로 '" + fileName + "'을 업로드 했습니다.");

        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "'" + file.getOriginalFilename() + "' 업로드에 실패하였습니다.");
        }

        return "redirect:/uploadStatus";
    }
}