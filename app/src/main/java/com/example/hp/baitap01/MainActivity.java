package com.example.hp.baitap01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtTienHD;
    Button btnTru;
    Button btnCong;
    TextView txtPhanTram;
    TextView txtTienHoaHong;
    TextView txtTongTien;
    private float tienHoaDon;
    private float phanTram;
    private float tongTien;
    private float tienHoaHong;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListener();

    }
    private void init(){
        tienHoaDon=0;
        phanTram =0;
        tongTien =0;
        tienHoaHong =0;
        edtTienHD= (EditText) findViewById(R.id.edtTienHoaDon);
        btnTru= (Button) findViewById(R.id.btnMinus);
        btnCong = (Button) findViewById(R.id.btnPlus);
        txtPhanTram= (TextView) findViewById(R.id.txtKhongPhanTram);
        txtTienHoaHong = (TextView) findViewById(R.id.txtTienHoaHong01);
        txtTongTien= (TextView) findViewById(R.id.txtTongTien01);
    }
    private void addListener(){
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMinus: {
                if (phanTram >0){
                    if (edtTienHD.getText()==null || edtTienHD.getText().toString().isEmpty()){
                        Toast.makeText(this, "Vui lòng nhập tiền hóa đơn!", Toast.LENGTH_SHORT).show();
                    }else {
                        tienHoaDon=Integer.parseInt(edtTienHD.getText().toString());
                    }
                    phanTram -=1;
                    tienHoaHong = phanTram /100* tienHoaDon;
                    tongTien= tienHoaDon+tienHoaHong;

                    txtPhanTram.setText(phanTram +"%");
                    txtTienHoaHong.setText("$"+tienHoaHong);
                    txtTongTien.setText("$"+tongTien);
                }
                else {
                    Toast.makeText(this, "Tiền hoa hồng không được âm nhé  :))", Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.btnPlus: {
                if (phanTram <100){
                    if (edtTienHD.getText()==null || edtTienHD.getText().toString().isEmpty()){
                        Toast.makeText(this, "Vui lòng nhập tiền hóa đơn!", Toast.LENGTH_SHORT).show();
                    }else {
                        tienHoaDon=Integer.parseInt(edtTienHD.getText().toString());
                    }
                    phanTram +=1;
                    tienHoaHong = phanTram /100* tienHoaDon;
                    tongTien= tienHoaDon+tienHoaHong;

                    txtPhanTram.setText(phanTram +"%");
                    txtTienHoaHong.setText("$"+tienHoaHong);
                    txtTongTien.setText("$"+tongTien);
                }
                else {
                    Toast.makeText(this, "Chỉ được bo 100 thui cậu ơi :))", Toast.LENGTH_SHORT).show();
                }
                break;
            }

        }

    }
}
