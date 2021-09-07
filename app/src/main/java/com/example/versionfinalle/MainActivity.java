package com.example.versionfinalle;

import com.google.android.libraries.places.api.Places;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static final String THEME_RES_ID_EXTRA = "widget_theme";

    private Spinner widgetThemeSpinner;

    Button btn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.current_place_button);

        //Initialize places
        String apiKey = BuildConfig.API_KEY;

        if (apiKey.equals("")) {
            Toast.makeText(this, getString(R.string.error_api_key), Toast.LENGTH_LONG).show();
            return;
        }

        // Setup Places Client
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), apiKey);
        }

        btn.setOnClickListener((View.OnClickListener) this);
    }
}


