package cn.run.java.wechat.stone.handler.type;

import cn.run.java.wechat.stone.handler.impl.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import me.xuxiaoxiao.chatapi.wechat.entity.message.WXMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * @author 郑查磊
 * @date 2019-07-04 10:28
 * @email <a href="mailto:stone981023@gmail.com">SmallStone</a>
 */
@Slf4j
@Component
public class LocationMessageHandler implements MessageHandler {

    /**
     * 用户消息
     *
     * @param client
     * @param message
     */
    @Override
    public void userMessageHandler(@Nonnull WeChatClient client, @Nonnull WXMessage message) {
        log.info("位置信息:{}", message);
        client.sendLocation(message.fromUser, "120.14556", "30.23856", "I'messageTypeHandler In Here", "西湖");
    }

    /**
     * 群消息
     *
     * @param client
     * @param message
     */
    @Override
    public void groupMessageHandler(@Nonnull WeChatClient client, @Nonnull WXMessage message) {
//        client.sendLocation(message.fromGroup, "120.14556", "30.23856", "I'messageTypeHandler In Here", "西湖");
    }
}
