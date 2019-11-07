package com.laijiamei.member;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.laijiamei.member.utils.ExcelUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 不启动程序的公共测试类
 * @date 10:50 2019/10/21
 */
class CommonTests {

    private static Logger log = LoggerFactory.getLogger(CommonTests.class);

    /**
     * description:<用easyExcel读取Excel的数据>
     * @author jiamei.lai（jiamei.lai@ucarinc.com）
     * @date 2019/10/28 14:58
     * @params [] <参数说明>
     * @return void <返回值说明>
     */
    @Test
    void test1() {
        String filePath = "C:\\Users\\111\\Desktop\\公司电脑桌面\\账号列表 20191028.xlsx";
        // 第一个1代表sheet1, 第二个0代表从第几行开始读取数据，行号最小值为0
        Sheet sheet1 = new Sheet(1, 0);
        InputStream fileStream = null;
        try {
            fileStream = new FileInputStream(filePath);
            List<Object> list =  EasyExcelFactory.read(fileStream, sheet1);
            for (Object o : list) {
                System.out.println(o);
            }



            String filePath2 = "C:\\Users\\111\\Desktop\\公司电脑桌面\\账号列表导出 20191028.xlsx";
            Sheet sheet2 = new Sheet(1);
            List<List<Object>> data = new ArrayList<>();
            data.add(list);
            OutputStream outputStream = null;
            ExcelWriter writer = null;
            try {
                outputStream = new FileOutputStream(filePath2);
                writer = EasyExcelFactory.getWriter(outputStream);
                writer.write1(data, sheet2);
            } catch (FileNotFoundException e) {
                log.error("找不到文件或文件路径错误, 文件：{}", filePath2);
            }finally {
                try {
                    if(writer != null){
                        writer.finish();
                    }
                    if(outputStream != null){
                        outputStream.close();
                    }
                } catch (IOException e) {
                    log.error("excel文件导出失败, 失败原因：{}", e);
                }
            }



        } catch (FileNotFoundException e) {
            log.info("找不到文件或文件路径错误, 文件：{}", filePath);
        } finally {
            try {
                if(fileStream != null){
                    fileStream.close();
                }
            } catch (IOException e) {
                log.info("excel文件读取失败, 失败原因：{}", e);
            }
        }
    }

    @Test
    void test2() {
        String filePath = "C:\\Users\\111\\Desktop\\公司电脑桌面\\账号列表 20191028.xlsx";
        Sheet sheet = new Sheet(2);
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList("111","222","333"));
        data.add(Arrays.asList("111","222","333"));
        data.add(Arrays.asList("111","222","333"));
        List<String> head = Arrays.asList("表头1", "表头2", "表头3");
        if(head != null){
            List<List<String>> list = new ArrayList<>();
            head.forEach(h -> list.add(Collections.singletonList(h)));
            sheet.setHead(list);
        }

        OutputStream outputStream = null;
        ExcelWriter writer = null;
        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            writer.write1(data, sheet);
        } catch (FileNotFoundException e) {
            log.error("找不到文件或文件路径错误, 文件：{}", filePath);
        }finally {
            try {
                if(writer != null){
                    writer.finish();
                }

                if(outputStream != null){
                    outputStream.close();
                }

            } catch (IOException e) {
                log.error("excel文件导出失败, 失败原因：{}", e);
            }
        }
    }

    @Test
    void test3() {
        String filePath = "C:\\Users\\111\\Desktop\\公司电脑桌面\\账号列表 20191028.xlsx";
        List<Object> list = ExcelUtil.read(filePath);
        for (Object o: list) {
            System.out.println(o);
        }
        String filePath1 = "C:\\Users\\111\\Desktop\\公司电脑桌面\\账号列表 201910291.xlsx";
        List<List<Object>> data = new ArrayList<>();
        data.add(list);
        List<String> head = (List<String>) list.get(0);
        ExcelUtil.write(filePath1, data, head);
    }

    @Test
    void test4() {
        String filePath = "C:\\Users\\111\\Desktop\\公司电脑桌面\\账号列表 20191028.xlsx";
        Sheet sheet = new Sheet(1, 1);
        List<Object> list = ExcelUtil.readBySheet(filePath, sheet);
        for (Object o: list) {
            System.out.println(o);
        }
        String filePath1 = "C:\\Users\\111\\Desktop\\公司电脑桌面\\账号列表 201910292.xlsx";
        List<List<Object>> data = new ArrayList<>();
        data.add(list);
        ExcelUtil.writeWithSheet(filePath1, data, null, sheet);
    }

}