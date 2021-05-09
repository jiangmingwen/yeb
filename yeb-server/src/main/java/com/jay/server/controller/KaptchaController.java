package com.jay.server.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class KaptchaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @ApiOperation("验证码")
    @GetMapping(value = "/unauth/kaptcha",produces = "image/jpeg")
    public void captch(HttpServletRequest request, HttpServletResponse response) {
        //定义response输出类型为image/jpeg类型
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        //生成验证码 start

        //生成验证码文本
        String text = defaultKaptcha.createText();
        //将验证码放到session中
        request.getSession().setAttribute("kaptcha",text);
        //根据文本内容创建图形验证码
        BufferedImage image = defaultKaptcha.createImage(text);
        ServletOutputStream outputStream = null;

        try {
            outputStream= response.getOutputStream();
            ImageIO.write(image,"jpg",outputStream);
            outputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //生成验证码 end
    }
}
