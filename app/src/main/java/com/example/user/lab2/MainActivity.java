package com.example.user.lab2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText gamer;
    TextView status;
    RadioButton   radioButton;
    RadioButton   radioButton2;
    RadioButton   radioButton3;
    RadioGroup radioGroup;
    Button play;
    TextView name;
    TextView winner;
    TextView myMora;
    TextView computerMora;
    int mora_gamer = -1;
    String [] MoraString ={"剪刀","石頭","布"};
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gamer =(EditText) findViewById(R.id.editText);
        status =(TextView) findViewById(R.id.textView);
        radioButton=(RadioButton) findViewById(R.id.radioButton);
        radioButton2=(RadioButton) findViewById(R.id.radioButton2);
        radioButton3=(RadioButton) findViewById(R.id.radioButton3);
        radioGroup =(RadioGroup) findViewById( R.id.radioGroup);
        play =(Button) findViewById(R.id.button);
        name = (TextView) findViewById(R.id.textView6);
        winner= (TextView) findViewById(R.id.textView7 );
        myMora =(TextView) findViewById(R.id.textView8);
        computerMora = (TextView) findViewById(R.id.textView9) ;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radioButton:
                        mora_gamer=0;
                        break;
                    case R.id.radioButton2:
                        mora_gamer=1;
                        break;


                    case R.id.radioButton3:
                        mora_gamer=2;
                        break;

                }

            }
        }



         );

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if (gamer.getText().toString().equals(""))
                 status.setText("請選擇玩家名稱");
             else if (mora_gamer == -1)
                 status.setText("請選擇出拳種類");
             else {
                 name.setText(gamer.getText());
                 myMora.setText(MoraString[mora_gamer]);
                 int mora_computer =(int) (Math.random()%3);
                 computerMora.setText(MoraString[mora_computer]);
                 if ((mora_gamer == 0 && mora_computer ==1)||(mora_gamer ==1 && mora_computer ==2)||(mora_gamer ==2 && mora_computer ==0))
                 {
                     winner.setText("電腦");
                     status.setText("可惜電腦贏了");
                 }
                 else if (mora_gamer == mora_computer)
                 {
                     winner.setText("平局");
                     status.setText("平局!在try一場試試");
                 }
                 else {
                     winner.setText(gamer.getText());
                     status.setText("YOU WIN");
                 }
             }
            }
        });

    }

}
