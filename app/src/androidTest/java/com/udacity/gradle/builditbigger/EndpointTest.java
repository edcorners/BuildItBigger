package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;

import org.mockito.Mock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Edison on 5/17/2016.
 */
public class EndpointTest extends AndroidTestCase implements EndpointsAsyncTask.Listener{

    @Mock Context context;
    CountDownLatch countDownLatch = new CountDownLatch(1);;
    String mJoke;

    public EndpointTest() {
    }

    public void testAsyncTask() throws InterruptedException {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(),this);
        endpointsAsyncTask.execute();
        countDownLatch.await(2, TimeUnit.SECONDS);
        assertNotNull(mJoke);
        assertTrue(mJoke.length() > 0);
        System.out.print(mJoke);
    }

    @Override
    public void onTaskComplete(String joke) {
        mJoke = joke;
        countDownLatch.countDown();
    }
}
