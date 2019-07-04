package cn.run.java.wechatjava.stone.handler.type;

import lombok.extern.slf4j.Slf4j;
import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import me.xuxiaoxiao.chatapi.wechat.entity.message.WXMessage;
import me.xuxiaoxiao.chatapi.wechat.entity.message.WXVerify;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * @author 郑查磊
 * @date 2019-07-04 10:16
 * @email <a href="mailto:stone981023@gmail.com">SmallStone</a>
 */
@Slf4j
@Component
public class VerifyMessageHandler {


    public void messageHandler(@Nonnull WeChatClient client, @Nonnull WXMessage message) {
        passVerify(client, message);
    }


    /**
     * 接受好友申请
     *
     * @param client
     * @param wxMessage
     */
    private void passVerify(WeChatClient client, WXMessage wxMessage) {
        log.info("接受好友申请:{}", wxMessage);
        client.passVerify((WXVerify) wxMessage);
    }

}
