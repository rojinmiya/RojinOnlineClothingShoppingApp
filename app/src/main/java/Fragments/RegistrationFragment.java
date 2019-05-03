package Fragments;

import android.content.Context;
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

import com.rojinonlineclothingshoppingapp.R;

import static android.content.Context.MODE_PRIVATE;


public class RegistrationFragment extends Fragment implements View.OnClickListener {

private EditText etUsername, etPassword;
private Button btnRegistration, btncancel;




    public RegistrationFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        etUsername =view.findViewById(R.id.etUsername);
        etPassword=view.findViewById(R.id.etPassword);
        btnRegistration=view.findViewById(R.id.btnRegistration);


        btnRegistration.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        SignUp();
    }
    private void SignUp(){

        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("username",etUsername.getText().toString());
        editor.putString("password",etPassword.getText().toString());
        editor.commit();
        Toast.makeText(getActivity(),"Successfully Registered", Toast.LENGTH_SHORT).show();


    }
}
