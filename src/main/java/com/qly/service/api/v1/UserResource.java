package com.qly.service.api.v1;

import com.google.inject.Inject;
import com.qly.dao.IUserDao;
import com.qly.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by Fanyi on 15/10/2.
 */
@Path("/api/v1/user")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class UserResource {

    @Inject
    private IUserDao userDao;


    @GET
    public User getUserById(@QueryParam("id")String userId) {
        System.out.println("resource get called with userId: " + userId);
        System.out.println("userId: " + userId);

        System.out.println("this.userDao class:  " + this.userDao);

        return this.userDao.getUserById(Long.valueOf(userId));
    }
}
