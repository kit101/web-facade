package com.kit.web.facade;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Iterator;

/**
 * @version V1.0
 * @desc:
 * @author: k7kit
 * @date: 2019-10-23
 */
public class Tests {

    @Test
    public void test01() {
        System.out.println(LocalDateTime.now(ZoneId.of("Asia/Shanghai")));

        Iterator<String> a = ZoneId.getAvailableZoneIds().iterator();

        while (a.hasNext()) {
            System.out.println(a.next());
        }
    }
}
