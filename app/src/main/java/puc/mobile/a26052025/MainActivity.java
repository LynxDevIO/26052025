package puc.mobile.a26052025;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private ArrayList<User> usuarios = new ArrayList<>();
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configurarInterface();

        configurarListeners();
    }

    private void configurarInterface() {
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista_usuarios);
        adapter = new UserAdapter(this, usuarios);
        lista.setAdapter(adapter);

        String url = "https://jsonplaceholder.typicode.com/users";

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            try {
                for (int i = 0; i < response.length(); i++) {
                    JSONObject obj = response.getJSONObject(i);
                    String name = obj.getString("name");
                    String email = obj.getString("email");
                    String phone = obj.getString("phone");
                    usuarios.add(new User(name, email, phone));
                }
                adapter.notifyDataSetChanged();
            } catch (Exception e) {
                Toast.makeText(this, "Erro ao processar dados", Toast.LENGTH_SHORT).show();
            }
        }, error -> {
            Toast.makeText(this, "Erro de conexão", Toast.LENGTH_SHORT).show();
        });
    }

    private void configurarListeners() {

    }
}