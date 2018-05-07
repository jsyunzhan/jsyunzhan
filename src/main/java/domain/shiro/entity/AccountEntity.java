package domain.shiro.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class AccountEntity extends AbstractEntity{

    //用户名称
    private String userName;

    //登录名
    private String loginName;

    //密码
    private String password;

    //关联(系统角色表)
    private Long roleId;

    //角色名称
    private String roleName;




}
