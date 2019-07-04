package cn.run.java.wechatjava.stone.controller;

import lombok.extern.slf4j.Slf4j;
import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import me.xuxiaoxiao.chatapi.wechat.entity.message.WXText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郑查磊
 * @date 2019/7/3 10:13
 * @email <a href="mailto:stone981023@gmail.com">SmallStone</a>
 */
@Slf4j
@RestController
@RequestMapping("/wechat")
public class MessageController {

    @Autowired
    private WeChatClient weChatClient;

    public void send(String mssage, String user) {
        WXText wxText = weChatClient.sendText(weChatClient.userContact(user), mssage);
        log.info("发送消息:{}", wxText);
    }
}
