package domain.shiro;

import domain.shiro.entity.AccountEntity;
import domain.shiro.service.UserSecurityService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthorizingRealm extends AuthorizingRealm {

    private final UserSecurityService userSecurityService;


    @Autowired
    public UserAuthorizingRealm(UserSecurityService userSecurityService){
        this.userSecurityService = userSecurityService;
    }

    /**
     * 用户授权
     * @param principalCollection principalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 用户认证
     * @param authenticationToken authenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        final UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        final String loginName = usernamePasswordToken.getUsername();
        final AccountEntity accountEntity = userSecurityService.accoutInfo(loginName);

        //账户是否存在
        if (accountEntity == null) {
            throw new UnknownAccountException("该账号不存在.");
        }

        return new SimpleAuthenticationInfo(loginName, accountEntity.getPassword(),getName());
    }
}
