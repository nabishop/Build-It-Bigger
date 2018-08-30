package com.example.android.jokeproviderandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        TextView jokeText = findViewById(R.id.joke_text_view);

        if (getIntent().hasExtra(getString(R.string.joke_extra_displayer))) {
            jokeText.setText(getIntent().getStringExtra(getString(R.string.joke_extra_displayer)));
        } else {
            jokeText.setText(getString(R.string.no_joke_available));
        }
    }
}
