/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.edison.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.builditbigger.java.NoJokes;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.builditbigger.edison.com",
    ownerName = "backend.builditbigger.edison.com",
    packagePath=""
  )
)
public class MyEndpoint {

    @ApiMethod(name = "tellAJoke")
    public MyBean tellAJoke() {
        NoJokes noJokes = new NoJokes();
        MyBean response = new MyBean();
        response.setData(noJokes.tellAJoke());
        return response;
    }

}
