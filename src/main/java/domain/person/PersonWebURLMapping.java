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

    public final static String LISTENER_MAN_PAGE = PERSON_ROOT + "listenermanpage";
}
