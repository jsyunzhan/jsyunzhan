package domain.message;

/**
 * 公告管理请求地址
 */
public class MessageWebURLMapping {

    private MessageWebURLMapping(){

    }

    public static final String MESSAGE_ROOT = "/message/";

    /*
    *****************************************手机公告管理************************************************************
     */

    //去手机管理页面
    public static final String MESSAGE_PHONE_MAN_PAGE = MESSAGE_ROOT + "phonemanpage";

    //手机管理页面分页
    public static final String MESSAGE_PHONE_MAN_LIST = MESSAGE_PHONE_MAN_PAGE + "/list";

    //手机公告增加
    public static final String MESSAGE_PHONE_MAN_ADD = MESSAGE_PHONE_MAN_PAGE + "/add";

    //手机公告增加
    public static final String MESSAGE_PHONE_MAN_EDIT = MESSAGE_PHONE_MAN_PAGE + "/edit";

    //手机公告删除
    public static final String MESSAGE_PHONE_MAN_DELETE = MESSAGE_PHONE_MAN_PAGE + "/delete/{id}";


}
