package com.jumper.readCard.service.Impl;

import com.jumper.readCard.mapper.CardDataMapper;
import com.jumper.readCard.pojo.CardData;
import com.jumper.readCard.pojo.DateData;
import com.jumper.readCard.pojo.SimpleCardData;
import com.jumper.readCard.service.CardDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardDataServiceImpl implements CardDataService {

    @Autowired
    CardDataMapper cardDataMapper;

    @Override
    public int insertCardData(CardData cardData) {
        return cardDataMapper.insertCardData(cardData);
    }

    @Override
    public List<SimpleCardData> selectCardDataByTime(String begin, String end) {
        return cardDataMapper.selectCardDataByTime(begin,end);
    }

    @Override
    public List<DateData> selectLastThreeTime(String cardNo, String begin, String end) {
        return cardDataMapper.selectLastThreeTime(cardNo, begin, end);
    }
}
