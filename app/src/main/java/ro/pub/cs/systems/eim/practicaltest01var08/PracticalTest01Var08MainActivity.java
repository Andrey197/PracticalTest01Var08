package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {

    private EditText riddleText = null;
    private EditText answerText = null;
    private Button playButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.play_button:
                    if (!riddleText.getText().toString().equals("") && !answerText.getText().toString().equals("")) {
                        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02PlayActivity.class);
                        String riddle = riddleText.getText().toString();
                        String answer = answerText.getText().toString();
                        intent.putExtra("riddleText", riddle);
                        intent.putExtra("answerText", answer);
                        startActivityForResult(intent, 1);
                        break;
                    }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        riddleText = (EditText)findViewById(R.id.riddle);
        answerText = (EditText)findViewById(R.id.answer);

        playButton = (Button)findViewById(R.id.play_button);
        playButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.RIDDLE)) {
                riddleText.setText(savedInstanceState.getString(Constants.RIDDLE));
            }
            if (savedInstanceState.containsKey(Constants.ANSWER)) {
                answerText.setText(savedInstanceState.getString(Constants.ANSWER));
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.RIDDLE, riddleText.getText().toString());
        savedInstanceState.putString(Constants.ANSWER, answerText.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.RIDDLE)) {
            riddleText.setText(savedInstanceState.getString(Constants.RIDDLE));
        }
        if (savedInstanceState.containsKey(Constants.ANSWER)) {
            answerText.setText(savedInstanceState.getString(Constants.ANSWER));
        }
    }
}
