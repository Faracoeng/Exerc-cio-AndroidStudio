package engtelecom.poo.camilla.primeiroaplicativo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TerceiraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);
    }

    public void implementaSalto(View view) {
        Intent messageIntent = new Intent(this, QuartaActivity.class);
        startActivity(messageIntent);
    }
}
