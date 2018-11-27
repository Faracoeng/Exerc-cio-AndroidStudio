package engtelecom.poo.camilla.primeiroaplicativo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCounter = 0; //m de modificável
    private TextView mTextViewConter;
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String CONTATOR_PREFS = "contadorSharedPrefs";
    private SharedPreferences mSharedPrefs;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause");

        SharedPreferences.Editor prefsEditor = mSharedPrefs.edit();
        prefsEditor.putInt("CONTADOR", mCounter);   //adiciona chave CONTADOR com o valor mCounter
                                                    //se já existir esse método sobrescreve o valor
        prefsEditor.apply();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "OnRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate");     //Log.d(LOG_TAG, "onStart");


        mSharedPrefs = getSharedPreferences(CONTATOR_PREFS, MODE_PRIVATE);  //pegar valor do disco
        mCounter = mSharedPrefs.getInt("CONTADOR", 0); //se nao existir essa chave, o contador recebe o valor zero


        //Para poder modificar o objeto do layout
        mTextViewConter = findViewById(R.id.TVCounter);

        this.mTextViewConter.setText(""+mCounter);

//
//        //Verificando se a hash-table possui algum valor guardado
//        if(savedInstanceState != null){
//            int count  = savedInstanceState.getInt("count");
//            if(mTextViewConter != null){
//                mTextViewConter.setText(""+count);
//                mCounter = count;
//            }
//        }
    }

    public void implementarContador(View view) {
        mCounter++;
        mTextViewConter.setText(Integer.toString(mCounter));
    }

    public void implementaSalto(View view) {
        //PARA ABRIR UM DIALOGO NA TELA
//        Toast toast = Toast.makeText(this, R.string.text, Toast.LENGTH_LONG);
//        toast.show();

        //PARA ABRIR LINKS NO NAVEGADOR PADRÃO
//        Uri uri = Uri.parse("http://docente.ifsc.edu.br/mello");
//        Intent it = new Intent(Intent.ACTION_VIEW,uri);
//        startActivity(it);

        //OBJETO QUE DISPARA NOVA ACTIVITY
        Intent intent = new Intent(this, SegundaActivity.class);

        //OBJETO ONDE POSSO GUARDAR INFO DESSA ACTIVITY PARA USAR EM OUTRAS
        //Funciona como uma hash-table
//        Bundle extras = new Bundle();
//        extras.putString("messageTAG", "Olá mundo!");
//        extras.putInt("contador", mCounter);

        //ADCIONANDO BUNDLE NO INTENT
//        intent.putExtras(extras);

//        startActivityForResult(intent, 20);

        //DISPARANDO NOVA ACTIVITY
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 20){
            if(resultCode == RESULT_OK){
                // colocar contador em zero
                mCounter = 0;
                mTextViewConter.setText(""+mCounter);
            }else if(resultCode == RESULT_CANCELED){
                //mantem o valor
                //imprimir no log que foi cancelado
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", mCounter);
    }



}