package com.sdacademy.gieysztor.michal.picasso2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermissions();

        imageView1 = (ImageView) findViewById(R.id.image_view1);
        imageView2 = (ImageView) findViewById(R.id.image_view2);
        imageView3 = (ImageView) findViewById(R.id.image_view3);
        imageView4 = (ImageView) findViewById(R.id.image_view4);
        imageView5 = (ImageView) findViewById(R.id.image_view5);

        Picasso.with(this)
                .load("https://goo.gl/JfEm9H")
                .into(imageView1);

        Picasso.with(this)
                .load(R.drawable.san_francisco)
                .into(imageView2);

        Picasso.with(this)
                .load("file:///storage/emulated/0/DCIM/Camera/a20170227_184321.jpg")
                .into(imageView3);

        Picasso.with(this)
                .load("https://goo.gl/JfElasflmsandlasdnlm9H")
                .error(R.drawable.error)
                .into(imageView4);

//        Picasso.with(this)
//                .load("https://goo.gl/JfEm9H")
//                .fit()
//                .centerInside()
//                .into(imageView1);
//
//        Picasso.with(this)
//                .load("https://goo.gl/JfEm9H")
//                .fit()
//                .centerCrop()
//                .into(imageView2);
//
//        Picasso.with(this)
//                .load("https://goo.gl/JfEm9H")
//                .fit()
//                .into(imageView3);
//
//        Picasso.with(this)
//                .load("https://goo.gl/JfEm9H")
//                .resize(300, 50)
//                .into(imageView4);
//
//        Picasso.with(this)
//                .load("https://goo.gl/JfEm9H")
//                .rotate(60)
//                .into(imageView5);

    }

    public void checkPermissions() {
        int status = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (status == PackageManager.PERMISSION_GRANTED) {
            Picasso.with(this)
                    .load("file:///storage/emulated/0/DCIM/Camera/a20170227_184321")
                    .into(imageView3);
        } else {
            String[] allPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(this, allPermissions, 5);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 5) {
            int result = grantResults[0];
            if (result == PackageManager.PERMISSION_GRANTED) {
                Picasso.with(this)
                        .load("file:///storage/emulated/0/DCIM/Camera/a20170227_184321.jpg")
                        .into(imageView3);
            }
        }
    }
}
