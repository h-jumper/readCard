package com.jumper.readCard.service;

import com.jumper.readCard.pojo.CardData;
import com.jumper.readCard.pojo.DateData;
import com.jumper.readCard.pojo.SimpleCardData;

import java.util.List;

public interface CardDataService {

    public int insertCardData(CardData cardData);

    public List<SimpleCardData> selectCardDataByTime(String begin,String end);

    public List<DateData> selectLastThreeTime(String cardNo, String begin, String end);
}
