package com.laijiamei.member.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: excel导出工具类
 * @date 15:40 2019/10/28
 */
public class ExcelUtil {

    private static Logger log = LoggerFactory.getLogger(ExcelUtil.class);

    private static Sheet initSheet;

    static {
        // 第一个1代表sheet1, 第二个0代表从第几行开始读取数据，行号最小值为0
        initSheet = new Sheet(1, 0);
        initSheet.setSheetName("sheet");
        // 设置自适应宽度
        initSheet.setAutoWidth(Boolean.TRUE);
    }

    /**
     * description:<从默认的sheet读数据>
     * @author jiamei.lai（jiamei.lai@ucarinc.com）
     * @date 2019/10/28 16:03
     * @params [filePath] <绝对路径>
     * @return java.util.List<java.lang.Object> <返回值说明>
     */
    public static List<Object> read(String filePath) {
        return ExcelUtil.readBySheet(filePath, null);
    }

    /**
     * description:<从指定的sheet读数据>
     * @author jiamei.lai（jiamei.lai@ucarinc.com）
     * @date 2019/10/28 16:02
     * @params [filePath, sheet] <绝对路径, excel页面样式>
     * @return java.util.List<java.lang.Object> <返回值说明>
     */
    public static List<Object> readBySheet(String filePath, Sheet sheet) {
        // 判断sheet是否为空，为空则设为默认的sheet
        sheet = (sheet != null) ? sheet : initSheet;
        List<Object> list = null;
        InputStream fileStream = null;
        try {
            fileStream = new FileInputStream(filePath);
            // 读出的List<Object>是全部数据都在一行的
            list =  EasyExcelFactory.read(fileStream, sheet);
//            ExcelListener excelListener = new ExcelListener();
//            ExcelReader reader = new ExcelReader(fileStream, null, excelListener, false);
//            reader.read(sheet);
//            list = excelListener.getDatas();
        } catch (FileNotFoundException e) {
            log.info("找不到文件或文件路径错误, 文件：{}", filePath);
        } finally {
            try {
                if(fileStream != null){
                    fileStream.close();
                }
            } catch (IOException e) {
                log.info("excel文件读取失败, 失败原因：{}", e.getMessage());
            }
        }
        return list;
    }

    /**
     * description:<在默认的sheet写数据>
     * @author jiamei.lai（jiamei.lai@ucarinc.com）
     * @date 2019/10/28 16:02
     * @params [filePath, data, head] <绝对路径, 数据源, 表头>
     * @return void <返回值说明>
     */
    public static void write(String filePath, List<List<Object>> data, List<String> head) {
        ExcelUtil.writeWithSheet(filePath, data, head, null);
    }

    /**
     * description:<在指定的sheet写数据>
     * @author jiamei.lai（jiamei.lai@ucarinc.com）
     * @date 2019/10/28 16:00
     * @params [filePath, data, head, sheet] <绝对路径, 数据源, 表头, excel页面样式>
     * @return void <返回值说明>
     */
    public static void writeWithSheet(String filePath, List<List<Object>> data, List<String> head, Sheet sheet) {
        // 判断sheet是否为空，为空则设为默认的sheet
        sheet = (sheet != null) ? sheet : initSheet;
        // 判断head是否为空，不为空则设置sheet表头
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
                log.error("excel文件导出失败, 失败原因：{}", e.getMessage());
            }
        }
    }

}
