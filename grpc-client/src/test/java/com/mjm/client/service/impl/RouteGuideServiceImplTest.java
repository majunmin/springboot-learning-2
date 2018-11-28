package com.mjm.client.service.impl;

import com.mjm.client.GrpcClientApplication;
import com.mjm.client.config.UrlConfig;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.examples.routeguide.Feature;
import io.grpc.examples.routeguide.Point;
import io.grpc.examples.routeguide.Rectangle;
import io.grpc.examples.routeguide.RouteGuideGrpc;
import io.grpc.netty.NettyChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

/**
 * Created by majunmin on 2018/11/28.
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = GrpcClientApplication.class)
public class RouteGuideServiceImplTest {

    private ManagedChannel managedChannel;

    @Autowired
    private UrlConfig urlConfig;


    @Test
    public void test1(){
        managedChannel = NettyChannelBuilder
                .forAddress(urlConfig.getHost(), urlConfig.getPort())
                .usePlaintext()
                .build();

        RouteGuideGrpc.RouteGuideBlockingStub blockingStub = RouteGuideGrpc.newBlockingStub(managedChannel);
        Point point = Point.newBuilder().setLatitude(12)
                .setLongitude(13)
                .build();
        Feature feature = blockingStub.getFeature(point);
        System.out.println(feature);


        Rectangle request =
                Rectangle.newBuilder()
                        .setLo(Point.newBuilder().setLatitude(11).setLongitude(8).build())
                        .setHi(Point.newBuilder().setLatitude(19).setLongitude(88).build()).build();
        Iterator<Feature> features;
        try {
            features = blockingStub.listFeatures(request);
            for (int i = 1; features.hasNext(); i++) {
                Feature feature1 = features.next();
                log.info("Result #" + i + ": {0}", feature1);
            }
        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {0}", e.getStatus());
        }
    }
}