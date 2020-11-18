package com.jumper.readCard.controller;

import com.jumper.readCard.pojo.CardData;
import com.jumper.readCard.pojo.User;
import com.jumper.readCard.service.CardDataService;
import com.jumper.readCard.utils.ImageTools;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DownloadController {

    @Autowired
    CardDataService cardDataService;

    @RequestMapping("/upFile")
    public void upFile(HttpServletResponse response,String begin,String end,String check) throws IOException {
        if("true".equals(check)) {
            SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd 00:00");
            SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd 23:59");
            Date date=new Date();
            begin=sdf1.format(date);
            end=sdf2.format(date);
        }
        List<CardData> cardDataList = cardDataService.selectCardDataByTimeForXLS(begin, end);


        // 创建一个工作薄
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建一个sheet
        HSSFSheet sheet = wb.createSheet("sheet1");
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        String[] excelHeader = {"名字","性别","民族","记录时间","该时间段访问次数","出生日期","家庭地址","身份证号","签发机关","开始期限","结束期限","设备号","照片"};
        for (int i = 0; i < excelHeader.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(excelHeader[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
            //设置列宽
            sheet.setColumnWidth(i, 256*20);
        }

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < cardDataList.size(); i++) {
            row = sheet.createRow(i + 1);
            row.setHeight((short) (35.7*27));
            CardData cardData = cardDataList.get(i);
            //设置样式 每列都是水平垂直居中
            HSSFCell cell1 = row.createCell(0);
            HSSFCell cell2 = row.createCell(1);
            HSSFCell cell3 = row.createCell(2);
            HSSFCell cell4 = row.createCell(3);
            HSSFCell cell5 = row.createCell(4);
            HSSFCell cell6 = row.createCell(5);
            HSSFCell cell7 = row.createCell(6);
            HSSFCell cell8 = row.createCell(7);
            HSSFCell cell9 = row.createCell(8);
            HSSFCell cell10 = row.createCell(9);
            HSSFCell cell11 = row.createCell(10);
            HSSFCell cell12 = row.createCell(11);

            cell1.setCellValue(cardData.getName());
            cell2.setCellValue(cardData.getSex());
            cell3.setCellValue(cardData.getNation());
            cell4.setCellValue(sdf.format(cardData.getDate()));
            cell5.setCellValue(cardData.getCountNum());
            cell6.setCellValue(cardData.getBorn());
            cell7.setCellValue(cardData.getAddress());
            cell8.setCellValue(cardData.getCardNo());
            cell9.setCellValue(cardData.getPolice());
            cell10.setCellValue(cardData.getActivityLFrom());
            cell11.setCellValue(cardData.getActivityLTo());
            cell12.setCellValue(cardData.getDeviceNo());

            cell1.setCellStyle(style);
            cell2.setCellStyle(style);
            cell3.setCellStyle(style);
            cell4.setCellStyle(style);
            cell5.setCellStyle(style);
            cell6.setCellStyle(style);
            cell7.setCellStyle(style);
            cell8.setCellStyle(style);
            cell9.setCellStyle(style);
            cell10.setCellStyle(style);
            cell11.setCellStyle(style);
            cell12.setCellStyle(style);

            /**
             * 该构造函数有8个参数
             * 前四个参数是控制图片在单元格的位置，分别是图片距离单元格left，top，right，bottom的像素距离
             * 后四个参数，前连个表示图片左上角所在的cellNum和 rowNum，后天个参数对应的表示图片右下角所在的cellNum和 rowNum，
             * excel中的cellNum和rowNum的index都是从0开始的
             */
            if (cardData.getPhotoBuffer()==null){
                continue;
            }
            cardData.setBytes(ImageTools.Base64ToByte(cardData.getPhotoBuffer()));
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) 12, (i + 1), (short) 13, (i+2));
            anchor.setAnchorType(ClientAnchor.MOVE_DONT_RESIZE);
            // 插入图片
            patriarch.createPicture(anchor, wb.addPicture(cardData.getBytes(), HSSFWorkbook.PICTURE_TYPE_JPEG)).resize(0.5);
        }
        response.setContentType("application/vnd.ms-excel");
        //设置文件名称
        response.setHeader("Content-disposition", "attachment;filename="+begin+"-"+end+".xls");
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
        //try catch这些关闭流略
    }

}
