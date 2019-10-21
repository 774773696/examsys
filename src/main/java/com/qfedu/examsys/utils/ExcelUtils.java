package com.qfedu.examsys.utils;


import com.qfedu.examsys.common.JsonBean;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/20 15:03
 * 上传文件的工具类
 */
public class ExcelUtils {

    private final static String EXCEL2003 = "xls";
    private final static String EXCEL2007 = "xlsx";

    /**
     * 读取Excel文件内容
     *
     * @param inputStream 文件输入流
     * @param fileName    文件名
     */
    public static List<Map<String, Object>> readExcel(InputStream inputStream, String fileName) {

        List<Map<String, Object>> list = new ArrayList<>();

        boolean ret = isXls(fileName);
        Workbook workbook = null;
        try {
            if (ret) {
                //  2007及以上版本使用
                workbook = new HSSFWorkbook(inputStream);
            } else {
                // 2003及以下版本使用
                workbook = new XSSFWorkbook(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheetAt(0);
        //标题的row
        Row row = sheet.getRow(0);
        //获取最后一行的行号
        int lastRowNum = sheet.getLastRowNum();
        //获取roe里最后一个单元格的编号
        short lastCellNum = row.getLastCellNum();
        for (int i = 1; i <= lastRowNum; i++) {

            Map<String, Object> map = new HashMap<>();
            Row row1 = sheet.getRow(i);
            for (int j = 0; j < lastCellNum; j++) {
                Cell cell = row1.getCell(j);
                if (cell == null) {
                    continue;
                }
                cell.setCellType(CellType.STRING);
//                System.out.println(cell.getStringCellValue());
                //对应的标题行是key值
                map.put(row.getCell(j).getStringCellValue(), cell.getStringCellValue());
            }
            list.add(map);
        }

        return list;
    }

    /**
     * 判断文件的后缀，是否为Excel文件
     *
     * @param fileName
     * @return 判断Excel文件，xlx后缀返回true，xlsx返回false
     */
    private static boolean isXls(String fileName) {
        //match()判断正则匹配,java中的正则匹配使用""
        //(?i)表示不区分大小写
        if (fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 获取读取excel文件的第一行的名字
     * @param inputStream
     * @return
     */
    public static String getCellNameValue(InputStream inputStream,String fileName) {

        boolean ret = isXls(fileName);
        Workbook workbook = null;
        try {
            if (ret) {
                //  2007及以上版本使用
                workbook = new HSSFWorkbook(inputStream);
            } else {
                // 2003及以下版本使用
                workbook = new XSSFWorkbook(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);

        Cell cell=sheet.getRow(0).getCell(0);
        String value=getCellValue(cell);
         return  value;
    }

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        // 以下是判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: // 数字
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellValue = sdf.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
                } else {
                    DataFormatter dataFormatter = new DataFormatter();
                    cellValue = dataFormatter.formatCellValue(cell);
                }
                break;
            case Cell.CELL_TYPE_STRING: // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                cellValue = cell.getBooleanCellValue() + "";
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式
                cellValue = cell.getCellFormula() + "";
                break;
            case Cell.CELL_TYPE_BLANK: // 空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: // 故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    /**
     * 得到流中的map的key的集合的方法
     * @param listResult
     * @return
     */
    public static List<String> GetMapKey(List<Map<String,Object>> listResult) {
        if ((listResult != null) && (!listResult.isEmpty()))
        {
            List listKey = new ArrayList();

            Map mapResult = (Map)listResult.get(0);

            Set mapKeySet = mapResult.keySet();

            Object listHead = "";

            Iterator iteratorKey = mapKeySet.iterator();
            while (iteratorKey.hasNext()) {
                listHead = iteratorKey.next();
                listKey.add(listHead);
            }

            return listKey;
        }
        return null;
    }


}


