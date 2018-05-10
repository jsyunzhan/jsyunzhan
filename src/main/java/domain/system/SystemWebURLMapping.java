package domain.system;

/**
 * 系统设置请求地址
 */
public final class SystemWebURLMapping {
    private SystemWebURLMapping(){

    }

    public static final String SYSTEM_ROOT = "/system/";

    /*------------------角色管理--------------------------------------------------------- */
    /**
     * 去角色管理页面
     */
    public static final String ROLE_MANAGEMENT_PAGE = SYSTEM_ROOT + "rolemanpage";


    /*------------------用户管理--------------------------------------------------------- */
    /**
     * 去用户管理页面
     */
    public static final String ACCOUNT_MANAGEMENT_PAGE = SYSTEM_ROOT + "accountmanpage";

    /**
     * 分页
     */
    public static final String ACCOUT_LIST_GET = ACCOUNT_MANAGEMENT_PAGE + "/accountlist";
}
