package com.mjm.dyttspider;

import com.mjm.dyttspider.dao.MovieDetailRepository;
import com.mjm.dyttspider.model.entity.MovieDetail;
import com.mjm.dyttspider.model.vo.PageVo;
import com.mjm.dyttspider.utils.Constants;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DyttSpiderApplicationTests {

    @Autowired
    private MovieDetailRepository movieDetailRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
       List<String> urls = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            for (int j = 1; i <= 10; i++) {
               urls.add("http://www.ygdy8.net/html/gndy/oumei/list_" + i + "_" + (j) + ".html");
            }
        }

        String[] params = new String[urls.size()];
        urls.toArray(params);


        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls(params)
                .setWhiteUrlRegexs("http://www\\.ygdy8\\.net/html/gndy/dyzz/\\d+/\\d+.html")
                .setThreadCount(8)
                .setPageParser(new PageParser<PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, PageVo pageVo) {
                        // 解析封装 PageVo 对象
                        try {
                            String pageUrl = html.baseUri();
//                            System.out.println(pageUrl + ":" + pageVo.toString());
                            String[] contents = pageVo.getContent().split("◎");

                            MovieDetail movieDetail = new MovieDetail();

                            Arrays.stream(contents).forEach(content -> {
                                if (StringUtils.isNotBlank(content)) {
                                    content = content.replaceAll("　| ", " ");
                                    if (StringUtils.startsWith(content, Constants.TITLE_PREFIX)) {
                                        movieDetail.setTitle(StringUtils.trimToEmpty(content.substring(Constants.TITLE_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.TITLE_TRANS_PREFIX)) {
                                        movieDetail.setZhTitle(StringUtils.trimToEmpty(content.substring(Constants.TITLE_TRANS_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.DESC_PREFIX)) {
                                        System.out.println(content.substring(Constants.DESC_PREFIX.length()));

                                        String res = content.substring(Constants.DESC_PREFIX.length()).replace("【下载地址】 磁力链下载点击这里", "");
                                        movieDetail.setDescription(StringUtils.trimToEmpty(res));
                                    }
                                    if (StringUtils.startsWith(content, Constants.YEAR_PREFIX)) {
                                        String year = content.substring(Constants.YEAR_PREFIX.length());
                                        movieDetail.setYear(Integer.valueOf(StringUtils.trimToEmpty(year)));
                                    }
                                    if (StringUtils.startsWith(content, Constants.REGION_PREFIX)) {
                                        movieDetail.setRegion(StringUtils.trimToEmpty(content.substring(Constants.REGION_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.CATEGORY_PREFIX)) {
                                        movieDetail.setCategory(StringUtils.trimToEmpty(content.substring(Constants.CATEGORY_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.LANGUAGE_PREFIX)) {
                                        movieDetail.setLanguage(StringUtils.trimToEmpty(content.substring(Constants.LANGUAGE_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.SUB_TITLE_PREFIX)) {
                                        movieDetail.setSubtitle(StringUtils.trimToEmpty(content.substring(Constants.SUB_TITLE_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.RELEASE_DATE_PREFIX)) {
                                        movieDetail.setReleaseDate(StringUtils.trimToEmpty(content.substring(Constants.RELEASE_DATE_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.IMDB_PREFIX)) {
                                        movieDetail.setImdbScore(StringUtils.trimToEmpty(content.substring(Constants.IMDB_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.DOUBAN_PREFIX)) {
                                        movieDetail.setDoubanScore(StringUtils.trimToEmpty(content.substring(Constants.DOUBAN_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.FILE_FORMAT_PREFIX)) {
                                        movieDetail.setFileFormat(StringUtils.trimToEmpty(content.substring(Constants.FILE_FORMAT_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.VIDEO_SIZE_PREFIX)) {
                                        movieDetail.setVideoSize(StringUtils.trimToEmpty(content.substring(Constants.VIDEO_SIZE_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.FILE_SIZE_PREFIX)) {
                                        movieDetail.setFileSize(StringUtils.trimToEmpty(content.substring(Constants.FILE_SIZE_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.TIME_LENGTH_PREFIX)) {
                                        movieDetail.setTimeLength(StringUtils.trimToEmpty(content.substring(Constants.TIME_LENGTH_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.DIRECTOR_PREFIX)) {
                                        movieDetail.setDirector(StringUtils.trimToEmpty(content.substring(Constants.DIRECTOR_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.SCENARIST_PREFIX)) {
                                        movieDetail.setScenarist(StringUtils.trimToEmpty(content.substring(Constants.SCENARIST_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.STAR_PREFIX)) {
                                        movieDetail.setStarring(StringUtils.trimToEmpty(content.substring(Constants.STAR_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.TAG_PREFIX)) {
                                        movieDetail.setTag(StringUtils.trimToEmpty(content.substring(Constants.TAG_PREFIX.length())));
                                    }
                                    if (StringUtils.startsWith(content, Constants.AWARDS_PREFIX)) {
                                        movieDetail.setAwards(StringUtils.trimToEmpty(content.substring(Constants.AWARDS_PREFIX.length())));
                                    }
                                }
                                movieDetail.setFtpLink(pageVo.getFtpLink());
                                movieDetail.setDetailUrl(html.baseUri());
                                movieDetail.setPosterUrl(pageVo.getPosterUrl());

                                movieDetailRepository.save(movieDetail);
                            });
                        } catch (Exception ex){}


                    }
                })
                .build();

        crawler.start(true);
    }

    @Test
    public void test2(){
        System.out.println(StringUtils.trimToEmpty("   2018"));
    }

}
