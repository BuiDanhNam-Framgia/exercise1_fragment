package com.example.nambd.bai1;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Created by NamBD on 3/26/2018.
 */

public class CalculateFramgment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    private EditText edtNumA;
    private EditText edtNumB;
    private EditText edtResult;
    private ImageButton imgSelect;
    private float a, b;

    public static CalculateFramgment newInstance() {
        CalculateFramgment calculateFramgment = new CalculateFramgment();
        return calculateFramgment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tinhtoan, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        edtResult = view.findViewById(R.id.tv_result_);
        edtNumA = view.findViewById(R.id.edt_number_A);
        edtNumB = view.findViewById(R.id.edt_number_B);
        imgSelect = view.findViewById(R.id.img_tinhtoan);
        imgSelect.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View view) {
        PopupMenu popupMenu = new PopupMenu(this.getContext(), view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_tinhtoan, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        getData();
        switch (menuItem.getItemId()) {
            case R.id.tv_Sum:
                handlSum();
                break;
            case R.id.tv_subtraction:
                handlSub();
                break;
            case R.id.tv_multiplication:
                handlMult();
                break;
            case R.id.tv_division:
                hanlDivi();
                break;
        }
        return true;
    }

    private void handlSub() {
        edtResult.setText((a - b) + "");
    }

    private void handlMult() {
        edtResult.setText((a * b) + "");

    }

    private void hanlDivi() {
        if (b == 0) {
            Toast.makeText(getContext(), "Divide by zero error encountered ", Toast.LENGTH_SHORT).show();
        } else
            edtResult.setText((a / b) + "");

    }

    private void handlSum() {
        edtResult.setText((a - b) + "");

    }

    private void getNumA() throws Exception {
        String sA = edtNumA.getText().toString();
        a = Float.parseFloat(sA);
    }

    private void getNumB() throws Exception {
        String sB = edtNumB.getText().toString();
        b = Float.parseFloat(sB);
    }

    public void getData() {
        try {
            getNumA();
        } catch (Exception e) {
            Toast.makeText(this.getContext(), "Error format ! ", Toast.LENGTH_SHORT).show();
            edtResult.setText("");
        }
        try {
            getNumB();
        } catch (Exception e) {
            Toast.makeText(this.getContext(), "Error format ! ", Toast.LENGTH_SHORT).show();
            edtResult.setText("");
        }
    }
}
