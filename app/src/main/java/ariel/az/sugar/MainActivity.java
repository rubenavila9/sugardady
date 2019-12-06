package ariel.az.sugar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button ButtonGuardar, ButtonModificar, ButtonEliminar,
    ButtonConsultaGeneral, ButtonconsultaIndividual, ButtoneliminarTodo;
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
        ButtonConsultaGeneral = findViewById(R.id.buttonConsultaGeneral);
        ButtonconsultaIndividual = findViewById(R.id.buttonconsultaIndividual);
        ButtonEliminar = findViewById(R.id.buttonEliminar);
        ButtoneliminarTodo = findViewById(R.id.buttoneliminarTodo);

        ButtonconsultaIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = Book.findById(
                Book.class,
                        Long.parseLong(editTextID.getText().toString()
                        ));
                editTextTitulo.setText(book.getTitle());
                editTextEdicion.setText(book.getEdition());
            }
        });
        ButtonConsultaGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BooklistActivity.class);
                startActivity(intent);
            }
        });

        ButtonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = Book.findById(Book.class, Long.parseLong("1"));
                book.title = "update  title here";
                book.edition = "3rd edition";
                book.save();
            }
        });

        ButtonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book registro1 = new Book(
                        editTextTitulo.getText().toString(),
                        editTextEdicion.getText().toString());
                registro1.save();
                Log.e("Guardar", "Datos guardados!");
            }
        });
        ButtonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = Book.findById(Book.class, Long.parseLong("1"));
                book.delete();
            }

        });




    }

}
