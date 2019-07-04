package cn.run.java.wechatjava.stone.doamin.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 注意：如果encode参数为text，那么输出的只有一言正文。
 *
 * @author 郑查磊
 * @date 2019/6/25 17:31
 * @email <a href="mailto:stone981023@gmail.com">SmallStone</a>
 */
@Data
@Accessors(chain = true)
public class Hitokoto {

    /**
     * 本条一言的id。
     * 可以链接到https://hitokoto.cn?id=[id]查看这个一言的完整信息
     */
    private Long id;

    /**
     * 一言正文。编码方式unicode。使用utf-8。
     */
    private String hitokoto;

    /**
     * 参数: c  可选
     * a	Anime - 动画
     * b	Comic – 漫画
     * c	Game – 游戏
     * d	Novel – 小说
     * e	Myself – 原创
     * f	Internet – 来自网络
     * g	Other – 其他
     * <p>
     * 参数: encode 可选
     * text	返回纯净文本
     * json	返回不进行unicode转码的json文本
     * js	返回指定选择器(默认.hitokoto)的同步执行函数。
     * 其他不存在参数	返回unicode转码的json文本
     * <p>
     * <p>
     * 参数: charset  可选
     * utf-8	返回 UTF-8 编码的内容，支持与异步函数同用。
     * gbk	返回 GBK 编码的内容，不支持与异步函数同用。
     * <p>
     * 参数: callback 可选
     * 回调函数	将返回的内容传参给指定的异步函数。
     */
    private String type;

    /**
     * 一言的出处。
     */
    private String from;

    /**
     * 添加者。
     */
    private String creator;

    /**
     * 添加时间。
     */
    private String created_at;

}
