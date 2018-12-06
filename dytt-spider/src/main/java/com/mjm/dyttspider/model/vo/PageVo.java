package com.mjm.dyttspider.model.vo;

import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;
import com.xuxueli.crawler.conf.XxlCrawlerConf;
import lombok.Data;

// PageSelect 注解：从页面中抽取出一个或多个VO对象；
@PageSelect(cssQuery = "#header > div > div.bd2 > div.bd3 > div.bd3r > div.co_area2")
@Data
public class PageVo {


    @PageFieldSelect(cssQuery = "#Zoom > span > p:nth-child(1)", selectType = XxlCrawlerConf.SelectType.TEXT)
    private String content;

    /**
     * 海报
     */
    @PageFieldSelect(cssQuery = "#Zoom > span > p:nth-child(1) > img:first-of-type",
            selectType = XxlCrawlerConf.SelectType.ATTR, selectVal = "abs:src")
    private String posterUrl;

    /**
     * ftp下载链接
     */
    @PageFieldSelect(cssQuery = "#Zoom > span > table > tbody > tr > td > a",
            selectType = XxlCrawlerConf.SelectType.TEXT)
    private String ftpLink;

}