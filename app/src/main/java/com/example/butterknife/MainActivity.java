 package com.example.butterknife;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.OnTouch;

 public class MainActivity extends AppCompatActivity {

     private static final String TAG = "MainActivity";
     private int count = 0;

     @BindView(R.id.textView)
     TextView textView;

     @BindViews({ R.id.firstNameTextView, R.id.lastNameTextView })
     List<TextView> nameTextViews;

     @BindViews({ R.id.button1, R.id.button2, R.id.button3})
     List<Button> nameButtons;

     @BindString(R.string.app_name)
     String str;

     @BindView(R.id.imageView)
     ImageView imageView;

     @BindDrawable(R.drawable.ic_launcher_background)
     Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
      //textView = findViewById(R.id.textView);
      //textView.setText("blah blah blah");

        textView.setText("blah blah blah...");
        
        for( TextView textView : nameTextViews ) {
            Log.e(TAG, " on Create : " + textView.getText());
        }

      //String str = getResources().getString(R.string.app_name);
        textView.setText(str);

        imageView.setImageDrawable(drawable);

        for( Button button : nameButtons ) {
            Log.e(TAG, "button : "+button.getText());
        }
    }

    @OnClick(R.id.button)
    void buttonClick() {
        Toast.makeText(this,"button clicked", Toast.LENGTH_SHORT).show();
    }
    
    @OnLongClick(R.id.button)
     void onLongClick() {
        Toast.makeText(this ,"On Long Click",Toast.LENGTH_LONG).show();
    }
    
    @OnTouch({R.id.textView, R.id.firstNameTextView, R.id.lastNameTextView})
    void onTouch(View view){
        switch(view.getId()) {
            case R.id.textView:
                Toast.makeText(this, "on touch : textView Clicked" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.firstNameTextView:
                Toast.makeText(this, "on touch : firstNameTextView Clicked" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.lastNameTextView:
                Toast.makeText(this, "on touch : lastNameTextView Clicked" , Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @OnClick({ R.id.button1, R.id.button2, R.id.button3})
     void OnCount() {
        Log.e(TAG, String.valueOf(count));
        count++;
    }
}
