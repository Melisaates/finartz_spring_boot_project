package com.finartz.firebase.springfirebaseproject.service.inf;

import com.finartz.firebase.springfirebaseproject.entity.RssEntity;

import java.util.List;

public interface IRssService {

    public void fetchAndSaveRssItems() ;
        // RSS feed'den veri çekme ve kaydetme işlemleri burada gerçekleştirilecek


    public List<RssEntity> getAllRssItems();
}
