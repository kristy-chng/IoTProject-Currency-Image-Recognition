package com.example.iotprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

public class ResultsActivity extends AppCompatActivity {

    ImageView image;
    TextView results_textview;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_results);

        results_textview = (TextView) findViewById(R.id.results_text);
        image = (ImageView) findViewById(R.id.image_placeholder);
        setImagePlaceholder();
    }

    public void setImagePlaceholder() {
        Bundle extras = getIntent().getExtras();
        Uri myUri = Uri.parse(extras.getString("image"));
        String results = extras.getString("resultsText");

        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), myUri);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                results_textview.setText(results);
                image.setImageBitmap(bitmap);
            }
        });
    }

}