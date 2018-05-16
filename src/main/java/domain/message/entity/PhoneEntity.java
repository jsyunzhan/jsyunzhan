package domain.message.entity;

import domain.shiro.controller.AbstractActionController;
import lombok.Getter;
import lombok.Setter;

/**
 * 手机端消息实体
 */
@Getter
@Setter
public class PhoneEntity extends AbstractActionController{

    //标题
    private String title;

    //内容
    private String message;

    @Override
    public String toString() {
        return "PhoneEntity{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
