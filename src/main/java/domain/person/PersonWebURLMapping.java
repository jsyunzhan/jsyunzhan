package domain.person;

/**
 * 人员管理请求地址
 */
public class PersonWebURLMapping {

    private PersonWebURLMapping(){

    }

    public static final String PERSON_ROOT = "/person/";

    /*
    *****************************************听课人员管理************************************************************
     */

    //去听课人员管理页面
    public final static String LISTENER_MAN_PAGE = PERSON_ROOT + "listenermanpage";

    //听课人员管理分页
    public final static String LISTENER_MAN_LIST = LISTENER_MAN_PAGE + "/list";

    //听课人员新增
    public final static String LISTENER_MAN_ADD = LISTENER_MAN_PAGE + "/add";

    //听课人员修改
    public final static String LISTENER_MAN_EDIT = LISTENER_MAN_PAGE + "/edit";

    //听课人员删除
    public final static String LISTENER_MAN_DELETE= LISTENER_MAN_PAGE + "/delete/{id}";

    //听课人员查看私有笔记授权
    public final static String LISTENER_MAN_AUTHORIZATION= LISTENER_MAN_PAGE + "/authorization/{id}";

    //听课人员查看私有笔记解除授权
    public final static String LISTENER_MAN_AUTHORIZATION_NOT= LISTENER_MAN_PAGE + "/authorizationnot/{id}";

    //听课人员机关进校园提交授权
    public final static String LISTENER_MAN_ORGAN= LISTENER_MAN_PAGE + "/organ/{id}";

    //听课人员机关进校园提交解除授权
    public final static String LISTENER_MAN_ORGANNOT= LISTENER_MAN_PAGE + "/organnot/{id}";
}
