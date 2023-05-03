package com.example.addpost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int GALLERY_REQ_CODE = 1000;
    ImageView imagePet;
    Button location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //gridlaout ส่วนหัวที่มี ปุ่ม X , newpost และ post
        TextView close = findViewById(R.id.closeButton);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //ชื่อหน้า New Post
        TextView post = findViewById(R.id.newPost);

        //ยังไม่เสร็จต้องเอาไว้ทำเช็คว่าใส่ข้อความครบหรือไม่
        Button postButton = findViewById(R.id.postButton);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //closelaout
        //ใส่ภาพจากโทรศัพธ์
        Button imageButton = findViewById(R.id.imageButton);
        imagePet = findViewById(R.id.imageInput);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK);
                gallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery,GALLERY_REQ_CODE);
            }
        });

        EditText namePet = findViewById(R.id.namePet);
        namePet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int i, int i1, int i2) {
                // ตรวจสอบการเปลี่ยนแปลงของข้อความและนำชื่อที่ผู้ใช้ป้อนไปใช้งาน
                String petName = text.toString();
                Log.d("EditText", "Pet name: " + petName);
            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        EditText detailPet = findViewById(R.id.detailPet);
        detailPet.setFilters(new InputFilter[] {
                new InputFilter.LengthFilter(200) // จำกัดจำนวนคำที่พิมพ์ได้ไม่เกิน 200 คำ
        });
        detailPet.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        //เลื่อนบรรทัดให้ 2 บรรทัด
        detailPet.setMaxLines(2);
        detailPet.setVerticalScrollBarEnabled(true);
        //การเลื่อนบรรทัดเมื่อพิมพ์ครบขอบเขตของ EditText จะเป็นการใช้ android:scrollbars
        detailPet.setMovementMethod(new ScrollingMovementMethod());
        detailPet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //gridlaout ส่วนที่ใส่รูป
        ImageView imageOne = findViewById(R.id.imageOne);
        imageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ImageView imageTwo = findViewById(R.id.imageTwo);
        imageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ImageView imageThree = findViewById(R.id.imageThree);
        imageThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ImageView imageFour = findViewById(R.id.imageFour);
        imageFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //closelaout
        // add Location
        location = findViewById(R.id.locationButton);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = new Intent(MainActivity.this, PageShowMap.class);
                startActivity(map);
            }
        });

        TextView gender = findViewById(R.id.genderPet);
        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //gridlaout
        CheckBox male = findViewById(R.id.malePet);
        CheckBox female = findViewById(R.id.femalePet);

        male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // ถ้าเลือก male ให้เคลียร์ femaleCheckBox
                    female.setChecked(false);
                }
            }
        });

        female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // ถ้าเลือก female ให้เคลียร์ maleCheckBox
                    male.setChecked(false);
                }
            }
        });

        //closelaout
        EditText color = findViewById(R.id.colorPet);
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        EditText breed = findViewById(R.id.breedPet);
        breed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        EditText weight = findViewById(R.id.weightPet);
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQ_CODE && resultCode == RESULT_OK && data != null) {
            imagePet.setImageURI(data.getData());
        }
    }
}