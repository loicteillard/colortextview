package loic.teillard.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import java.util.LinkedHashMap;

import loic.teillard.colortextview.ColorTextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup layout = (ViewGroup) findViewById(R.id.layout);

        ColorTextView colorTextView = new ColorTextView(this);

        LinkedHashMap<String,Integer> stringcolors = new LinkedHashMap<>();
        stringcolors.put("Lorem ipsum dolor sit amet, consectetur", R.color.md_deep_orange_A200);
        stringcolors.put("adipiscing elit, sed do eiusmod tempor incididunt",R.color.md_blue_600);
        stringcolors.put("incididunt ut labore et dolore magna aliqua.",R.color.md_brown_500);

        colorTextView.setSpaces(true);

        colorTextView.apply(stringcolors);

        layout.addView(colorTextView);
    }
}
