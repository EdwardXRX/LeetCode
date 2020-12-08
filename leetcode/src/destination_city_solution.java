import java.util.Iterator;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: destination_city_solution
 * @Author: EdwardX
 * @Description: 1436
 * @Date: 2020/10/7 8:42
 * @Version: 1.0
 */
public class destination_city_solution {
    public String destCity(List<List<String>> paths) {

        boolean flag =false;


        Iterator Paths111 = paths.iterator();
        while(Paths111.hasNext()) {
            List path1 = (List)Paths111.next();
            //迭代器去遍历List<List<String>>
            for (Iterator Paths = paths.iterator(); Paths.hasNext(); ) {

                //paths中得每一个元素，都用path来代替，进行遍历操作
                List path2 = (List) Paths.next();

                if (path1.get(1).equals(path2.get(0))) {
                    flag = true;
                    break;
                }
            }
            if(flag == false)
                return (String)path1.get(1);
            else flag = false;
        }
        return "";
    }
}
