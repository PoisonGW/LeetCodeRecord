package bfs.open_the_turntable_lock;

import java.util.*;

/**
 * 打开转盘锁
 *
 * @author Poison
 * @date 2023/06/12
 */
public class OpenTurntableLock {

    public int openLock(String[] deadends, String target) {
        // 跳过死亡密码
        Set<String> deadSet = new HashSet<>();
        for (String deadend : deadends) {
            deadSet.add(deadend);
        }
        // 跳过已经出现的密码
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // 判断是否到达终点
                if (deadSet.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return count;
                }
                // 添加相邻元素
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            count++;
        }
        return -1;
    }


    /**
     * + 1
     *
     * @return {@code String}
     */
    public String plusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    /**
     * 减一
     *
     * @return {@code String}
     */
    public String minusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }
}
