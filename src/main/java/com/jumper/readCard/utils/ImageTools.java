package com.jumper.readCard.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageTools {

    public static String ImageToBase64(String imgPath) {
        InputStream in=null;
        byte[] data=null;
        try{
            in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    public static boolean Base64ToImage(String base64, String imgFilePath) {
        // 对字节数组字符串进行Base64解码并生成图片
        if (base64 == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(base64);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static byte[] Base64ToByte(String base64) throws IOException {
        File newFile = File.createTempFile(System.currentTimeMillis()+"","png");
        ImageTools.Base64ToImage(base64,newFile.getPath());
        BufferedImage bufferImg ;//图片一
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        bufferImg = ImageIO.read(newFile);
        ImageIO.write(bufferImg, "png", byteArrayOut);
        return byteArrayOut.toByteArray();
    }
}
