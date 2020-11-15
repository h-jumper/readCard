package com.jumper.readCard.controller;

import com.jumper.readCard.pojo.CardData;
import com.jumper.readCard.pojo.DateData;
import com.jumper.readCard.pojo.Go;
import com.jumper.readCard.pojo.SimpleCardData;
import com.jumper.readCard.service.CardDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    CardDataService cardDataService;

    @RequestMapping("/postCardData")
    public Go postCardData(@RequestBody CardData cardData){
        Date date=new Date();
        String begin;
        String end;
        if(cardData.getCheck()==null) {
            begin = cardData.getBegin();
            end = cardData.getEnd();
        }else{
            //今日
            SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd 00:00");
            SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd 23:59");
            begin=sdf1.format(date);
            end=sdf2.format(date);
        }
        List<DateData> dateData = cardDataService.selectLastThreeTime(cardData.getCardNo(), begin, end);
        Go go = new Go();
        if(dateData.size()==0){
            go.setMark("true");
            go.setDateData(dateData);
            cardDataService.insertCardData(cardData);
            return go;
        }else if(date.getTime()-dateData.get(0).getDate().getTime()<60000){
            return null;
        }else{
            go.setMark("false");
            go.setDateData(dateData);
            cardDataService.insertCardData(cardData);
            return go;
        }
    }

    @RequestMapping("/cardDataByTime")
    public List<SimpleCardData> cardDataByTime(String begin,String end,String check){
        if(check==null) {
            return cardDataService.selectCardDataByTime(begin, end);
        }else{
            SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd 00:00");
            SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd 23:59");
            Date date=new Date();
            String begin2=sdf1.format(date);
            String end2=sdf2.format(date);
            return cardDataService.selectCardDataByTime(begin2,end2);
        }
    }

    @RequestMapping("/download")
    public void downloadFile(HttpServletResponse response) throws IOException {
        try {
            Resource resource = new ClassPathResource("data/1.xls");
            File file = resource.getFile();
            String filename = resource.getFilename();
            InputStream inputStream = new FileInputStream(file);
            //强制下载不打开
            response.setContentType("application/force-download");
            OutputStream out = response.getOutputStream();
            //使用URLEncoder来防止文件名乱码或者读取错误
            response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(filename, "UTF-8"));
            int b = 0;
            byte[] buffer = new byte[1000000];
            while (b != -1) {
                b = inputStream.read(buffer);
                if(b!=-1) out.write(buffer, 0, b);
            }
            inputStream.close();
            out.close();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
