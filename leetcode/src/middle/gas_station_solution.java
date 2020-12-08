package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: gas_station_solution
 * @Author: EdwardX
 * @Description: 134. 加油站
 * @Date: 2020/11/18 9:24
 * @Version: 1.0
 */
public class gas_station_solution {
    public static void main(String[] args) {
        int[] gas = {2};
        int[] cost = {2};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            //加油站油量大于花费油量，才进行判断
            if (gas[i] >= cost[i]) {

                int index = i;
                int gas_num = 0;
                while (true) {
                    //如果到最后勒，就重置为0
                    //到本加油站之后
                    //油量= 当前油量+当前加油站油量 - 花费的
                    gas_num = gas_num + gas[index] - cost[index];
                    //如果这个油量小于0
                    //结束while循环
                    if (gas_num < 0) {
                        break;
                    } else {
                        index++;
                    }

                    if (index == gas.length) {
                        index = 0;
                    }

                    if (index == i) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }


}
