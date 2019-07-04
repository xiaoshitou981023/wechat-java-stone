package cn.run.java.wechat.stone.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import me.xuxiaoxiao.chatapi.wechat.entity.contact.WXContact;
import me.xuxiaoxiao.chatapi.wechat.entity.message.WXMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author 郑查磊
 * @date 2019/7/3 9:46
 * @email <a href="mailto:stone981023@gmail.com">SmallStone</a>
 */
@Slf4j
@Configuration
public class DefaultWeChatListener extends WeChatClient.WeChatListener {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DefaultMessageHandler defaultMessageHandler;

    /**
     * @param weChatClient
     * @param s
     */
    @Override
    public void onQRCode(@Nonnull WeChatClient weChatClient, @Nonnull String s) {
        log.info("WeChatClient:{}, 扫描二维码登录:{}", weChatClient, s);
    }

    @Override
    public void onLogin(@Nonnull WeChatClient client) {
        log.info("登陆成功!好友数量:{},群数量:{}", client.userFriends().size(), client.userGroups().size());
    }

    @Override
    public void onLogout(@Nonnull WeChatClient client) {
        log.info("退出登录!!! 状态:{}", client.status());
    }

    @Override
    public void onAvatar(@Nonnull WeChatClient client, @Nonnull String base64Avatar) {
        log.info("登录状态:{},正在获取头像:{}", client.status(), base64Avatar);
    }

    @Override
    public void onFailure(@Nonnull WeChatClient client, @Nonnull String reason) {
        log.error("登录失败:{},状态:{}", client.status(), reason);
    }

    @Override
    public void onMessage(@Nonnull WeChatClient client, @Nonnull WXMessage message) {
        log.info("收到一条消息,消息内容:{},", message.content);
        defaultMessageHandler.onMessage(client, message);
    }

    @Override
    public void onContact(@Nonnull WeChatClient client, @Nullable WXContact oldContact, @Nullable WXContact newContact) {
        try {
            log.info("联系人变更,旧的联系人:{},新的联系人:{}",
                    objectMapper.writeValueAsString(oldContact), objectMapper.writeValueAsString(newContact));
        } catch (JsonProcessingException e) {
            log.info("联系人变更序列化异常");
        }
    }

}
