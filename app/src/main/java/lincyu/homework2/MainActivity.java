package lincyu.homework2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Button submit;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        result = (TextView)findViewById(R.id.tv_result);
        input = (EditText)findViewById(R.id.et_input);
        submit = (Button)findViewById(R.id.btn_submit);
        submit.setOnClickListener(calcResult);
    }

    private OnClickListener calcResult = new OnClickListener() {

        @Override
        public void onClick(View v) {

            String input_str =input.getText().toString();
            input.setText("");

            if (input_str.length() == 0) {
                Toast.makeText(MainActivity.this,
                        R.string.input_error,
                        Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                Toast.makeText(MainActivity.this,
                        "Hello " + input_str,
                        Toast.LENGTH_SHORT).show();
                return;
            }
        }
    };

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

        switch (item.getItemId()) {
        case R.id.action_About:
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle("About this APP");
            ad.setMessage("\nAuthor : Wan-Yun Cheng");

            DialogInterface.OnClickListener listener =
                new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface di, int i) {
                }
            };

            ad.setPositiveButton("OK", listener);
            ad.show();
            break;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Settings) {
            return true;
        }

        if (id == R.id.action_Reset) {
            input.setText("");
        }

        return super.onOptionsItemSelected(item);
    }
}
