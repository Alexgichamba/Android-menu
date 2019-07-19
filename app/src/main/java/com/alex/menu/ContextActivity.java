package com.alex.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContextActivity extends AppCompatActivity {

    ListView listView;
    String contacts[]={"Lucy", "Kamau", "John", "Mercy", "Alex", "Ngibuini", "Gichamba", "Omega", "Speedmaster", "Seamaster"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);

        listView = (ListView)findViewById(R.id.l_view);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,contacts );

        listView.setAdapter(adapter);

        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        menu.setHeaderTitle("Select action to Contacts");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.call){
            Toast.makeText(this, "Calling", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.sms){
            Toast.makeText(this, "Messaging", Toast.LENGTH_SHORT).show();
        }else{
            return false;
        }
        return true;
    }
}
