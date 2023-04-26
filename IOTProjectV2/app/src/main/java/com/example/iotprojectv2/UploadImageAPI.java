package com.example.iotprojectv2;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UploadImageAPI {
    @Multipart
    @POST("/")
    Call<String> uploadImage(@Part MultipartBody.Part part);
}
