package ar.edu.unaj.goodmanners;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    //Instances to handle the buttons
    private Button btn_send;
    private RadioGroup rg_answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Associate the instances to the interface
        btn_send = (Button) findViewById(R.id.btn_send);
        rg_answers = (RadioGroup) findViewById(R.id.rg_answers);

        //Register a Listener for the button
        btn_send.setOnClickListener(sendListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private OnClickListener sendListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            //Get value of RadioGroup
            int radioButtonId = rg_answers.getCheckedRadioButtonId();
            View radioButton = rg_answers.findViewById(radioButtonId);

            //RadioButton index select
            int indexRB = rg_answers.indexOfChild(radioButton);

            //Open the activity
            Intent intent = new Intent (MainActivity.this, MessageActivity.class);
            Bundle b = new Bundle();
            b.putInt("option", indexRB);
            intent.putExtras(b);
            startActivity(intent);
        }
    };
}
