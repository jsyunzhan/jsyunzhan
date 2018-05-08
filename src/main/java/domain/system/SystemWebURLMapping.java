package domain.system;

/**
 * 系统设置请求地址
 */
public final class SystemWebURLMapping {
    private SystemWebURLMapping(){

    }

    public static final String SYSTEM_ROOT = "/system/";

    /*------------------系统设置--------------------------------------------------------- */
    /**
     * 去角色管理页面
     */
    public static final String ROLE_MANAGEMENT_PAGE = SYSTEM_ROOT + "rolemanpage";
}
