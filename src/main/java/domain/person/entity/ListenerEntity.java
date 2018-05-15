package domain.person.entity;

import domain.shiro.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListenerEntity extends AbstractEntity {

    //听课人员姓名
    private String listenerName;

    //听课人员身份证
    private Long listenerNumb;

    //学校名称
    private String schoolName;

    //查看私有笔记权限(0为没有权限,1为有权限)
    private Long permissionFlag;

    //记录open_id(空:未注册)
    private Long openId;

    @Override
    public String toString() {
        return "ListenerEntity{" +
                "listenerName='" + listenerName + '\'' +
                ", listenerNumb=" + listenerNumb +
                ", schoolName='" + schoolName + '\'' +
                ", permissionFlag=" + permissionFlag +
                ", openId=" + openId +
                '}';
    }
}
