package offer;

/**
 * @author ： CodeWater
 * @create ：2022-03-24-15:51
 * @Function Description ：旋转数组的最小数字
 */
public class _11MinimumNumberOfRotationArray {
    public int minArray(int[] numbers) {
        // 二分（具体看官方解答）
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                //numbers[mid] == numbers[high]
                high--;
            }
        }
        return numbers[low];
    }
}
