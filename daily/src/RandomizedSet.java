import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * 变长数组可以在 O(1) 时间内完成获取随机元素操作，但是不能判断元素是否存在，因此不能完成插入和删除操作
 * 哈希表可以在 O(1) 时间内完成插入和删除操作，因此不能完成获取随机元素操作
 * 因此变长数组存储元素，哈希表中存储每个元素在数组中的下表
 */
public class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        boolean res1 = randomizedSet.insert(0); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        boolean res2 = randomizedSet.insert(1); // 返回 false ，表示集合中不存在 2 。
        boolean res3 = randomizedSet.remove(0); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        int res4 = randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
        boolean res5 = randomizedSet.insert(2); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        boolean res6 = randomizedSet.remove(1); // 2 已在集合中，所以返回 false 。
        int res7 = randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println(res6);
        System.out.println(res7);
    }


    List<Integer> nums;
    Map<Integer, Integer> indexes;
    Random r;
    public RandomizedSet() {
        nums = new ArrayList<>();
        indexes = new HashMap<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (indexes.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indexes.put(val, index);
        return true;
    }

    // 用nums中最后一个元素替换被删除的元素，直接删除会导致后续添加元素时索引不一致
    public boolean remove(int val) {
        if (!indexes.containsKey(val)) {
            return false;
        }
        int index = indexes.get(val); // 从哈希表中获取val对应的索引
        int last = nums.get(nums.size() - 1); // 获取最后一个元素
        nums.set(index, last); // 将nums中最后一个元素last的索引设置为index处
        indexes.put(last, index); // 将哈希表中last元素的索引更新为index
        nums.remove(nums.size() - 1); // 从nums中删除最后一个元素
        indexes.remove(val); // 从哈希表中删除val
        return true;
    }

    public int getRandom() {
        int randomIndex = r.nextInt(nums.size());
        return nums.get(randomIndex);
    }

}
