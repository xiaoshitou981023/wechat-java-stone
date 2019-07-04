package cn.run.java.wechat.stone.handler.impl;

import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import me.xuxiaoxiao.chatapi.wechat.entity.message.WXMessage;

import javax.annotation.Nonnull;

/**
 * @author 郑查磊
 * @date 2019-07-04 10:12
 * @email <a href="mailto:stone981023@gmail.com">SmallStone</a>
 */
public interface MessageTypeHandler {

    /**
     * 默认处理器
     *
     * @param client
     * @param message
     */
    void checkMessage(@Nonnull WeChatClient client, @Nonnull WXMessage message);

}
