package gongjun.model;

import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import gongjun.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Date;
import java.util.List;

/**
 * 奖项
 */
@Getter
@Setter
@ToString
public class Award extends BaseEntity {
    
    private Integer id;

    /**
     * 奖项名称
     */
    private String name;

    /**
     * 奖项人数
     */
    private Integer count;

    /**
     * 奖品
     */
    private String award;

    /**
     * 抽奖设置id
     */
    private Integer settingId;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 中奖人员名单 ID
     */
    private List<Integer> luckyMemberIds;
}