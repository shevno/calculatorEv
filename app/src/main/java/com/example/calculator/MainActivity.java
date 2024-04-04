package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button num0,num1,num2,num3,num4,num5,num6,num7,num8,num9,plos,minos,kafol,div,shave,delete,open,close,point,delete2;
    TextView resultView;

    int countersograim = 0;
    int countersograim2 = 0;

    boolean flag = false;

        String result = "";




            @SuppressLint("MissingInflatedId")
            @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_main);


                resultView = (TextView) findViewById(R.id.show);

                        num0 = (Button) findViewById(R.id.num0);
                        num1 = (Button) findViewById(R.id.num1);
                        num2 = (Button) findViewById(R.id.num2);
                        num3 = (Button) findViewById(R.id.num3);
                        num4 = (Button) findViewById(R.id.num4);
                        num5 = (Button) findViewById(R.id.num5);
                        num6 = (Button) findViewById(R.id.num6);
                        num7 = (Button) findViewById(R.id.num7);
                        num8 = (Button) findViewById(R.id.num8);
                        num9 = (Button) findViewById(R.id.num9);
                        plos = (Button) findViewById(R.id.plos);
                        minos = (Button) findViewById(R.id.minos);
                        kafol = (Button) findViewById(R.id.kafol);
                        div = (Button) findViewById(R.id.div);
                        shave = (Button) findViewById(R.id.shave);
                        delete = (Button) findViewById(R.id.del);
                        close = (Button) findViewById(R.id.close);
                        open = (Button) findViewById(R.id.open);
                        point = (Button) findViewById(R.id.point);
                        delete2 = (Button) findViewById(R.id.delete2);





                num0.setOnClickListener(this::onClick);
                        num1.setOnClickListener(this::onClick);
                        num2.setOnClickListener(this::onClick);
                        num3.setOnClickListener(this::onClick);
                        num4.setOnClickListener(this::onClick);
                        num5.setOnClickListener(this::onClick);
                        num6.setOnClickListener(this::onClick);
                        num7.setOnClickListener(this::onClick);
                        num8.setOnClickListener(this::onClick);
                        num9.setOnClickListener(this::onClick);
                        plos.setOnClickListener(this::onClick);
                        minos.setOnClickListener(this::onClick);
                        kafol.setOnClickListener(this::onClick);
                        div.setOnClickListener(this::onClick);
                        shave.setOnClickListener(this::onClick);
                        delete.setOnClickListener(this::onClick);
                        close.setOnClickListener(this::onClick);
                        open.setOnClickListener(this::onClick);
                        point.setOnClickListener(this::onClick);
                        delete2.setOnClickListener(this::onClick);



            }





            public void onClick(View v) {
            if(flag){
                result = "";
                flag = false;
            }





                    if (v == num0){
                        result+= "0";

                    } else if (v == num1) {
                        result+= "1";

                    } else if (v == num2) {
                        result+= "2";

                    } else if (v == num3) {
                        result+= "3";

                    } else if (v == num4) {
                        result+= "4";

                    } else if (v == num5) {
                        result+= "5";

                    } else if (v == num6) {
                        result+= "6";

                    } else if (v == num7) {
                        result+= "7";

                    } else if (v == num8) {
                        result+= "8";

                    } else if (v == num9) {
                        result+= "9";

                    }else if (v == close) {
                        result+= ")";
                        countersograim2--;


                    }else if (v == open) {
                        result+= "(";

                        countersograim++;
                        countersograim2++;


                    } else if (v == plos) {
                        result+= "+";


                    }else if (v == minos) {
                        result+= "-";


                    }else if (v == kafol) {
                        result+= "*";


                    }else if (v == div) {
                        result+= "/";


                    }else if (v == point) {
                        if(result.charAt(result.length()-1) == '(' || result.charAt(result.length()-1)==')' || result.charAt(result.length()-1)=='+' || result.charAt(result.length()-1)=='-' || result.charAt(result.length()-1)=='/' || result.charAt(result.length()-1)=='*'){
                            result+= "0.";
                        }else{
                            result+= ".";
                        }



                    }else if (v == delete2) {
                        String res = "";
                        for(int i = 0; i < result.length()-1;i++){
                            res+=result.charAt(i);
                        }

                        result = res;
                        res = "";


                    }else if (v == shave) {
                        try {
                            if(countersograim2 == 0){


                                calcRes(result);
                                result ="";


                                countersograim2 =0;
                                countersograim = 0;
                            }else{
                                result = "";
                                resultView.setText("error");
                                countersograim2 =0;
                                countersograim = 0;
                            }


                        }
                        catch (Exception e){
                            result = "";
                            countersograim2 =0;
                            countersograim = 0;
                            resultView.setText("error");

                        }


                    }else if (v == delete) {
                        clear();
                    }
                    if(v != shave){
                        resultView.setText(result);
                    }







            }


    public String orderclosers(String[] str)
    {
        int counter = 0,mikom1 = 0,mikom2 = 0 ;
        boolean flag1 = false,flag7 = false;

        for(int y = 0;y < countersograim;y++) {

            for (int i = 0; i < str.length; i++) {
                if (str[i].equals("(")) {

                    mikom1 = i;
                    flag7 = true;


                    counter++;

                } else if (str[i].equals(")")) {
                    flag7 = true;


                    mikom2 = i;
                    if (i == str.length - 1) {
                        flag1 = true;
                    }
                    break;

                }
            }
            if (flag7) {


                String[] result3 = new String[mikom2 - mikom1 - 1];

                for (int j = mikom1 + 1; j < mikom2; j++) {
                    result3[j - mikom1 - 1] = str[j];

                }
                str[mikom1] = ActionOrder(result3);
                for (int i = mikom1 + 1; i < str.length; i++) {
                    if (i + mikom2 - mikom1 > str.length - 1) {
                        str[i] = null;
                    } else {
                        str[i] = str[i + mikom2 - mikom1];

                    }

                }
                int counternull = 0;


                for (int n = 0; n < str.length; n++) {
                    if (str[n] == null) {
                        counternull++;
                    }
                }
                String[] result5 = new String[str.length - counternull];
                for (int z = 0; z < result5.length; z++) {

                    result5[z] = str[z];
                }
                str = new String[result5.length];

                for (int z = 0; z < result5.length; z++) {

                    str[z] = result5[z];
                }

            }
        }






        int counternull = 0;


        for (int n= 0; n < str.length; n++){
            if (str[n] == null){
                counternull++;
            }
        }
        String[] result6 = new String[str.length-counternull];
        for (int z= 0; z < result6.length; z++){

            result6[z] = str[z];
        }



        return (ActionOrder(result6));




    }



            public void calcRes(String result) {

                        String[] result1 = new String[result.length()*2];
                        String result2 = "";
                        int counter = 0;
                        boolean flag4 = false;



                        boolean flag2 = false, flag3 = false;

                            for (int i = 0; i < result.length(); i++) {



                                if(result.charAt(i) == '('  ){

                                    if(result.charAt(i-1) != '+' && result.charAt(i-1) != '-' && result.charAt(i-1) != '*' && result.charAt(i-1) != '/' && result.charAt(i-1) != '('){
                                        if(result.charAt(i-1) != ')'){
                                            result1[counter] = result2;
                                            counter++;
                                        }



                                        result1[counter] = String.valueOf('*');
                                        counter++;
                                    }
                                    result1[counter] = String.valueOf(result.charAt(i));
                                    result2 = "";
                                    counter++;
                                    flag2 = true;


                                } else if (result.charAt(i) == ')') {
                                    if(flag3 == false) {
                                        result1[counter] = result2;
                                        counter++;
                                    }
                                    result1[counter] = String.valueOf(result.charAt(i));
                                    counter++;
                                    flag3 = true;

                                    flag2 = true;

                                } else if (result.charAt(i) == '+' || result.charAt(i) == '-' || result.charAt(i) == '*' || result.charAt(i) == '/' ){
                                    if(!flag2){

                                        if(result2 == "" ){
                                            flag4=true;
                                            result2+=String.valueOf(result.charAt(i));
                                        }else {
                                            result1[counter] = result2;
                                            counter++;
                                        }
                                    }
                                    if(!flag4){
                                        result1[counter] = String.valueOf(result.charAt(i));
                                        result2 = "";
                                        counter++;
                                    }else{
                                        flag4 = false;
                                    }




                                }
                                else{

                                    result2 += String.valueOf(result.charAt(i));
                                    flag2 = false;
                                    flag3 = false;


                                }


                            }
                            if(flag2 == false){
                                result1[counter] = result2;

                            }

                        int counternull = 0;


                        for (int n= 0; n < result1.length; n++){
                            if (result1[n] == null){
                                counternull++;
                            }
                        }
                        String[] result3 = new String[result1.length-counternull];
                        for (int z= 0; z < result3.length; z++){

                            result3[z] = result1[z];
                        }



                        resultView.setText(orderclosers(result3));












            }
    public String ActionOrder(String[] str){




        int counter = 2;

        for(int i = 0; i < str.length; i++){
            if(str[i] == null){
                break;
            }

            if(str[i].equals("*")){
                str[i-1] = String.valueOf(Double.parseDouble(str[i-1])*Double.parseDouble(str[i+1]));
                if(str.length > i+3){
                    for (int y = i+2; y < str.length; y++){
                        str[y-2] = str[y];
                    }
                }

                for(int z = 1; z <= counter; z++){
                    str[str.length-z] = null;

                }
                if(str[i] != null){
                    if(str[i].equals("*")||str[i].equals("/")){
                        i--;
                        counter += 2;
                    }
                    else{
                        counter = 2;
                    }

                }

            }
            else if (str[i].equals("/")) {
                str[i-1] = String.valueOf(Double.parseDouble(str[i-1])/Double.parseDouble(str[i+1]));
                if(str.length > i+3){
                    for (int y= i+2; y < str.length; y++){
                        str[y-2] = str[y];
                    }
                }


                str[str.length-1] = null;
                str[str.length-2] = null;

                for(int c = 1; c <= counter; c++){
                    str[str.length-c] = null;
                }
                if(str[i] != null){
                    if(str[i].equals("*")||str[i].equals("/")){
                        i--;
                        counter += 2;
                    }
                    else{
                        counter = 2;
                    }

                }

            }

        }
        int counternull = 0;


        for (int n= 0; n < str.length; n++){
            if (str[n] == null){
                counternull++;
            }
        }
        String[] result5 = new String[str.length-counternull];
        for (int z= 0; z < result5.length; z++){

            result5[z] = str[z];
        }
        str = new String[result5.length];
        for (int z= 0; z < result5.length; z++){

            str[z] = result5[z];
        }
        double  sec,zover = Double.parseDouble(str[0]);




        for (int x= 2; x < result5.length; x = x+2){

            sec = Double.parseDouble(str[x]);
            if (str[x - 1].equals("+") ) {
                zover = zover  + sec;
            } else if (str[x - 1].equals("-")) {
                zover = zover  - sec;
            }


        }
        if(zover%1 == 0){
            flag = true;
            return(String.valueOf((int)zover));
        }
        else {
            flag = true;
            return(String.valueOf(zover));

        }

    }
    private void clear()
    {

        resultView.setText("");
        flag = flag;
        result = "";
    }

}





