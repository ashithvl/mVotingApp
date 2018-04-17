package com.blueangels.Api;

import com.blueangels.Model.Candidate;
import com.blueangels.Model.CandidateDetail;
import com.blueangels.Model.Election;
import com.blueangels.Model.User;
import com.blueangels.Model.Vote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Leon on 19-12-17.
 */

public interface ApiService {

    @POST("user/login")
    Call<User> login(@Body User user);

    @POST("user/register")
    Call<User> register(@Body User user);

    @GET("user/getCurrentElections")
    Call<List<Election>> getCurrentElections();

    @GET("user/getPreviousElections")
    Call<List<Election>> getPreviousElections();

    @GET("user/candidatesList/{electionId}")
    Call<List<Candidate>> getCandidatesList(@Path("electionId") String electionId);

    @POST("user/getCandidateVote/{userId}/{electionId}/{candidateId}")
    Call<CandidateDetail> getCandidateVote(@Path("userId") String userId,
                                           @Path("electionId") String electionId, @Path("candidateId") String candidateId);

    @POST("user/vote/{userId}/{electionId}/{candidateId}")
    Call<Vote> vote(@Path("userId") String userId,
                    @Path("electionId") String electionId, @Path("candidateId") String candidateId);

}
