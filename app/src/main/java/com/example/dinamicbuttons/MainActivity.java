package com.example.dinamicbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int numElementos=20; //Variables que tomaremos para indicar el nro de elementos que queremos añadir dinámicamente

    LinearLayout miContenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configView();
    }

    private void configView() {
        //Botón para marcar todos si fuese necesario

        //Capturo contenedor de botones
        miContenedor = findViewById(R.id.contenedorBotonera); //LinearLayout

        //Indicamos las propiedades que tendrán los elementos que inserte dentro de mi contenedor
        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //Creamos los elementos en bucle
        for(int i=0; i<numElementos; i++){
            CheckBox chk =  new CheckBox(this);
            //Asignamos las propiedades al elemento
            chk.setLayoutParams(lp);

            //Asignamos texto al elemento
            chk.setText("Checkbox " +String.format("%02d", i+1));

            //Para poder interaccionar con los botones le vamos a asignar un Listener
            chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(buttonView.isChecked()){
                        Toast.makeText(MainActivity.this, "Has marcado "+ chk.getText(), Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Has desmarcado "+ chk.getText(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            //Finalmente lo añadimos al contenedor
            miContenedor.addView(chk);
        }

    }
}