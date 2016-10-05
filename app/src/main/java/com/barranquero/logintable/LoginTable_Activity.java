package com.barranquero.logintable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.barranquero.logintable.controller.LoginTable_Controller;

/**
 * This application uses the Model-View-Controller philosophy
 */
public class LoginTable_Activity extends AppCompatActivity {

    /**
     * Every instance variable name starts with 'm'
     */
    private LoginTable_Controller mloginTable_controller;
    private EditText medtUser;
    private EditText medtPassword;
    private Button mbtnOk;
    private Button mbtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_table);

        mloginTable_controller = new LoginTable_Controller();
        medtUser = (EditText)findViewById(R.id.edtUser);
        medtPassword = (EditText)findViewById(R.id.edtPassword);

        mbtnOk = (Button)findViewById(R.id.btnOk);
        mbtnOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String user = medtUser.getText().toString();
                String password = medtPassword.getText().toString();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password))
                    Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.data_empty), Toast.LENGTH_SHORT).show();
                else {
                    int result = mloginTable_controller.validateCredentials(user, password);
                    switch (result) {
                        case LoginTable_Controller.PASSWORD_DIGIT:
                            Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.password_digit), Toast.LENGTH_SHORT).show();
                            break;
                        case LoginTable_Controller.PASSWORD_CASE:
                            Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.password_case), Toast.LENGTH_SHORT).show();
                            break;
                        case LoginTable_Controller.PASSWORD_LENGTH:
                            Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.password_length), Toast.LENGTH_SHORT).show();
                            break;
                        case LoginTable_Controller.OK:
                            // The Activity would launch
                            break;
                    }
                }
            }
        });

        mbtnCancel = (Button)findViewById(R.id.btnCancel);
        mbtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetValues();
            }
        });
    }

    private void resetValues() {
        medtUser.setText("");
        medtPassword.setText("");
    }
}
