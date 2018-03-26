package com.example.nambd.bai1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by NamBD on 3/26/2018.
 */

public class SquareFragment extends Fragment implements CompoundButton.OnCheckedChangeListener, View.OnFocusChangeListener {
    private EditText edtEdge;
    private EditText edtResult;
    private CheckBox cbPerimeter;
    private CheckBox cbAcreage;

    private float a;

    public static SquareFragment newInstance() {
        SquareFragment squareFragment = new SquareFragment();
        return squareFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_square, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        edtEdge = view.findViewById(R.id.edt_Edge);
        cbAcreage = view.findViewById(R.id.checkbox_acreage);
        edtResult = view.findViewById(R.id.edt_result);
        cbPerimeter = view.findViewById(R.id.checkbox_perimeter);
        cbAcreage.setOnCheckedChangeListener(this);
        cbPerimeter.setOnCheckedChangeListener(this);
        edtEdge.setOnFocusChangeListener(this);
    }

    private void getData() throws Exception {
        String sA = edtEdge.getText().toString();
        a = Float.parseFloat(sA);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            switch (compoundButton.getId()) {
                case R.id.checkbox_acreage: {
                    cbPerimeter.setChecked(false);
                    handlAcreage();
                    break;
                }
                case R.id.checkbox_perimeter: {
                    cbAcreage.setChecked(false);
                    handlPerimeter();
                    break;
                }
            }
        }
    }

    private void handlPerimeter() {
        try {
            getData();
            edtResult.setText((a * 4) + "");
        } catch (Exception e) {
            Toast.makeText(this.getContext(), "Error format ! ", Toast.LENGTH_SHORT).show();
            cbPerimeter.setChecked(false);
            cbAcreage.setChecked(false);
            edtEdge.setText("");
        }
    }

    private void handlAcreage() {
        try {
            getData();
            edtResult.setText((a * a) + "");
        } catch (Exception e) {
            Toast.makeText(this.getContext(), "Error format ! ", Toast.LENGTH_SHORT).show();
            cbPerimeter.setChecked(false);
            cbAcreage.setChecked(false);
            edtEdge.setText("");
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b) {
            cbPerimeter.setChecked(false);
            cbAcreage.setChecked(false);
        }
    }
}
