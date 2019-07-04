package cn.run.java.wechatjava.stone.handler.type;

import cn.run.java.wechatjava.stone.handler.impl.MessageHandler;
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
public class ImageMessageHandler implements MessageHandler {

    /**
     * 用户消息
     *
     * @param client
     * @param message
     */
    @Override
    public void userMessageHandler(@Nonnull WeChatClient client, @Nonnull WXMessage message) {
        log.info("收到了一张图片:{}", message);
        client.sendText(message.fromUser, "对不起,小石头看不懂图片哦!");
    }

    /**
     * 群消息
     *
     * @param client
     * @param message
     */
    @Override
    public void groupMessageHandler(@Nonnull WeChatClient client, @Nonnull WXMessage message) {
//        client.sendText(message.fromGroup, message.content);
    }
}
