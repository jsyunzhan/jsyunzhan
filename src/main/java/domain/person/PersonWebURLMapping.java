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

    //听课人员管理分页
    public final static String LISTENER_MAN_ADD = LISTENER_MAN_PAGE + "/add";
}
