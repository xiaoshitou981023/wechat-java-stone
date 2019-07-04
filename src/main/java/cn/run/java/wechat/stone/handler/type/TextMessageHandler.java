package cn.run.java.wechat.stone.handler.type;

import cn.run.java.wechat.stone.doamin.dto.Hitokoto;
import cn.run.java.wechat.stone.doamin.dto.Weather;
import cn.run.java.wechat.stone.handler.impl.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import me.xuxiaoxiao.chatapi.wechat.entity.contact.WXGroup;
import me.xuxiaoxiao.chatapi.wechat.entity.message.WXMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Nonnull;

/**
 * @author 郑查磊
 * @date 2019-07-04 10:28
 * @email <a href="mailto:stone981023@gmail.com">SmallStone</a>
 */
@Slf4j
@Component
public class TextMessageHandler implements MessageHandler {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 用户消息
     *
     * @param client
     * @param message
     */
    @Override
    public void userMessageHandler(@Nonnull WeChatClient client, @Nonnull WXMessage message) {
        log.info("用户:{} 发给:{} 的消息:{}", message.fromUser, message.toContact, message.content);
        Hitokoto hitokoto = restTemplate.getForObject("https://v1.hitokoto.cn/?c=e", Hitokoto.class);
        // 用户消息
        client.sendText(message.fromUser, hitokoto.toString());
    }

    /**
     * 群消息
     *
     * @param client
     * @param message
     */
    @Override
    public void groupMessageHandler(@Nonnull WeChatClient client, @Nonnull WXMessage message) {
        WXGroup wxGroup = client.userGroups().get(message.fromGroup.id);
        log.info("当前微信群 名称:{},人数:{},", wxGroup.nameQP, wxGroup.members.size());
        if (wxGroup.nameQP.equalsIgnoreCase("hello")) {
            int i = message.content.indexOf(":");
            if (i > 0) {
                String substring = message.content.substring(0, i);

                switch (substring) {
                    case "天气":
                        Weather body = restTemplate.getForEntity("https://www.tianqiapi.com/api/?city=" + message.content.substring(i + 1), Weather.class).getBody();
                        client.sendText(message.fromGroup, "["+body.getCity() + "]今天的天气情况:" + "[" + body.getData().get(0).getWea() + "]----" + body.getData().get(0).getAir_tips());
                        break;
                    default:
                        client.sendText(message.fromGroup, "更多功能还在开发中!");
                        break;
                }

            }
        }
    }
}
