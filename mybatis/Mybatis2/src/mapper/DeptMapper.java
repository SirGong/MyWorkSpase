package mapper;

import bean.DeptInfo;

public interface DeptMapper {
    DeptInfo findByDeptNo(int deptNo);
}
