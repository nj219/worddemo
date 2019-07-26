package com.example.worddemo.controller;

import com.example.worddemo.domain.WordDocDto;
import com.example.worddemo.map.WordDocDao;
import com.example.worddemo.test.Word2Html;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * @ClassName WordDocController
 * @Author shangpinyuan06
 * @Date 2019/7/25 13:15
 **/
@Controller
@RequestMapping("test")
public class WordDocController {
    @Autowired
    private WordDocDao wordDocDao;

    @Value("${uploadUrl}")
    String url;

    @Autowired
    private Word2Html wordHtml;

    @GetMapping("wordDoc")
    @ResponseBody
    public void wordDocTest(String word) {
        String u = null;
        try {
            List<WordDocDto> all = wordDocDao.findByfileName("111");
            for (WordDocDto wordDocDto : all) {
                String name = wordDocDto.getName();

                u = url + name;


                URL urlurl = new URL(u);
                InputStream bufferedInputStream = new BufferedInputStream(urlurl.openStream());


                //Word2Html.convert2Html(bufferedInputStream, System.currentTimeMillis()+".html");


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
