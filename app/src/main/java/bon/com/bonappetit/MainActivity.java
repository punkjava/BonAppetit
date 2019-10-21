package bon.com.bonappetit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etEmail,etPassword;
    Button btnLogin;
    private AppCompatTextView textViewLinkRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();

    }

    private void initViews() {
        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);
        etEmail = (EditText)findViewById(R.id.editText);
        etPassword = (EditText)findViewById(R.id.editText2);
        btnLogin = (Button)findViewById(R.id.appCompatButtonLogin);
    }

    private void initListeners() {

        textViewLinkRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }



    private boolean emptyValidate(EditText etEmail, EditText etPassword){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        return (email.isEmpty() && password.isEmpty());
    }


    @Override
    public void onClick(View v) {

        String username = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);

        switch (v.getId()) {

            case R.id.textViewLinkRegister:
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(getApplicationContext(), uregister.class);
                startActivity(intentRegister);
                break;
        }

    }


}

