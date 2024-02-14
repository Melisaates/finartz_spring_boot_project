package com.finartz.firebase.springfirebaseproject.service.impl;

import com.finartz.firebase.springfirebaseproject.entity.RssEntity;
import com.finartz.firebase.springfirebaseproject.repository.RssRepo;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class RssService {


    private final RssRepo rssRepo;

    @Autowired
    public RssService(RssRepo rssRepo) {
        this.rssRepo = rssRepo;
    }

    public void fetchAndSaveRssItems() {
        try {
            URL feedUrl = new URL("https://www.ntv.com.tr/son-dakika.rss");
            SyndFeed syndFeed = new SyndFeedInput().build(new XmlReader(feedUrl));

            List<SyndEntry> entries = syndFeed.getEntries();
            for (SyndEntry entry : entries) {
                RssEntity rssEntity = new RssEntity();
                rssEntity.setTitle(entry.getTitle());
                rssEntity.setLink(entry.getLink());
                rssEntity.setDescription(entry.getDescription().getValue());
                rssRepo.save(rssEntity);
            }
        } catch (IOException | FeedException e) {
            e.printStackTrace();
        }
    }

    public List<RssEntity> getAllRssItems() {
        return rssRepo.findAll();
    }
}

