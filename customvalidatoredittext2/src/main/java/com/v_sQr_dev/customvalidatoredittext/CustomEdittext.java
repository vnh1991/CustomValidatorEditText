package com.v_sQr_dev.customvalidatoredittext;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ViVek on 22-Aug-17.
 */

public class CustomEdittext {
    LinearLayout container;
    LayoutInflater inflater;
    Context ctx;
    TextView lblErr;
    android.support.design.widget.TextInputEditText inputEditText;
    android.support.design.widget.TextInputLayout inputLayout;

    public CustomEdittext(LinearLayout container, Context ctx) {
        this.container = container;
        this.ctx = ctx;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = (View) inflater.inflate(R.layout.layout_edittext, null);
        container.addView(v);
        lblErr = (TextView) v.findViewById(R.id.lbl_err);
        inputLayout = (android.support.design.widget.TextInputLayout) v.findViewById(R.id.input_layout_container);
        inputEditText = (android.support.design.widget.TextInputEditText) v.findViewById(R.id.input_pwd);
        inputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                isValid();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void hidePasswordToggle(boolean flag) {
        if (flag) {
            inputLayout.setPasswordVisibilityToggleEnabled(false);
        } else {
            lblErr.setVisibility(View.GONE);
            inputLayout.setPasswordVisibilityToggleEnabled(true);

        }
    }

    public void setHint(String hint) {
        inputEditText.setHint(hint);
        lblErr.setTypeface(lblErr.getTypeface(), Typeface.ITALIC);
    }

    public void setErrorMsg(String errMsg) {
        if (errMsg.trim().length() > 0) {
            hidePasswordToggle(true);
            lblErr.setVisibility(View.VISIBLE);
            lblErr.setText(errMsg);
            lblErr.setTextColor(ctx.getResources().getColor(R.color.colorRed));
            inputEditText.setHintTextColor(ctx.getResources().getColor(R.color.colorRed));
            inputEditText.setTextColor(ctx.getResources().getColor(R.color.colorRed));
            inputLayout.setBackground(ctx.getResources().getDrawable(R.drawable.border_red));
        }
    }

    public void setInputTypeText() {
        inputEditText.setInputType(InputType.TYPE_CLASS_TEXT);
    }

    public void setInputTypePwd() {
        inputEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    public void isValid() {
        hidePasswordToggle(false);
        inputEditText.setHintTextColor(ctx.getResources().getColor(R.color.colorEdtGray));
        inputLayout.setBackground(ctx.getResources().getDrawable(R.drawable.border_white_button));
        inputEditText.setTextColor(ctx.getResources().getColor(R.color.colorBlack));
    }

    public boolean validate() {
        String val = inputEditText.getText().toString();

        if (val.trim().length() == 0) {
            setErrorMsg("Required Field");
            return false;
        } else {
            return true;
        }
    }

    public void setFontSize(float size) {
        inputEditText.setTextSize(size);
    }

    public void setFontFamily(String font, int typeFace) {
        inputEditText.setTypeface(Typeface.create(font, typeFace));
    }

    public void setCustomHeight(int size) {
        inputEditText.setHeight(size);
    }

    public void setCustomWidth(int size) {
        inputEditText.setWidth(size);
    }

    public String getText() {
        return inputEditText.getText().toString();
    }

    public void setText(String txt) {
        inputEditText.setText(txt);
    }

}
