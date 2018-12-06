package com.mjm.dyttspider.dao;

import com.mjm.dyttspider.model.entity.MovieDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by majunmin on 2018/12/6.
 */
public interface MovieDetailRepository extends JpaRepository<MovieDetail, Integer> {
}
