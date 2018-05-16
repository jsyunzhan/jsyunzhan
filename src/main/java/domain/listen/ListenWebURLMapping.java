package domain.listen;

/**
 * 听课查询请求地址
 */
public class ListenWebURLMapping {

    private ListenWebURLMapping(){

    }

    public static final String LISTEN_ROOT = "/listen/";

    /*
    *****************************************听课查询管理************************************************************
     */

    //去按人员查询页面
    public static final String QURE_MAN_PAGE = LISTEN_ROOT + "quremanpage";

    //获取听课笔记
    public static final String QURE_NOTE_LIST = QURE_MAN_PAGE + "/notelist";

}
