package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class PracticalTest01Var02PlayActivity extends AppCompatActivity {

    private EditText riddleText = null;
    private EditText answerText = null;
    private Button checkButton = null;
    private Button backButton = null;
    private String answer = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.check_button:
                    if (answerText.getText().toString().equals(answer)) {
                        Toast.makeText(getApplicationContext(), "Este corect", Toast.LENGTH_LONG).show();
                        break;
                    }
                case R.id.back_button:
                    setResult(RESULT_CANCELED, null);
                    finish();
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_play);

        riddleText = (EditText) findViewById(R.id.riddle_play);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("riddleText") && intent.getExtras().containsKey("answerText")) {
            String riddle = intent.getStringExtra("riddleText");
            answer = intent.getStringExtra("answerText");
            riddleText.setText(riddle);
        }

        answerText = (EditText) findViewById(R.id.answer_play);
        checkButton = (Button) findViewById(R.id.check_button);
        backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(buttonClickListener);
        checkButton.setOnClickListener(buttonClickListener);
    }
}
