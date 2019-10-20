package com.qfedu.examsys;

import com.qfedu.examsys.utils.ExcelUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/20 17:19
 */
public class TestExcel {
    @Test
    public void testExcel() {
        String path = "C:\\Users\\我是谁\\Desktop\\test.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            List<Map<String, Object>> maps = ExcelUtils.readExcel(fileInputStream, "test.xlsx");

            for (Map<String, Object> map : maps) {
                Set<Map.Entry<String, Object>> entries = map.entrySet();
                for (Map.Entry<String, Object> entry : entries) {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
