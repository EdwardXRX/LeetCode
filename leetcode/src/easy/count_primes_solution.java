package easy;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: count_primes_solution
 * @Author: EdwardX
 * @Description: 204. 计数质数
 * @Date: 2020/12/3 9:54
 * @Version: 1.0
 */
public class count_primes_solution {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            boolean flag = true;                  //1、假设是质数
            for (int j = 2; j <= (int) Math.sqrt(i); j++) {   //Math.squart()取平方根
                if (i % j == 0) {
                    flag = false;              //2、改为不是质数
                    break;
                }
            }
            if (flag) {                         //3、得结论
                count++;
            }

        }
        return count;

    }

    public boolean judgePrime(int num) {
        boolean flag = true;
        if (num == 1 || (num % 2 == 0 && num != 2)) {
            flag = false;
        } else {
            for (int j = 3; j <= Math.sqrt(num); j += 2) {
                if (num % j == 0) flag = false;
            }
        }
        return flag;
    }


//输出1-100中质数


    public static void main(String[] args) {

        int count = 0;
        for (int i = 2; i <= 100; i++) {
            boolean flag = true;                  //1、假设是质数
            for (int j = 2; j <= (int) Math.sqrt(i); j++) {   //Math.squart()取平方根
                if (i % j == 0) {
                    flag = false;              //2、改为不是质数
                    break;
                }
            }
            if (flag) {                         //3、得结论
                count++;
                System.out.print(i + "，");
            }

        }
    }
}


