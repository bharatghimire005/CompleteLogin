package com.example.bharatghimire.completelogin.activity;

import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bharatghimire.completelogin.R;
import com.example.bharatghimire.completelogin.utlity.LoginUtility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {
    @BindView(R.id.edittext_email)
    EditText mEditTextEmail;
    @BindView(R.id.edittext_password)
    EditText mEditTextPassWord;
    @BindView(R.id.edittext_user_name)
    EditText mEditTextUserName;
    @BindView(R.id.edittext_contact_number)
    EditText mEditTextContactNumber;

    @BindView(R.id.textinputlayout_contact_number)
    TextInputLayout mTextInputContactNumber;


    @BindView(R.id.textinputlayout_password)
    TextInputLayout mTextInputPassword;

    @BindView(R.id.textinputlayout_name)
    TextInputLayout mTextInputName;

    @BindView(R.id.textinputlayout_email)
    TextInputLayout mTextInputEmail;

    @BindView(R.id.button_signup)
    Button mButtonSignUp;
    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mActivity = this;
        ButterKnife.bind(mActivity);
        mButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation()){

                }
            }
        });
    }


    /**
     * Validate Login and show proper message on the basis of the error
     * @return boolean value true if validation is success and false if validation is failed.
     */
    private boolean validation() {
        if (!LoginUtility.isValidEmail(mEditTextEmail.getText().toString())) {
            mTextInputEmail.setErrorEnabled(true);
            mTextInputEmail.setError("Enter Valid Email Id");
            return false;
        }
        if (!LoginUtility.isFieldEmpty(mEditTextPassWord.getText().toString())) {
            mTextInputPassword.setErrorEnabled(true);
            mTextInputPassword.setError("Password field should not be Empty");
            return false;
        }
        if (!LoginUtility.isFieldEmpty(mEditTextContactNumber.getText().toString())) {

            mTextInputContactNumber.setErrorEnabled(true);
            mTextInputContactNumber.setError("Contact Number should not be Empty");
            return false;
        }
        if (!LoginUtility.isValidEmail(mEditTextUserName.getText().toString())) {
            mTextInputPassword.setErrorEnabled(true);
            mTextInputPassword.setError("UserName should not be empty");
            return false;
        }
        return true;
    }
}
