package com.hsakibgib.recyclerveiwcardveiw;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import static com.hsakibgib.recyclerveiwcardveiw.Data.getData;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private MyCustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0F9D58"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);

        recycler=findViewById(R.id.recycleView);
        adapter=new MyCustomAdapter(this,getData());
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id){

            case R.id.linearviewhorizontal:
                LinearLayoutManager llm= new LinearLayoutManager(this);
                llm.setOrientation(LinearLayoutManager.HORIZONTAL);
                recycler.setLayoutManager(llm);
                break;

            case R.id.linearviewvertical:
                LinearLayoutManager llv= new LinearLayoutManager(this);
                llv.setOrientation(LinearLayoutManager.VERTICAL);
                recycler.setLayoutManager(llv);
                break;

            case R.id.gridveiw:
                GridLayoutManager glm= new GridLayoutManager(this,2);
                recycler.setLayoutManager(glm);
                break;

            case R.id.staggered_view_horizontal:
                StaggeredGridLayoutManager sglm= new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
                recycler.setLayoutManager(sglm);
                break;
            case R.id.staggered_viewvertical:
                StaggeredGridLayoutManager sglmv= new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                recycler.setLayoutManager(sglmv);
                break;

        }//end of switch case
        return super.onOptionsItemSelected(item);
    }
}
