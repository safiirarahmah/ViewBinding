package com.example.viewbinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.viewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name = binding.editText.getText().toString();
               binding.text2.setText("Hi "+ name);
            }
        });

        binding.textView.setText("Welcome!!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.setting){
            startActivity(new Intent(this, SettingActivity.class));
        }else if (item.getItemId() == R.id.archive){
            startActivity(new Intent(this, ArchiveActivity.class));
        }else if (item.getItemId() == R.id.cf){
            startActivity(new Intent(this, CloseFriendsActivity.class));
        }
        return true;
    }


}