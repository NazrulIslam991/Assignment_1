package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class National_Symbols extends AppCompatActivity {

    private String[] titles;
    private String[] descriptions;
    private int[] images;

    private int currentIndex = 0;

    private TextView titleTextView;
    private TextView descriptionTextView;
    private ImageView symbolImageView;
    private Button nextButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_symbols);

        getWindow().setStatusBarColor(ContextCompat.getColor(National_Symbols.this, R.color.Home));


        titles = new String[]{
                getString(R.string.flag_title),
                getString(R.string.emblem_title),
                getString(R.string.seal_title),
                getString(R.string.poet_title),
                getString(R.string.flower_title),
                getString(R.string.bird_title),
                getString(R.string.animal_title),
                getString(R.string.fruit_title),
                getString(R.string.fish_title),
        };

        descriptions = new String[]{
                getString(R.string.flag),
                getString(R.string.Emblemz),
                getString(R.string.seal),
                getString(R.string.poet),
                getString(R.string.flower),
                getString(R.string.bird),
                getString(R.string.animal),
                getString(R.string.fruit),
                getString(R.string.fish),
        };

        images = new int[]{
                R.drawable.flag,
                R.drawable.emblem,
                R.drawable.seal,
                R.drawable.poet,
                R.drawable.flower,
                R.drawable.bird,
                R.drawable.tiger,
                R.drawable.fruits,
                R.drawable.fissh,
        };

        titleTextView = findViewById(R.id.title);
        descriptionTextView = findViewById(R.id.description);
        symbolImageView = findViewById(R.id.symbol);
        nextButton = findViewById(R.id.next);
        backButton = findViewById(R.id.back);

        updateContent();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(National_Symbols.this,"Next Button is Clicked",Toast.LENGTH_SHORT).show();

                currentIndex++;
                if (currentIndex >= titles.length) {
                    currentIndex = 0;
                }
                updateContent();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(National_Symbols.this,"Back Button is Clicked",Toast.LENGTH_SHORT).show();

                currentIndex--;
                if (currentIndex < 0) {
                    currentIndex = titles.length - 1;
                }
                updateContent();
            }
        });
    }

    private void updateContent() {
        titleTextView.setText(titles[currentIndex]);
        descriptionTextView.setText(descriptions[currentIndex]);
        symbolImageView.setImageResource(images[currentIndex]);
    }
}
