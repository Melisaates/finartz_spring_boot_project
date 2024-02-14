package com.finartz.firebase.springfirebaseproject.controller;
import com.finartz.firebase.springfirebaseproject.entity.RssEntity;
import com.finartz.firebase.springfirebaseproject.service.impl.RssService;
import com.finartz.firebase.springfirebaseproject.service.inf.IRssService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/rss")
public class RssController {
    private final IRssService rssService;

    public RssController(IRssService rssService) {
        this.rssService = rssService;
    }


    @GetMapping("/fetchAndSave")
    public String fetchAndSaveRssItems() {
        rssService.fetchAndSaveRssItems();
        return "RSS items fetched and saved to database.";
    }

    @GetMapping("/getAll")
    public List<RssEntity> getAllRssItems() {
        return rssService.getAllRssItems();
    }
}
