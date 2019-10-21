package com.qfedu.examsys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.examsys.dao.TestPaperDao;
import com.qfedu.examsys.pojo.EAnswerquestions;
import com.qfedu.examsys.pojo.ESinglequestions;
import com.qfedu.examsys.utils.ExcelUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public void testExcel() throws IOException {
        String path = "C:\\Users\\我是谁\\Desktop\\SingleQuestion.xlsx";
        FileInputStream fileInputStream = null;
        List<String> sheetList = null;
        try {
            fileInputStream = new FileInputStream(path);
            List<Map<String, Object>> maps = ExcelUtils.readExcel(fileInputStream, "SingleQuestion.xlsx");

//            sheetList = ExcelUtils.GetMapKey(maps);
//
//            System.out.println(sheetList.contains("stitle"));

            System.out.println(ExcelUtils.getCellNameValue(fileInputStream, "test.xlsx"));
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

    @Test
    public void testUpload() {
        String path = "C:\\Users\\我是谁\\Desktop\\AnswerQuestion.xlsx";
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(path);
            List<Map<String, Object>> maps = ExcelUtils.readExcel(fileInputStream, "AnswerQuestion.xlsx");


            ObjectMapper objectMapper = new ObjectMapper();
            //将List转成json格式数据
            String jsonStr = objectMapper.writeValueAsString(maps);

            List<EAnswerquestions> sqList = objectMapper.readValue(jsonStr, new TypeReference<List<EAnswerquestions>>() {
            });
            for ( EAnswerquestions eAnswerquestions : sqList) {
                System.out.println(eAnswerquestions.getAanswer()+":"+eAnswerquestions.getAtitle());
            }
//            for (Map<String, Object> map : maps) {
//                Set<Map.Entry<String, Object>> entries = map.entrySet();
//                for (Map.Entry<String, Object> entry : entries) {
//                    System.out.println(entry.getKey() + ":" + entry.getValue());
//                }
//            }


        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
