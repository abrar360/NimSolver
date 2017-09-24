package com.abrar.nimsolver;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    public Button button1;
    public TextView input, output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)this.findViewById(R.id.button);
        input = (EditText)this.findViewById(R.id.textView2);
        output = (TextView)this.findViewById(R.id.textView3);
        button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        output.setText(solveGrid(input.getText().toString()));

                    }
                }
        );



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String solveGrid(String input){
//Scanner scan = new Scanner(System.in);
//System.out.println("Enter Stack values: (comma separated)");
//String stacks = scan.nextLine();
        String[] rawStack = input.split(",");
        String[] board = new String[rawStack.length];
        int max = -1;
        for (int i = 0; i < rawStack.length; i++){
            rawStack[i] = rawStack[i].trim();
            board[i] = Integer.toString(Integer.parseInt(rawStack[i]), 2);
            if(max < board[i].length())
                max = board[i].length();

        }

        for (int j = 0; j < rawStack.length; j++){
            while(board[j].length() < max){
                board[j] = "0" + board[j];
            }

        }

        int[] X = new int[max];
        for (int o = 0; o < max; o++){
            int count = 0;
            for (int k = 0; k < rawStack.length; k++){
                if (board[k].charAt(o) == '1')
                    count++;
            }
            X[o] = count%2;
        }


        int[] result = new int[rawStack.length];

        for (int q = 0; q < rawStack.length; q++){
            String binary = "";
            for (int w = 0; w < max; w++){
                binary = binary + String.valueOf((X[w] + (int)(board[q].charAt(w)))%2);
            }
            if(Integer.parseInt(board[q], 2) > Integer.parseInt(binary, 2)){
                return "Remove " + (Integer.parseInt(board[q], 2)-Integer.parseInt(binary, 2)) + " from stack " + (q+1);

            }

        }
        return "No moves";
    }
}
