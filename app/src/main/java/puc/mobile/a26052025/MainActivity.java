package puc.mobile.a26052025;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configurarInterface();

        configurarListeners();
    }

    private void configurarInterface() {
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }

    private void configurarListeners() {

    }
}