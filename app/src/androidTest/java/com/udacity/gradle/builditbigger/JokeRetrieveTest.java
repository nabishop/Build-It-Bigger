package com.udacity.gradle.builditbigger;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.CountDownLatch;

@RunWith(JUnit4.class)
public class JokeRetrieveTest {
    @Test
    public void testJokeLoading() {
        final CountDownLatch signal = new CountDownLatch(1);
        new EndpointsAsyncTask(new EndpointsAsyncTask.JokeCaller() {
            @Override
            public void jokeReady(String joke) {
                if (joke == null || joke.isEmpty()) {
                    Assert.fail();
                }
                signal.countDown();
            }
        }).execute();
        try {
            signal.await();
        } catch (InterruptedException e) {
            Assert.fail();
            e.printStackTrace();
        }
    }
}
