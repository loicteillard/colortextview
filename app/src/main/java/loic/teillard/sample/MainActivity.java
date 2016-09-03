package loic.teillard.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import loic.teillard.colortextview.ColorTextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup layout = (ViewGroup) findViewById(R.id.layout);

        ColorTextView colorTextView = new ColorTextView(this);

        colorTextView.addTextColor("Lorem ipsum dolor sit amet, consectetur", Color.DKGRAY);
        colorTextView.addTextColor("adipiscing elit, sed do eiusmod tempor incididunt", Color.RED);
        colorTextView.addTextColor("incididunt ut labore et dolore magna aliqua.", Color.GREEN);

        colorTextView.setSpaces(true);

        colorTextView.apply();

        layout.addView(colorTextView);

        // -------------------------

        ColorTextView colorTextViewRes = new ColorTextView(this);

        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) colorTextView.getLayoutParams();
        mlp.topMargin = getResources().getDimensionPixelSize(R.dimen.margin_top);
        colorTextViewRes.setLayoutParams(mlp);

        colorTextViewRes.addTextColorRes(R.string.lorem, R.color.md_deep_orange_A200);
        colorTextViewRes.addTextColorRes(R.string.adipiscing, R.color.md_blue_600);
        colorTextViewRes.addTextColorRes(R.string.incididunt, R.color.md_brown_500);

        colorTextViewRes.setSpaces(true);

        colorTextViewRes.apply();

        layout.addView(colorTextViewRes);
    }
}
