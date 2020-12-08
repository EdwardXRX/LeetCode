package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: island_perimeter_solution
 * @Author: EdwardX
 * @Description: 463. 岛屿的周长
 * @Date: 2020/10/30 8:27
 * @Version: 1.0
 */

/*
* 输入:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

输出: 16

解释: 它的周长是下面图片中的 16 个黄色的边：



* */
public class island_perimeter_solution {

    public static void main(String[] args) {
        int[][] nums = {{0,1,0,0},{1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        System.out.println(islandPerimeter(nums));
    }
    public static int islandPerimeter(int[][] grid) {
        int[][] haha = new int[grid.length+2][grid[0].length+2];
        int num= 0;
        for (int i = 1; i < haha.length -1; i++) {
            for (int j = 1; j < haha[0].length -1; j++) {
                haha[i][j] =grid[i-1][j-1];
            }
        }
        for (int i = 1; i < haha.length-1; i++) {
            for (int j = 1; j < haha[0].length-1; j++) {
                num += (4- haha[i+1][j]-haha[i-1][j]-haha[i][j+1]-haha[i][j-1]);
            }
        }
        return num;
    }

}
