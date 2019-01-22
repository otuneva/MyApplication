package ru.jvalter.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread th= new Thread(new Thread1());
        th.start();
    }
    class Thread1 implements Runnable
    {
        public Thread1()
        {

        }
        @Override
        public void run()
        {
            InputStream stream;
            URL url;
            try {
                url = new URL("http://myitschool.ru/book/pluginfile.php/11010/mod_book/chapter/420/341_pic_1.png");
                stream= (InputStream)url.getContent();
                final Bitmap b=BitmapFactory.decodeStream(stream);
//                final ImageView iV= (ImageView) findViewById(R.id.imageView);
//                iV.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        iV.setImageBitmap(b);
//                    }
//                });
//
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
