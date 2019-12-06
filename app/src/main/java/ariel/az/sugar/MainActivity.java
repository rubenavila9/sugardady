package ariel.az.sugar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button ButtonGuardar, ButtonModificar, ButtonEliminar,
    ButtonConsultaGenral;
    EditText editTextTitulo, editTextEdicion, editTextID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitulo = findViewById(R.id.editTextTitulo);
        editTextEdicion = findViewById(R.id.editTextEdicion);
        editTextID = findViewById(R.id.editTextID);
        ButtonGuardar = findViewById(R.id.buttonGuardar);
        ButtonModificar = findViewById(R.id.buttonModificar);
        ButtonEliminar = findViewById(R.id.buttonEliminar);
        ButtonConsultaGenral = findViewById(R.id.buttonConsultaGeneral);

        ButtonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book registro1 = new Book(
                    editTextTitulo.getText().toString(),
                    editTextEdicion.getText().toString());
                registro1.save();
                    Log.e("Guardar", "Datos guardados");
                }
        });

    }
}
