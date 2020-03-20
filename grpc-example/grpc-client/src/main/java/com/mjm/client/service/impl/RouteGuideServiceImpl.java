package com.mjm.client.service.impl;

import com.mjm.client.service.RouteGuideService;
import io.grpc.Channel;
import io.grpc.examples.routeguide.Feature;
import io.grpc.examples.routeguide.Point;
import io.grpc.examples.routeguide.RouteGuideGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;


/**
 * Created by majunmin on 2018/11/28.
 */
@Slf4j
@Service
public class RouteGuideServiceImpl implements RouteGuideService {

    @GrpcClient("grpc-server")
    private Channel channel;


    @Override
    public Point sendServerData(Point point) {
        RouteGuideGrpc.RouteGuideBlockingStub stub = RouteGuideGrpc.newBlockingStub(channel);
        Feature feature = stub.getFeature(Point.newBuilder(point).build());
        log.info("localtion: " + feature.getLocation());
        return feature.getLocation();
    }
}
