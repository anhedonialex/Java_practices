package com.example.p2_18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.p2_18.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainContract.MainView {
    private ActivityMainBinding binding;
    private MainContract.MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnInfo.setOnClickListener(this);
        presenter = new MainPresenter(this);
    }

    @Override
    public void onClick(View view) {
        String lastName = binding.etLastName.getText().toString();
        String group = binding.etGroup.getText().toString();
        presenter.onClickGetInfoButton(lastName, group);
    }

    @Override
    public void showLoading() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(int restId) {
        Toast.makeText(this, restId, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showStudentInfo(String text, String avaUrl) {
        binding.rlContent.setVisibility(View.VISIBLE);
        binding.tvInfo.setText(text);
        Picasso.get().load(avaUrl)
                .fit()
                .transform(new CircleTransform())
                .into(binding.ivAvatar);
    }
}