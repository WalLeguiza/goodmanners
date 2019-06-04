package ar.edu.unaj.goodmanners;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    private TextView txt_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        //Option selected in the other activity
        int option;

        //Associate the instances with UI
        txt_message = (TextView) findViewById(R.id.txt_message);

        //Get the parameter
        Bundle bundle = getIntent().getExtras();
        option = bundle.getInt("option");

        //Change the message
        updateMessage(option);
    }

    public void updateMessage (int option) {
        switch (option) {
            case 0:
                txt_message.setText(R.string.message1);
                break;
            case 1:
                txt_message.setText(R.string.message2);
                break;
            case 2:
                txt_message.setText(R.string.message3);
                break;
            case 3:
                txt_message.setText(R.string.message4);
                break;
        }
    }

}
