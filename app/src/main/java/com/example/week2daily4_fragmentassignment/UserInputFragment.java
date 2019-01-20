package com.example.week2daily4_fragmentassignment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserInputFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class UserInputFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    EditText userNameEditText, userEmailEditText, userPasswordEditText;
    Button addUserButton;

    public UserInputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userNameEditText = view.findViewById(R.id.userNameEditTextId);
        userEmailEditText = view.findViewById(R.id.userEmailEditTextId);
        userPasswordEditText = view.findViewById(R.id.userPasswordEditTextId);

        addUserButton = view.findViewById(R.id.addUserButtonId);

        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed();
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {

            String name = userNameEditText.getText().toString();
            String email = userEmailEditText.getText().toString();
            String password = userPasswordEditText.getText().toString();

            User user = new User(name, email, password);
            mListener.sendToActivity(user);

            userNameEditText.setText("");
            userEmailEditText.setText("");
            userPasswordEditText.setText("");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void sendToActivity(User user);
    }
}
