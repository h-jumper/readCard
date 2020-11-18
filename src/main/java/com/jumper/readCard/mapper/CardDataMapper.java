package com.jumper.readCard.mapper;

import com.jumper.readCard.pojo.CardData;
import com.jumper.readCard.pojo.DateData;
import com.jumper.readCard.pojo.SimpleCardData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface CardDataMapper {

    public int insertCardData(CardData cardData);

    public List<SimpleCardData> selectCardDataByTime(String begin,String end);

    public List<DateData> selectLastThreeTime(String cardNo, String begin, String end);

    public List<CardData> selectCardDataByTimeForXLS(String begin,String end);
}
