package cn.run.java.wechatjava.stone.handler;


import cn.run.java.wechatjava.stone.handler.impl.MessageTypeHandler;
import cn.run.java.wechatjava.stone.handler.type.*;
import lombok.extern.slf4j.Slf4j;
import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import me.xuxiaoxiao.chatapi.wechat.entity.message.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * @author 郑查磊
 * @date 2019-07-04 10:09
 * @email <a href="mailto:stone981023@gmail.com">SmallStone</a>
 */
@Slf4j
@Component
public class DefaultMessageTypeHandler implements MessageTypeHandler {


    @Autowired
    private VerifyMessageHandler verifyMessageHandler;

    @Autowired
    private LocationMessageHandler locationMessageHandler;

    @Autowired
    private ImageMessageHandler imageMessageHandler;

    @Autowired
    private LinkMessageHandler linkMessageHandler;

    @Autowired
    private TextMessageHandler textMessageHandler;

    /**
     * 默认处理器
     *
     * @param client
     * @param message
     */
    @Override
    public void checkMessage(@Nonnull WeChatClient client, @Nonnull WXMessage message) {

        if (message instanceof WXVerify) {
            log.info("好友申请:{}", message);
            verifyMessageHandler.messageHandler(client, message);
        }

        if (message instanceof WXText) {
            log.info("收到文字消息:{}", message);
            textMessageHandler.messageHandler(client, message);
        }

        if (message instanceof WXLocation) {
            log.info("收到了一条位置消息:{}", message);
            locationMessageHandler.messageHandler(client, message);
        }

        if (message instanceof WXLocation) {
            log.info("收到了一条分享链接:{}", message);
            linkMessageHandler.messageHandler(client, message);
        }

        if (message instanceof WXImage) {
            log.info("收到了一张图片:{}", message);
            imageMessageHandler.messageHandler(client, message);
        }

        if(message instanceof WXEmoji){
            log.info("收到了一张Emoji表情:{}", message);
            imageMessageHandler.messageHandler(client, message);
        }


    }

}
