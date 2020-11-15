package com.jumper.readCard;


import com.jumper.readCard.mapper.CardDataMapper;
import com.jumper.readCard.pojo.CardData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class ReadCardApplicationTests {

    @Autowired
    CardDataMapper cardDataMapper;

    @Test
    void contextLoads() {

    }

}
