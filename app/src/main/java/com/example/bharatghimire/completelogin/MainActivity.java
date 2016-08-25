package com.example.bharatghimire.completelogin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bharatghimire.completelogin.activity.SignUpActivity;
import com.example.bharatghimire.completelogin.thirdpartysignin.GoogleSignIn;
import com.example.bharatghimire.completelogin.utlity.LoginUtility;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 9001;
    @BindView(R.id.edittext_email)
    EditText mEditTextEmail;
    @BindView(R.id.edittext_password)
    EditText mEditTextPassword;
    @BindView(R.id.button_login)
    Button mButtonLogin;

    @BindView(R.id.textview_signup)
    TextView mTextViewSignUp;

    Activity mActivity;
    ProgressDialog progressDialog;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mActivity = this;
        findViewById(R.id.signInGoogle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(mActivity);
                progressDialog.show();
                new GoogleSignIn(mActivity);
            }
        });
        findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()) {
                    //// TODO: 12/8/16 Add code to validate email from the server
                }
            }
        });

        mTextViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mActivity, SignUpActivity.class));
            }
        });
    }


    /**
     * Validate Login and show proper message on the basis of the error
     * @return boolean value true if validation is success and false if validation is failed.
     */
    private boolean isValid() {
        if (!LoginUtility.isFieldEmpty(mEditTextPassword.getText().toString())) {
            Toast.makeText(mActivity, "Password field should not be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!LoginUtility.isValidEmail(mEditTextEmail.getText().toString())) {
            Toast.makeText(mActivity, "Not a valid email id ", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            progressDialog.dismiss();
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                Log.e(TAG, "onActivityResult: Sucess");
                GoogleSignInAccount account = result.getSignInAccount();
                account.getEmail();
                Log.e(TAG, "onActivityResult: " + account.getEmail());
                // firebaseAuthWithGoogle(account);
            } else {
                Log.e(TAG, "onActivityResult: failure");
                // Google Sign In failed, update UI appropriately
                // [START_EXCLUDE]
                //updateUI(null);
                // [END_EXCLUDE]
            }
        }
    }


}
