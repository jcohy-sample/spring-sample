package bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 *
 * @author jiac
 * @version 2022.04.0 2022/9/1:14:37
 * @since 2022.04.0
 */
public class BloomFilterDemo {

    public static final int insertions = 1000000;

    public static void main(String[] args) {
        // 错误率为 0.02
        BloomFilter<CharSequence> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), insertions, 0.02);
        Set<String> sets = new HashSet<>(insertions);

        List<String> lists = new ArrayList<>(insertions);

        for (int i = 0; i < insertions; i++) {
            String uuid = UUID.randomUUID().toString();
            // 添加元素
            bf.put(uuid);
            sets.add(uuid);
            lists.add(uuid);
        }

        int wrong = 0;
        int right = 0;

        for (int i = 0; i < 10000; i++) {
            String data = i % 100 == 0 ? lists.get(i / 100) : UUID.randomUUID().toString();
            // 判断元素是否存在，如果判断存在，则有可能存在，也有可能不存在
            // right 保存真实存在的元素，wrong 保存误认为存在的元素
            if (bf.mightContain(data)) {
                if (sets.contains(data)) {
                    right++;
                    continue;
                }
                wrong++;
            }
        }
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(2);
        float percent = (float) wrong / 9900;
        float bingo = (float) (9900 - wrong) / 9900;
        System.out.println("在100W个元素中，判断100个实际存在的元素，布隆过滤器认为存在的：" + right);
        System.out.println("在100W个元素中，判断9900个实际不存在的元素，误认为存在的：" + wrong + "" + "，命中率：" + numberFormat.format(bingo)
                + ",误判率:" + numberFormat.format(percent));
    }
}
