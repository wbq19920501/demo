package com.wbq.mvp;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by JokeepDeveloperAD on 2015-11-11.
 */
public class LoadDialog extends AlertDialog {

    private ImageView img_customprogress;

    protected LoadDialog(Context context, int theme) {
        super(context, theme);
    }

    public LoadDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_customprogress);

        img_customprogress = (ImageView) findViewById(R.id.img_customprogress);
        img_customprogress.setImageResource(R.drawable.load_animation);

        AnimationDrawable animationDrawable = (AnimationDrawable) img_customprogress.getDrawable();
        animationDrawable.start();
    }
}
