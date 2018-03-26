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

public class RectangularFragment extends Fragment implements CompoundButton.OnCheckedChangeListener, View.OnFocusChangeListener {
    private EditText edtLength;
    private EditText edtWidth;
    private EditText edtResult;
    private CheckBox cbPerimeter;
    private CheckBox cbAcreage;
    private float a, b;

    public static RectangularFragment newInstance() {
        RectangularFragment rectangularFragment = new RectangularFragment();
        return rectangularFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_rectangular, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        edtLength = view.findViewById(R.id.edt_length);
        edtWidth = view.findViewById(R.id.edt_width);
        edtResult = view.findViewById(R.id.edt_ketqua);
        cbPerimeter = view.findViewById(R.id.cb_perimeter);
        cbAcreage = view.findViewById(R.id.cb_acreage);
        cbAcreage.setOnCheckedChangeListener(this);
        cbPerimeter.setOnCheckedChangeListener(this);
        edtLength.setOnFocusChangeListener(this);
        edtWidth.setOnFocusChangeListener(this);
    }

    private void getDataChieuDai() throws Exception {
        String sA = edtLength.getText().toString();
        a = Float.parseFloat(sA);
    }

    private void getDataChieuRong() throws Exception {
        String sB = edtWidth.getText().toString();
        b = Float.parseFloat(sB);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            switch (compoundButton.getId()) {
                case R.id.cb_perimeter: {
                    cbAcreage.setChecked(false);
                    handlPerimeter();
                    break;
                }
                case R.id.cb_acreage: {
                    cbPerimeter.setChecked(false);
                    handlAcreage();
                    break;
                }
            }
        }
    }

    private void handlPerimeter() {
        getData();
        if (a > 0 && b > 0) {
            edtResult.setText(2 * (a + b) + "");
        } else {
            Toast.makeText(getContext(), "Error < 0 ", Toast.LENGTH_SHORT).show();
        }
    }

    private void handlAcreage() {
        getData();
        if (a > 0 && b > 0) {
            edtResult.setText((a * b) + "");
        } else {
            Toast.makeText(getContext(), "Error < 0 ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }

    public void getData() {
        try {
            getDataChieuDai();
        } catch (Exception e) {
            Toast.makeText(this.getContext(), "Error format ! ", Toast.LENGTH_SHORT).show();
            cbPerimeter.setChecked(false);
            cbAcreage.setChecked(false);
            edtLength.setText("");
            edtResult.setText("");
        }
        try {
            getDataChieuRong();
        } catch (Exception e) {
            Toast.makeText(this.getContext(), "Error format ! ", Toast.LENGTH_SHORT).show();
            cbPerimeter.setChecked(false);
            cbAcreage.setChecked(false);
            edtWidth.setText("");
            edtResult.setText("");
        }
    }
}
