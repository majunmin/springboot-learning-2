package com.mjm.dyttspider.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by majunmin on 2018/12/6.
 */
@Table(name = "m_detail")
@Entity
@Data
@NoArgsConstructor
public class MovieDetail {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    /**
     * 译名
     */
    private String zhTitle;

    /**
     * 所在网页
     */
    private String detailUrl;

    /**
     * 片名
     */
    private String title;

    /**
     * 简介
     */
    private String description;

    /**
     * 年代
     */
    private Integer year;

    /**
     * 地区
     */
    private String region;

    /**
     * 类别
     */
    private String category;

    /**
     * 语言
     */
    private String language;

    /**
     * 副标题
     */
    private String subtitle;

    /**
     * 上映日期
     */
    private String releaseDate;

    /**
     * 豆瓣评分
     */
    private String doubanScore;

    /**
     * IMDb评分
     */
     private String imdbScore;

    /**
     * 标签
     */
    private String tag;

    /**
     * 文件格式
     */
    private String fileFormat;

    /**
     * 视频尺寸
     */
    private String VideoSize;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 片长
     */
    private String timeLength;

    /**
     * 导演
     */
    private String director;

    /**
     * 导演
     */
    private String scenarist;

    /**
     * 主演
     */
    private String starring;

    /**
     * 海报
     */
    private String posterUrl;

    /**
     * 获奖情况
     */
    private String awards;


    /**
     * ftp下载链接
     */
    @Column(nullable = false)
    private String ftpLink;
}
