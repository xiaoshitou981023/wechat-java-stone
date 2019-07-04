package cn.run.java.wechatjava.stone.config;

import cn.run.java.wechatjava.stone.handler.impl.MessageTypeHandler;
import lombok.extern.slf4j.Slf4j;
import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import me.xuxiaoxiao.chatapi.wechat.entity.message.WXMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * @author 郑查磊
 * @date 2019/7/3 10:43
 * @email <a href="mailto:stone981023@gmail.com">SmallStone</a>
 */
@Slf4j
@Component
public class DefaultMessageHandler {

    @Autowired
    private MessageTypeHandler messageTypeHandler;

    public void onMessage(@Nonnull WeChatClient client, @Nonnull WXMessage message) {
        // 交由消息处理器处理
        messageTypeHandler.checkMessage(client, message);
    }

}
