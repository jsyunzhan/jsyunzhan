package domain.shiro.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 资源实体
 */
@Getter
@Setter
public class ResourceEntity extends AbstractEntity{

    //资源名称
    private String resourceName;

    //资源地址,一级标题可为空
    private String resourceUrl;

    //排序
    private Long orderNumber;

    //父标题ID,一级标题为空
    private Long parentId;

}
