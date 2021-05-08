package com.jay.server.config.kaptcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha defaultKaptcha() {
        //验证码生成器
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();

        //配置属性
        Properties properties = new Properties();
        //是否有边框
        properties.setProperty("kaptcha.boder", "yes");
        //边框颜色
        properties.setProperty("kaptcha.boder-color", "105.179,90");
        //边框宽度
//        properties.setProperty("kaptcha.border.thickness","1");
        //验证码
        properties.setProperty("kaptcha.session.key", "code");
        //字体文本颜色，默认黑色
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        //字体样式
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        //字体大小
        properties.setProperty("kaptcha.textproducer.font.size", "30");
        //验证码文本字符内容范围，abcde2345678gfynmnpwx
//        properties.setProperty("kaptcha.textproducer.char.string","abcde2345678gfynmnpwx");
        //验证码个数，默认为5
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        //验证码字符间距，默认为2
        properties.setProperty("kaptcha.textproducer.char.space", "4");
        //验证码图片宽度，默认为200
        properties.setProperty("kaptcha.image.width", "100");
        //验证码图片高度，默认为40
        properties.setProperty("kaptcha.image.height", "40");

        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}
