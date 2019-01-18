import java.util.Stack;


public class DailyTemp {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] temp = {70, 72, 68, 71, 76, 77};

        DailyTemp dailyTemp = new DailyTemp();

        int[] temps = dailyTemp.dailyTemperatures(temp);

        for(int i : temps) {
            System.out.print(i + " ");
        }
    }
}
