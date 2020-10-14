package review_jz.字符串;

/**
 * @author LiXiwen
 * @date 2020/3/14 17:31
 */
public class 回溯法 {

}
/*
模板：
result = []
void backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择

 */
