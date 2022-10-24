package cn.lic.microservice.base.provider.conf;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class ValidateCodeConfig {

    @Bean
    public DefaultKaptcha kaptchaProducer() {
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        // 验证码字体颜色
        properties.put("kaptcha.textproducer.font.color", "black");
        // 验证码字体大小
        properties.put("kaptcha.textproducer.font.size", "40");
        // 验证码文本字符间距
        properties.put("kaptcha.textproducer.char.space", "6");
        // 验证码宽度
        properties.put("kaptcha.image.width", "120");
        // 验证码高度
        properties.put("kaptcha.image.height", "50");
        properties.put("kaptcha.textproducer.char.length", "4");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}
