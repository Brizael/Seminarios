package br.bybrizael.trabalhoseminarios;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciando e atribuindo a variavel do nosso BottomNavigation
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        Button popUpMenu_bottom = findViewById(R.id.popUp_menu);

        //Selecionando nossa Home criado em nosso menu bottomnav.xml
        bottomNav.setSelectedItemId(R.id.home);

        //Fazendo nossa troca de activity apos selecionar algum dos items do nosso menu que esta na nossa BottomNavigation
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.rewards:
                        startActivity(new Intent(getApplicationContext(), Rewards.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(), Settings.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        /* Pop Up menu items */
        PopupMenu popupMenu = new PopupMenu(
                this,
                popUpMenu_bottom
        );
        popupMenu.getMenuInflater().inflate(R.menu.popupitems, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.feliz){
                    Toast.makeText(MainActivity.this, "Estou feliz", Toast.LENGTH_LONG).show();
                }else if (id==R.id.normal){
                    Toast.makeText(MainActivity.this, "Estou normal", Toast.LENGTH_LONG).show();
                }else if (id==R.id.triste){
                    Toast.makeText(MainActivity.this, "Estou triste", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
        popUpMenu_bottom.setOnClickListener((view) -> {
            popupMenu.setForceShowIcon(true);
            popupMenu.show();
        });

    }
}