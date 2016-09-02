package loic.teillard.colortextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by loic on 31/08/2016.
 */
public class ColorTextView extends AppCompatTextView {

    private LinkedHashMap<String, Integer> mTxtColors;
    private boolean mSpaces;

    public ColorTextView(Context context) {
        super(context);
    }

    public ColorTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup(attrs);
    }

    public ColorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(attrs);
    }

    public void setup(AttributeSet attrs) {
        TypedArray attrsArray = getContext().obtainStyledAttributes(attrs, R.styleable.ColorTextViewAttrs, 0, 0);
        initAttributesArray(attrsArray);
        attrsArray.recycle();

        setColorWords();
    }

    public void setSpaces(boolean spaces) {
        this.mSpaces = spaces;
    }

    public boolean isSpaces() {
        return mSpaces;
    }

    private void initAttributesArray(TypedArray attrsArray) {

        if (attrsArray == null) return;

        String txt1 = attrsArray.getString(R.styleable.ColorTextViewAttrs_clt_txt1);
        int color1 = attrsArray.getColor(R.styleable.ColorTextViewAttrs_clt_color1, Color.BLACK);

        String txt2 = attrsArray.getString(R.styleable.ColorTextViewAttrs_clt_txt2);
        int color2 = attrsArray.getColor(R.styleable.ColorTextViewAttrs_clt_color2, Color.BLACK);

        String txt3 = attrsArray.getString(R.styleable.ColorTextViewAttrs_clt_txt3);
        int color3 = attrsArray.getColor(R.styleable.ColorTextViewAttrs_clt_color3, Color.BLACK);

        String txt4 = attrsArray.getString(R.styleable.ColorTextViewAttrs_clt_txt4);
        int color4 = attrsArray.getColor(R.styleable.ColorTextViewAttrs_clt_color4, Color.BLACK);

        String txt5 = attrsArray.getString(R.styleable.ColorTextViewAttrs_clt_txt5);
        int color5 = attrsArray.getColor(R.styleable.ColorTextViewAttrs_clt_color5, Color.BLACK);

        String txt6 = attrsArray.getString(R.styleable.ColorTextViewAttrs_clt_txt6);
        int color6 = attrsArray.getColor(R.styleable.ColorTextViewAttrs_clt_color6, Color.BLACK);

        String txt7 = attrsArray.getString(R.styleable.ColorTextViewAttrs_clt_txt7);
        int color7 = attrsArray.getColor(R.styleable.ColorTextViewAttrs_clt_color7, Color.BLACK);

        String txt8 = attrsArray.getString(R.styleable.ColorTextViewAttrs_clt_txt8);
        int color8 = attrsArray.getColor(R.styleable.ColorTextViewAttrs_clt_color8, Color.BLACK);

        String txt9 = attrsArray.getString(R.styleable.ColorTextViewAttrs_clt_txt9);
        int color9 = attrsArray.getColor(R.styleable.ColorTextViewAttrs_clt_color9, Color.BLACK);

        String txt10 = attrsArray.getString(R.styleable.ColorTextViewAttrs_clt_txt10);
        int color10 = attrsArray.getColor(R.styleable.ColorTextViewAttrs_clt_color10, Color.BLACK);

        mSpaces = attrsArray.getBoolean(R.styleable.ColorTextViewAttrs_clt_spaces, false);

        String sep = "";
        if (mSpaces) sep = " ";

        addTextColor(txt1, color1, "");
        addTextColor(txt2, color2, sep);
        addTextColor(txt3, color3, sep);
        addTextColor(txt4, color4, sep);
        addTextColor(txt5, color5, sep);
        addTextColor(txt6, color6, sep);
        addTextColor(txt7, color7, sep);
        addTextColor(txt8, color8, sep);
        addTextColor(txt9, color9, sep);
        addTextColor(txt10, color10, sep);
    }

    private LinkedHashMap<String, Integer> getTxtColors() {
        if (mTxtColors == null) mTxtColors = new LinkedHashMap<>();
        return mTxtColors;
    }

//    private void setTxtColors(LinkedHashMap<String, Integer> txtColors) {
//        mTxtColors = txtColors;
//    }

    private void addTextColor(String text, int color, String sep) {
        if (text != null && text.trim().length() > 0 && color != 0) getTxtColors().put(sep + text, color);
    }

    public void apply(LinkedHashMap<String, Integer> txtColors) {
        if (txtColors == null) {
            Log.e("ColorTextView","strings & colors must be not null!");
            return;
        }
        for (Map.Entry<String, Integer> entry : txtColors.entrySet())
            addTextColor(entry.getKey(), ContextCompat.getColor(getContext(), entry.getValue()), isSpaces() ? " " : "");
        setColorWords();
    }

    public void setColorWords() {

        String text = "";
        for (Map.Entry<String, Integer> entry : getTxtColors().entrySet()) text += entry.getKey();
        Spannable s = new SpannableString(text);

        for (Map.Entry<String, Integer> entry : getTxtColors().entrySet()) {
            String str = entry.getKey();
            int color = entry.getValue();
            if (!TextUtils.isEmpty(str)) s.setSpan(new ForegroundColorSpan(color), text.indexOf(str), text.indexOf(str) + str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        setText(s, BufferType.SPANNABLE);
    }


}

