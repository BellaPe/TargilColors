package com.example.android.targilcolors;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout LiLayout = (LinearLayout) findViewById(R.id.LiLayout);
        RelativeLayout board = new RelativeLayout(this);
        RelativeLayout.LayoutParams relParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        board.setLayoutParams(relParams);
        board.setGravity(RelativeLayout.CENTER_HORIZONTAL);
        LiLayout.addView(board);

        int a1 = 1, b = 2, c = 3, d = 4;
        Button btn = new Button(this);
        btn.setId(a1);
        Button btn2 = new Button(this);
        btn2.setId(b);
        Button btn3 = new Button(this);
        btn3.setId(c);
        Button btn4 = new Button(this);
        btn4.setId(d);

        RelativeLayout.LayoutParams btnParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams btnParams2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams btnParams3 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams btnParams4 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //btnParams.addRule(RelativeLayout.CENTER_VERTICAL);
        btn.setLayoutParams(btnParams);
        btn.setText("Diagonals");
        board.addView(btn);
        //btnParams2.addRule(RelativeLayout.CENTER_VERTICAL);
        btnParams2.addRule(RelativeLayout.ALIGN_LEFT, btn.getId());
        btnParams2.addRule(RelativeLayout.BELOW, btn.getId());
        btn2.setLayoutParams(btnParams2);
        btn2.setText("Border");
        board.addView(btn2);
        //btnParams3.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btnParams3.addRule(RelativeLayout.ALIGN_BOTTOM, btn.getId());
        btnParams3.addRule(RelativeLayout.RIGHT_OF, btn.getId());
        btn3.setLayoutParams(btnParams3);
        btn3.setText("DownPart");
        board.addView(btn3);
        //btnParams4.addRule(RelativeLayout.CENTER_VERTICAL);
        btnParams4.addRule(RelativeLayout.BELOW, btn3.getId());
        btnParams4.addRule(RelativeLayout.RIGHT_OF, btn2.getId());
        btn4.setLayoutParams(btnParams4);
        btn4.setText("UpperPart");
        board.addView(btn4);

        //-------------------
        TableLayout tl = new TableLayout(this);
        LinearLayout.LayoutParams tlParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        tl.setLayoutParams(tlParams);
        final Button [][] arr = new Button[3][3];
        View.OnClickListener  myOnClickListener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSetColor_onClick(view, arr);
            }
        };
        btn.setOnClickListener(myOnClickListener);
        btn2.setOnClickListener(myOnClickListener);
        btn3.setOnClickListener(myOnClickListener);
        btn4.setOnClickListener(myOnClickListener);
        for(int i=0; i<arr.length; i++){
            TableRow a = new TableRow(this);
            TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.WRAP_CONTENT, //todo the width with the px stuff
                    TableLayout.LayoutParams.WRAP_CONTENT);
            a.setLayoutParams(trParams);
            for(int j=0; j<arr.length;j++){
                arr[i][j] = new Button(this);
                arr[i][j].setText("");
                a.addView(arr[i][j]);
            }
            tl.addView(a);
        }

        LiLayout.addView(tl);}

    public void buttonSetColor_onClick(View view, Button [][] arr) {
        reset(arr);
        String Where = (String) ((Button) view).getText();
        Resources resources = getResources();
        int color = 0;
        switch (Where) {
            case "Diagonals": {
                color = resources.getColor(R.color.colorAccent, getTheme());
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if (i == j)
                            arr[i][j].setBackgroundColor(color);
                        if ((i + j) == arr.length - 1)
                            arr[i][j].setBackgroundColor(color);
                    }
                }break;}
            case "Border": {
                color = resources.getColor(R.color.colorAccent, getTheme());
                for (int i = 0; i < arr.length; i++)
                {for (int j = 0; j < arr.length; j++) {
                    if (!(i==1&&j==1))
                        arr[i][j].setBackgroundColor(color);
                }
                }
                break;
            }
            case "UpperPart": {
                color = resources.getColor(R.color.colorAccent, getTheme());
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if ((i + j) == arr.length - 1)
                            arr[i][j].setBackgroundColor(color);
                        arr[0][0].setBackgroundColor(color);
                        arr[1][0].setBackgroundColor(color);
                        arr[0][1].setBackgroundColor(color);
                    }
                }
                break;
            }
            case "DownPart": {
                color = resources.getColor(R.color.colorAccent, getTheme());
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if ((i + j) == arr.length - 1)
                            arr[i][j].setBackgroundColor(color);
                        arr[1][2].setBackgroundColor(color);
                        arr[2][1].setBackgroundColor(color);
                        arr[2][2].setBackgroundColor(color);
                    }
                }
                break;
            }
        }

    }
    public void reset( Button [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j].setBackgroundColor(0);
            }
        }
    }
}
