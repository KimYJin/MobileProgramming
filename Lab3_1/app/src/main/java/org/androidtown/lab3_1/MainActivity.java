package org.androidtown.lab3_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btn;

    //
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //make reference to Button btn which is defined in Layout
        btn=(Button)findViewById(R.id.btn);

        //Register the View to which the context menu should be associated
        registerForContextMenu(btn);
    }

    //When the registered view receives a long-click event, the system calls this method
    //create context menu and add menu items to the menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){

        super.onCreateContextMenu(menu,v,menuInfo);

        menu.setHeaderTitle("Button Menu");

        // The four arguments of the add() method
        // GroupID, Item ID, order , title
        menu.add(0,0,0,"Red");
        menu.add(0,1,1,"Green");
        menu.add(0,2,2,"Blue");
    }

    //When the user selects a menu item, the system calls this method
    //triggers to change text color
    public boolean onContextItemSelected(MenuItem item){

        //get ID of item using Item.getItemID()
        switch(item.getItemId()) {
            case 0:
                btn.setTextColor(Color.RED);
               break;
            case 1:
                btn.setTextColor(Color.GREEN);
                break;
            case 2:
                btn.setTextColor(Color.BLUE);
                break;

            default: break;
        }
        return super.onContextItemSelected(item);
    }
}

