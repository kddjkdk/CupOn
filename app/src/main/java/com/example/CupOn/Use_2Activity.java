package com.example.CupOn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.CupOn.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.EnumMap;
import java.util.Map;

public class Use_2Activity extends AppCompatActivity {
    ImageView Back, Mypage;
    TextView mileageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        Back = (ImageView) findViewById(R.id.back);
        Mypage = (ImageView) findViewById(R.id.mypage);
        mileageView = (TextView)findViewById(R.id.mileageView);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), Use_2Activity.class));
            }
        });

        //바코드 사용
        ImageView barcode = findViewById(R.id.imgV_bar);
        ImageView qrcode = findViewById(R.id.imgV_qr);

        String barcode_data = "1234567890";

        // barcode image
        try {
            Bitmap bitmap_bar = encodeAsBitmap(barcode_data , BarcodeFormat.CODE_128 , 600 , 140);
            barcode.setImageBitmap(bitmap_bar);

            Bitmap bitmap_qr = encodeAsBitmap(barcode_data , BarcodeFormat.QR_CODE , 600 , 600);
            qrcode.setImageBitmap(bitmap_qr);

        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

    // 배경 색상
    private static final int WHITE = 0xFFFFFFFF;
    // 바코드 색상
    private static final int BLACK = 0xFF000000;

    private Bitmap encodeAsBitmap(String contents, BarcodeFormat format, int img_width, int img_height) throws WriterException {
        String contentsToEncode = contents;
        if (contentsToEncode == null) {
            return null;
        }
        Map<EncodeHintType, Object> hints = null;
        String encoding = guessAppropriateEncoding(contentsToEncode);
        if (encoding != null) {
            hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            hints.put(EncodeHintType.CHARACTER_SET, encoding);
        }
        MultiFormatWriter writer = new MultiFormatWriter();

        BitMatrix result;
        try {
            result = writer.encode(contentsToEncode, format, img_width, img_height, hints);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }
        int width = result.getWidth();
        int height = result.getHeight();
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

    private static String guessAppropriateEncoding(CharSequence contents) {
        // Very crude at the moment
        for (int i = 0; i < contents.length(); i++) {
            if (contents.charAt(i) > 0xFF) {
                return "UTF-8";
            }
        }
        return null;
    }


}
