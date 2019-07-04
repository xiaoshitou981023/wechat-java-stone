package cn.run.java.wechat.stone.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 郑查磊
 * @date 2019/7/3 11:15
 * @email <a href="mailto:stone981023@gmail.com">SmallStone</a>
 */
@Configuration
public class RestTemplateConfig {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
