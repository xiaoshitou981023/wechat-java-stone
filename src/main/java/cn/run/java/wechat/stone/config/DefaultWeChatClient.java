package cn.run.java.wechat.stone.config;

import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 郑查磊
 * @date 2019/7/3 9:56
 * @email <a href="mailto:stone981023@gmail.com">SmallStone</a>
 */
@Configuration
public class DefaultWeChatClient {

    @Autowired
    private DefaultWeChatListener defaultWeChatListener;

    @Bean
    public WeChatClient weChatClient() {
        //新建一个模拟微信客户端
        WeChatClient wechatClient = new WeChatClient();
        //为模拟微信客户端设置监听器
        wechatClient.setListener(defaultWeChatListener);
        //启动模拟微信客户端
        wechatClient.startup();

        return wechatClient;
    }

}
