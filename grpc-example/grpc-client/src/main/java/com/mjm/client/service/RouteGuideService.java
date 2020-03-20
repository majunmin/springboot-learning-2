package com.mjm.client.service;

import io.grpc.examples.routeguide.Point;

/**
 * Created by majunmin on 2018/11/28.
 */
public interface RouteGuideService {

    Point sendServerData(Point point);
}
