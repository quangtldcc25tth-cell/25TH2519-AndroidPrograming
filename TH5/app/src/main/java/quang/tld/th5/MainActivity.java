package quang.tld.vd2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // khai bao cac doi tuong gan voi dieu khien tuong ung
    EditText edtso1;
    EditText edtso2;
    EditText edtsKQ;
    Button nutCong, nutTru, nutNhan, nutChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TiemDieuKhien();
    }
    void TiemDieuKhien(){
        edtso1 = (EditText)findViewById(R.id.Edtso1);
        edtso2 = (EditText)findViewById(R.id.Edtso2);
        edtsKQ = (EditText)findViewById(R.id.EdtKetQua);
        nutCong = (Button) findViewById(R.id.BtnCong);
        nutTru = (Button) findViewById(R.id.BtnTru);
        nutNhan = (Button) findViewById(R.id.BtnNhan);
        nutChia = (Button) findViewById(R.id.BtnChia);

    }

    // xử lý cộng
    public void SuLyCong(View V){
        //code xu ly
        // b1. lay du lieu 2 sp
        // b1.1 tim EditText so 1 va 2
//        EditText editTextso1 = (EditText)findViewById(R.id.Edtso1);
//        EditText editTextso2 = (EditText)findViewById(R.id.Edtso2);
        // b1.2. lay du lieu tren
        String So1 = edtso1.getText().toString();
        String So2 = edtso2.getText().toString();
        // b1.3 chuyen chuoi sang so
        float SoA = Float.parseFloat(So1);
        float SoB = Float.parseFloat(So2);
        // b2 tinh toan
        float tong = SoA + SoB;
        // b3 hien ket qua
//        EditText editTextKQ = (EditText)findViewById(R.id.EdtKetQua);
        // b3.2. chuan bi du lieu
        String chuoiKQ = String.valueOf(tong);
        // b3.3. gan ket qua len dieu khien
        edtsKQ.setText(chuoiKQ);
    }
    // xử lý Trừ
    public void SuLyTru(View V){
        //code xu ly
        // b1. lay du lieu 2 sp
        // b1.1 tim EditText so 1 va 2
//        EditText editTextso1 = (EditText)findViewById(R.id.Edtso1);
//        EditText editTextso2 = (EditText)findViewById(R.id.Edtso2);
        // b1.2. lay du lieu tren
        String So1 = edtso1.getText().toString();
        String So2 = edtso2.getText().toString();
        // b1.3 chuyen chuoi sang so
        float SoA = Float.parseFloat(So1);
        float SoB = Float.parseFloat(So2);
        // b2 tinh toan
        float tru = SoA - SoB;
        // b3 hien ket qua
//        EditText editTextKQ = (EditText)findViewById(R.id.EdtKetQua);
        // b3.2. chuan bi du lieu
        String chuoiKQ = String.valueOf(tru);
        // b3.3. gan ket qua len dieu khien
        edtsKQ.setText(chuoiKQ);
    }
    // xử lý nhân
    public void SuLyNhan(View V){
        //code xu ly
        // b1. lay du lieu 2 sp
        // b1.1 tim EditText so 1 va 2
//        EditText editTextso1 = (EditText)findViewById(R.id.Edtso1);
//        EditText editTextso2 = (EditText)findViewById(R.id.Edtso2);
        // b1.2. lay du lieu tren
        String So1 = edtso1.getText().toString();
        String So2 = edtso2.getText().toString();
        // b1.3 chuyen chuoi sang so
        float SoA = Float.parseFloat(So1);
        float SoB = Float.parseFloat(So2);
        // b2 tinh toan
        float nhan = SoA * SoB;
        // b3 hien ket qua
//        EditText editTextKQ = (EditText)findViewById(R.id.EdtKetQua);
        // b3.2. chuan bi du lieu
        String chuoiKQ = String.valueOf(nhan);
        // b3.3. gan ket qua len dieu khien
        edtsKQ.setText(chuoiKQ);
    }
    // xử lý chia
    public void SuLyChia(View V){
        //code xu ly
        // b1. lay du lieu 2 sp
        // b1.1 tim EditText so 1 va 2
//        EditText editTextso1 = (EditText)findViewById(R.id.Edtso1);
//        EditText editTextso2 = (EditText)findViewById(R.id.Edtso2);
        // b1.2. lay du lieu tren
        String So1 = edtso1.getText().toString();
        String So2 = edtso2.getText().toString();
        // b1.3 chuyen chuoi sang so
        float SoA = Float.parseFloat(So1);
        float SoB = Float.parseFloat(So2);
        // b2 tinh toan
        float chia = SoA / SoB;
        // b3 hien ket qua
//        EditText editTextKQ = (EditText)findViewById(R.id.EdtKetQua);
        // b3.2. chuan bi du lieu
        String chuoiKQ = String.valueOf(chia);
        // b3.3. gan ket qua len dieu khien
        edtsKQ.setText(chuoiKQ);
    }
}