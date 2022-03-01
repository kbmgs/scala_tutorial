/**
 * @title: TestBreak
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/1 22:12
 */

// 使用try-catch，在catch中什么都不做，也可以实现退出循环的功能
public class TestBreak {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                if (i == 3) {
//                    break;
                    throw new RuntimeException();
                }
                System.out.println(i);
            }
        } catch (Exception e) {
            // 什么都不做，只退出循环
        }
    }
}
