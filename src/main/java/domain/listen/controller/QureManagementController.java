package domain.listen.controller;

import domain.listen.entity.NoteEntity;
import domain.listen.service.QureManagementService;
import domain.shiro.controller.AbstractActionController;
import domain.shiro.entity.PageQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import static domain.listen.ListenWebForward.QURE_PAGE;
import static domain.listen.ListenWebURLMapping.QURE_MAN_PAGE;
import static domain.listen.ListenWebURLMapping.QURE_NOTE_LIST;

/**
 * 按听课人员查询
 */
@Controller
public class QureManagementController extends AbstractActionController{

    private QureManagementService qureManagementService;

    @Autowired
    public QureManagementController(QureManagementService qureManagementService){
        this.qureManagementService = qureManagementService;
    }


    /**
     * 去按听课人员查询
     * @return ModelAndView
     */
    @RequestMapping(value = QURE_MAN_PAGE)
    public ModelAndView index(){
        return new ModelAndView(QURE_PAGE);
    }

    /**
     * 获取听课笔记
     * @param noteEntity 查询实体
     * @return PageQueryResult
     */
    @RequestMapping(value = QURE_NOTE_LIST)
    @ResponseBody
    public PageQueryResult noteListInfo(NoteEntity noteEntity){
        return qureManagementService.noteListInfo(noteEntity);
    }

    @RequestMapping(value = "/listen/getPictureByte")
    @ResponseBody
    public String[] getPictureByte(@RequestBody NoteEntity noteEntity) throws IOException {
        //获取图片路径
        final String path = noteEntity.getPicturePath();
        //获取图片路径地址
        final String[] pathArr=path.split(",");
        //需要返回的base64数组
        String[] base64Array = new String[pathArr.length];

        for (int i=0;i<pathArr.length;i++){
            //图片地址
            String pahtStr = pathArr[i];
            //获取数组
            byte[] imageByte = Files.readAllBytes(Paths.get(pahtStr));
            //转码
            String base64String= Base64.getEncoder().encodeToString(imageByte);
            //添加到64数组
            base64Array[i] = base64String;
        }
        return base64Array;
    }


}
