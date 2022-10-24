package cn.lic.microservice.base.provider.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@RequestMapping("vcode")
@Controller
public class ValidateCodeController {

    @Autowired
    private DefaultKaptcha kaptchaProducer;

    @RequestMapping("build")
    public void buildCode(HttpServletResponse response) throws Exception {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = kaptchaProducer.createText();
        // 生成图片验证码
        BufferedImage image = kaptchaProducer.createImage(text);
        //userService.saveImageCode(random, text);
        try (ServletOutputStream out = response.getOutputStream()) {
            ImageIO.write(image, "JPEG", out);
        }
    }
}
