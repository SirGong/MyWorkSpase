package mapper;

import bean.EmpInfo;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    List<EmpInfo> findAllEmp(EmpInfo e);
    List<EmpInfo> findAllEmp2(Map<String,Integer> map);
    void updateEmp(EmpInfo e);
    List<EmpInfo> findEmp(EmpInfo e);
}
