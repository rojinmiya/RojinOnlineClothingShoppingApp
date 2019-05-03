package Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rojinonlineclothingshoppingapp.Dashboard;
import com.rojinonlineclothingshoppingapp.MainActivity;
import com.rojinonlineclothingshoppingapp.R;

public class LoginFragment extends Fragment implements View.OnClickListener {

   private EditText etUsername, etPassword;
   private Button btnLogin, btnCancel;


    public LoginFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etUsername =view.findViewById(R.id.etUsername);
        etPassword=view.findViewById(R.id.etPassword);
        btnLogin=view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
        return view;
    }



    @Override
    public void onClick(View v) {
        checkUser();

    }

    private void checkUser(){
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("User",Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username", "");
        String password=sharedPreferences.getString("password", "");
        if(username.equals(etUsername.getText().toString())&&password.equals(etPassword.getText().toString())){
            Intent I=new Intent(getActivity(), Dashboard.class);
            startActivity(I);
        }
        else{
            Toast.makeText(getActivity(), "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
        }

    }


}
