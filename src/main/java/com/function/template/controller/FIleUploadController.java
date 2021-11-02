package com.function.template.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class FIleUploadController {

    @RequestMapping("board/insertBoard.do")
    public String insertBoard(){

        return "/index.html";
    }
}
