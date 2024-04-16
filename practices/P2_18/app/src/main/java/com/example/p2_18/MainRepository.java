package com.example.p2_18;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository implements MainContract.MainRepository{
    @Override
    public void loadStudentInfo(String name, String group, OnStudentInfoLoaded sil) {
        StdApp.getServerApi().getStudentInfo(name, group).enqueue(new Callback<StudentInfoResponse>() {
            @Override
            public void onResponse(Call<StudentInfoResponse> call, Response<StudentInfoResponse> response) {
                StudentInfoResponse studentInfoResponse = response.body();
                if (studentInfoResponse != null){
                    int rezCode = studentInfoResponse.getResultCode();
                    if(rezCode == 1){
                        sil.onSuccessLoad(studentInfoResponse.getMessageText(), studentInfoResponse.getAvatar());
                    }else if(rezCode == 0){
                        sil.onFailed(studentInfoResponse.getMessageText());
                    }else {
                        sil.onFailed("Unknown result code");
                    }
                }else{
                    sil.onFailed("Empty server response");
                }
            }

            @Override
            public void onFailure(Call<StudentInfoResponse> call, Throwable t) {
                sil.onFailed(t.getMessage());
            }
        });
    }

}
