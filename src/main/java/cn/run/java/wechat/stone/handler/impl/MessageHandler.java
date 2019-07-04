package cn.run.java.wechat.stone.handler.impl;

import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import me.xuxiaoxiao.chatapi.wechat.entity.message.WXMessage;

import javax.annotation.Nonnull;

/**
 * @author 郑查磊
 * @date 2019-07-04 10:30
 * @email <a href="mailto:stone981023@gmail.com">SmallStone</a>
 */
public interface MessageHandler {

    /**
     * 区分为群消息或用户消息
     *
     * @param client
     * @param message
     */
    default void messageHandler(@Nonnull WeChatClient client, @Nonnull WXMessage message) {
        // 如果对方告诉我他的位置，发送消息的不是自己，则我也告诉他我的位置
        if (message.fromGroup != null) {
            // 群消息
            groupMessageHandler(client, message);
        } else {
            if (message.fromUser.id.equals(client.userMe().id)) {

            } else {
                // 用户消息
                userMessageHandler(client, message);
            }
        }
    }

    /**
     * 用户消息
     *
     * @param client
     * @param message
     */
    void userMessageHandler(@Nonnull WeChatClient client, @Nonnull WXMessage message);

    /**
     * 群消息
     *
     * @param client
     * @param message
     */
    void groupMessageHandler(@Nonnull WeChatClient client, @Nonnull WXMessage message);
}
