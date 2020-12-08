/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: number_of_student_solution
 * @Author: EdwardX
 * @Description: 1450. 在既定时间做作业的学生人数
 * @Date: 2020/10/11 10:02
 * @Version: 1.0
 */
public class number_of_student_solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int temp = 0;
        for (int i = 0; i < startTime.length; i++) {
            if(queryTime <= endTime[i] && queryTime >= startTime[i])
                temp++;
        }
        return temp;
    }
}
